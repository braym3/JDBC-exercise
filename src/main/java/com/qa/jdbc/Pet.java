package com.qa.jdbc;

public class Pet {
	private int id, age;
	private String name, colour, breed;

	public Pet(int id, String name, int age, String colour, String breed) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setColour(colour);
		this.setBreed(breed);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", age=" + age + ", name=" + name + ", colour=" + colour + ", breed=" + breed + "]";
	}

}
