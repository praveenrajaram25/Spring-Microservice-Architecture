package com.college.student.model;

import java.util.List;

public class StudentProfile {
	
	String id;
	String name;
	String admissionType;
	String batch;
	String year;
	String department;
	String feesStatus;
	List<Course> courses;
	List<FeesHistory> fees;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the admissionType
	 */
	public String getAdmissionType() {
		return admissionType;
	}
	/**
	 * @param admissionType the admissionType to set
	 */
	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}
	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the feesStatus
	 */
	public String getFeesStatus() {
		return feesStatus;
	}
	/**
	 * @param feesStatus the feesStatus to set
	 */
	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/**
	 * @return the fees
	 */
	public List<FeesHistory> getFees() {
		return fees;
	}
	/**
	 * @param fees the fees to set
	 */
	public void setFees(List<FeesHistory> fees) {
		this.fees = fees;
	}
	
	@Override
	public String toString() {
		return id + "|" + name + "|" + admissionType + "|" + batch + "|" + year + "|" + department + "|" + feesStatus
				+ "|" + courses + "|" + fees;
	}
	
	
}
