package com.college.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@Column(name="STUDENT_CODE")
	private int studentCode;
	@Column(name="NAME")
	private String name;
	@Column(name="TYPE")
	private String type;
	@Column(name="BATCH")
	private String batch;
	@Column(name="YEAR")
	private String year;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="FEES_STATUS")
	private String feesStatus;
	
	/**
	 * @return the studentCode
	 */
	public int getStudentCode() {
		return studentCode;
	}
	/**
	 * @param studentCode the studentCode to set
	 */
	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return studentCode + "|" + name + "|" + type + "|" + batch + "|" + year + "|" + department + "|" + feesStatus;
	}
	
	

}
