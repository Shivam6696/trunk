package com.origin.learn.spring.sdms.Dao;

public class Student {

	private int rollnumber;
	private String name;
	private String fatherName;
	private String address;
	
	
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", name=" + name + ", fatherName=" + fatherName + ", address=" + address + "]";
	}
	
	
	 
	

}
