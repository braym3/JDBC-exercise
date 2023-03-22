package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO {

	private String url, username, password;

	public DAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public abstract List<Object> read();

	public int delete(int id) {
		try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword());) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM pet WHERE id=?");

			stmt.setInt(1, id);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
