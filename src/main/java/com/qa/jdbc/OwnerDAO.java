package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO extends DAO {

	public OwnerDAO(String url, String username, String password) {
		super(url, username, password);
	}

	@Override
	public List<Object> read() {
		List<Object> owners = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(this.getUrl(), this.getUsername(), this.getPassword());) {

			// try to retrieve all records in owner
			int id, age;
			String name = "";

			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM `owner`");

			while (results.next()) {
				id = results.getInt(1);
				name = results.getString("name");
				age = results.getInt("age");

				owners.add(new Owner(id, name, age));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return owners;
	}
}
