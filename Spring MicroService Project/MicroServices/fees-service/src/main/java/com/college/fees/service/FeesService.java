package com.college.fees.service;

import java.util.List;

import com.college.fees.model.Fees;
import com.college.fees.model.FeesHistory;


public interface FeesService {

	List<Fees> getFees();

	FeesHistory saveStudentFees(String studentCode, String name, String department, String year,String type);

	String checkFeesExists(String studentCode, String department, String year);

	List<FeesHistory> getStudentFees(String studentCode, String department);

	String payStudentFee(String studentCode, String department, String year, int amount);

}
