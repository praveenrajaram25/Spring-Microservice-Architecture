package com.college.fees.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college.fees.dao.FeesDao;
import com.college.fees.model.Fees;
import com.college.fees.repository.FeesRepository;


import jakarta.transaction.Transactional;


@Repository
@Transactional
public class FeesDaoImpl implements FeesDao {
	
	private static final Logger logger =  LoggerFactory.getLogger(FeesDaoImpl.class);
	
	@Autowired
	FeesRepository feesRepo;

	@Override
	public List<Fees> getAllFees() {
		
		return feesRepo.findAll();
	}

	@Override
	public Fees getFeesForStudnet(String department, String year,String type) {

		Fees fee = null;
		try {
			fee = feesRepo.getStudentFeesStructure(department, year,type);
			if(fee!=null) {
				logger.info("Getting Fee Structure....");
				logger.info("DEPARTMENT :"+department +"   YEAR :"+year);
				logger.info(fee.toString());
			}
			
		} catch (Exception e) {
			logger.info("Exception occured while getting fees Structure :"+e);
		}
		return fee;
	}

}
