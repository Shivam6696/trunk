package com.origin.learn.spring.sdms.Dao;

public class StudentAllDetails {
	private int rollNumber;
	private String name;
	private String subject;
	private int obtainedMarks;
	private int maxMarks;
	private int percentage;

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "StudentAllDetails [rollNumber=" + rollNumber + ", name=" + name + ", subject=" + subject
				+ ", obtainedMarks=" + obtainedMarks + ", maxMarks=" + maxMarks + ", percentage=" + percentage + "]";
	}

	

	
	}


