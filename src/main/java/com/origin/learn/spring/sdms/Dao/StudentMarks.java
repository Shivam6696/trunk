package com.origin.learn.spring.sdms.Dao;

public class StudentMarks {
	private int rollnumber;
	private int maths;
	private int english;
	private int hindi;
	private int science;
	private String subject;
	private int subjectmax;
	private int maxmarks;
	private float obtainedmarks;
	private float percentage;
	
	
	
		
	

	public StudentMarks(String subject) {
		super();
		this.subject = subject;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
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
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSubjectmax() {
		return subjectmax;
	}
	public void setSubjectmax(int subjectmax) {
		this.subjectmax = subjectmax;
	}
	
	
	@Override
	public String toString() {
		return "StudentMarks [rollnumber=" + rollnumber + ", maths=" + maths + ", english=" + english + ", hindi="
				+ hindi + ", science=" + science + ", subject=" + subject + ", subjectmax=" + subjectmax + ", maxmarks="
				+ maxmarks + ", obtainedmarks=" + obtainedmarks + ", percentage=" + percentage + "]";
	}
	
    
	
}
