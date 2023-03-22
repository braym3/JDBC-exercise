package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

	private String url, username, password;

	public PetDAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public List<Pet> read() {
		List<Pet> pets = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password);) {

			// try to retrieve all records in pet
			int id, age, ownerID;
			String name, colour, breed = "";

			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM pet");

			while (results.next()) {
				id = results.getInt(1);
				name = results.getString("name");
				age = results.getInt("age");
				colour = results.getString("colour");
				breed = results.getString("breed");
				ownerID = results.getInt("owner_id");

				pets.add(new Pet(id, name, age, colour, breed, ownerID));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

	public int create(String name, int age, String colour, String breed, int ownerID) {
		try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password);) {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO pet (name, age, colour, breed, owner_id) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, colour);
			stmt.setString(4, breed);
			stmt.setInt(5, ownerID);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(int id, String name, int age, String colour, String breed, int ownerID) {

		try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password);) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE pet SET name=?, age=?, colour=?, breed=?, owner_id=? WHERE id=?");

			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setString(3, colour);
			stmt.setString(4, breed);
			stmt.setInt(5, ownerID);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password);) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM pet WHERE id=?");

			stmt.setInt(1, id);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
