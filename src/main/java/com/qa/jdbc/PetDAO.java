package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
			int id, age;
			String name, colour, breed = "";

			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM pet");

			while (results.next()) {
				id = results.getInt(1);
				name = results.getString("name");
				age = results.getInt("age");
				colour = results.getString("colour");
				breed = results.getString("breed");

				pets.add(new Pet(id, name, age, colour, breed));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pets;
	}
}
