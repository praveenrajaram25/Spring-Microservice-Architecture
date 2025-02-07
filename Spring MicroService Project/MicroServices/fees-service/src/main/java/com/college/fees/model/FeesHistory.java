package com.college.fees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FEES_HISTORY")
public class FeesHistory {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="STUDENT_CODE")
	private String studentCode;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DEPARTMANT")
	private String department;
	
	@Column(name="YEAR")
	private String year;
	
	@Column(name="FEES_AMT")
	private int feesAmount;
	
	@Column(name="PAID_AMT")
	private int paidAmount;
	
	@Column(name="PENDING_AMT")
	private int pendingAmount;
	
	@Column(name="FEES_PAID")
	private String feesPaid;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the studentCode
	 */
	public String getStudentCode() {
		return studentCode;
	}

	/**
	 * @param studentCode the studentCode to set
	 */
	public void setStudentCode(String studentCode) {
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
	 * @return the departemnt
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param departemnt the departemnt to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	 * @return the feesAmount
	 */
	public int getFeesAmount() {
		return feesAmount;
	}

	/**
	 * @param feesAmount the feesAmount to set
	 */
	public void setFeesAmount(int feesAmount) {
		this.feesAmount = feesAmount;
	}

	/**
	 * @return the paidAmount
	 */
	public int getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount the paidAmount to set
	 */
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the pendingAmount
	 */
	public int getPendingAmount() {
		return pendingAmount;
	}

	/**
	 * @param pendingAmount the pendingAmount to set
	 */
	public void setPendingAmount(int pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	/**
	 * @return the feesPaid
	 */
	public String getFeesPaid() {
		return feesPaid;
	}

	/**
	 * @param feesPaid the feesPaid to set
	 */
	public void setFeesPaid(String feesPaid) {
		this.feesPaid = feesPaid;
	}

	@Override
	public String toString() {
		return id + "|" + studentCode + "|" + name + "|" + department + "|" + year + "|" + feesAmount + "|" + paidAmount
				+ "|" + pendingAmount + "|" + feesPaid;
	}
	
	
	
	


}
