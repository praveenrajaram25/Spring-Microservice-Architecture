package com.college.student.model;

public class FeesHistory {

	private int id;

	private String studentCode;

	private String name;

	private String department;

	private String year;

	private int feesAmount;

	private int paidAmount;

	private int pendingAmount;

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
