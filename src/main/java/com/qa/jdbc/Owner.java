package com.qa.jdbc;

public class Owner {
	private int id, age;
	private String name;

	public Owner(int id, String name, int age) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
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

}
