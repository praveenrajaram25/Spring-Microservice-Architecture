package com.college.fees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FEES_STRUCTURE")
public class Fees {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="YEAR")
	private String year;
	
	@Column(name="COLLEGE_FEES")
	private int collegeFees;
	
	@Column(name="HOSTEL_FEES")
	private int hostelFees;
	
	@Column(name="BUS_FEES")
	private int busFees;
	
	@Column(name="MISCELLANEOUS_FEES")
	private int miscellaneousFees;
	
	@Column(name="TOTAL_FEES")
	private int totalFees;

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
	 * @return the collegeFees
	 */
	public int getCollegeFees() {
		return collegeFees;
	}

	/**
	 * @param collegeFees the collegeFees to set
	 */
	public void setCollegeFees(int collegeFees) {
		this.collegeFees = collegeFees;
	}

	/**
	 * @return the hostelFees
	 */
	public int getHostelFees() {
		return hostelFees;
	}

	/**
	 * @param hostelFees the hostelFees to set
	 */
	public void setHostelFees(int hostelFees) {
		this.hostelFees = hostelFees;
	}

	/**
	 * @return the busFees
	 */
	public int getBusFees() {
		return busFees;
	}

	/**
	 * @param busFees the busFees to set
	 */
	public void setBusFees(int busFees) {
		this.busFees = busFees;
	}

	/**
	 * @return the miscellaneousFees
	 */
	public int getMiscellaneousFees() {
		return miscellaneousFees;
	}

	/**
	 * @param miscellaneousFees the miscellaneousFees to set
	 */
	public void setMiscellaneousFees(int miscellaneousFees) {
		this.miscellaneousFees = miscellaneousFees;
	}

	/**
	 * @return the totalFees
	 */
	public int getTotalFees() {
		return totalFees;
	}

	/**
	 * @param totalFees the totalFees to set
	 */
	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}

	@Override
	public String toString() {
		return id + "|" + department + "|" + type + "|" + year + "|" + collegeFees + "|" + hostelFees + "|" + busFees
				+ "|" + miscellaneousFees + "|" + totalFees;
	}

}
