package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-exercise", "root", "pass");

			// try to retrieve all records in pet
			List<Pet> pets = new ArrayList<>();
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

			for (Pet p : pets) {
				System.out.println(p.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
