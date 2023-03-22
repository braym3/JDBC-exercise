package com.qa.jdbc;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		PetDAO dao = new PetDAO("jdbc:mysql://localhost:3306/jdbc-exercise", "root", "pass");

		// Add new pet
		// System.out.println(dao.create("Laycie", 10, "Brown/White", "Manx", 3));

		// Delete pet
		// System.out.println(dao.delete(4));

		// List all pets
		List<Pet> pets = dao.read();
		for (Pet p : pets) {
			System.out.println(p.toString());
		}

		// Update record - Change Elvis' age to 11
		// System.out.println(dao.update(3, "Elvis", 11, "Black", "Siamese", 2));

	}

}
