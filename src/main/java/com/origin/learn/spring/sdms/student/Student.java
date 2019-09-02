package com.origin.learn.spring.sdms.student;

public class Student {

	private int id;
	private String name;
	private String Father_Name;
	private String address;
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
	public String getFather_Name() {
		return Father_Name;
	}
	public void setFather_Name(String father_Name) {
		Father_Name = father_Name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Father_Name=" + Father_Name + ", address=" + address + "]";
	}
	
	
	 
	

}
