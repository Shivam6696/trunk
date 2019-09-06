package com.origin.learn.spring.sdms.Dao;

public class StudentData {
	private int rollnumber;
	private String name;
	private String fatherName;
	private String address;
	private String subject;
	private int maxmarks;
	private float obtainedmarks;
	private float percentage;

	public StudentData(int rollnumber, String name, String fatherName, 
			String address, String subject, int maxmarks,
			float obtainedmarks) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.subject = subject;
		this.maxmarks = maxmarks;
		this.obtainedmarks = obtainedmarks;
	}
			
	
	

	public StudentData() {
		super();
	}




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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(int maxmarks) {
		this.maxmarks = maxmarks;
	}

	public float getObtainedmarks() {
		return obtainedmarks;
	}

	public void setObtainedmarks(float obtainedmarks) {
		this.obtainedmarks = obtainedmarks;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "StudentData [rollnumber=" + rollnumber + ", name=" + name + ", fatherName=" + fatherName + ", address="
				+ address + ", subject=" + subject + ", maxmarks=" + maxmarks + ", obtainedmarks=" + obtainedmarks
				+ ", percentage=" + percentage + "]";
	}

}
