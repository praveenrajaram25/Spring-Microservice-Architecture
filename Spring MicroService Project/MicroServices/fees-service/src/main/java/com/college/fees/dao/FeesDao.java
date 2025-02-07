package com.college.fees.dao;

import java.util.List;

import com.college.fees.model.Fees;


public interface FeesDao {

	List<Fees> getAllFees();

	Fees getFeesForStudnet(String department, String year, String type);

}
