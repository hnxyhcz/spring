package com.hnxyhcz.ioc.entity;

public class People2 {

	private int id;
	private String name;
	private int age;
	private String className;
	
	public People2() {
		System.out.println("≥ı ºªØPeople");
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "People2 [id=" + id + ", name=" + name + ", age=" + age
				+ ", className=" + className + "]";
	}

}
