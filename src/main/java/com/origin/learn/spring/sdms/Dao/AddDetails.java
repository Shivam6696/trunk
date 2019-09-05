package com.origin.learn.spring.sdms.Dao;

public class AddDetails {
	private int rollnumber;
	private String subject;
	private int maxmarks;
	private float obtainedmarks;
	private float percentage;
	private String name;
	public AddDetails(int rollnumber, String subject, int maxmarks, float obtainedmarks, float percentage,
			String name) {
		super();
		this.rollnumber = rollnumber;
		this.subject = subject;
		this.maxmarks = maxmarks;
		this.obtainedmarks = obtainedmarks;
		this.percentage = percentage;
		this.name = name;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AddDetails [rollnumber=" + rollnumber + ", subject=" + subject + ", maxmarks=" + maxmarks
				+ ", obtainedmarks=" + obtainedmarks + ", percentage=" + percentage + ", name=" + name + "]";
	}
	
	
}
