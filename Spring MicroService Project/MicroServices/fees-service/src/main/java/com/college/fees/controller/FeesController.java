package com.college.fees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.fees.model.Fees;
import com.college.fees.model.FeesHistory;
import com.college.fees.service.FeesService;


import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/fees")
public class FeesController {
	
	private static final Logger logger =  LoggerFactory.getLogger(FeesController.class);
	
	@Autowired
	private FeesService feesService;

	@PostMapping("/feestructure")
	public ResponseEntity<List<Fees>> getFees() {
		List<Fees> feesStructure = new ArrayList<>();
		try {
			feesStructure = feesService.getFees();
		} catch (Exception e) {
			logger.info("Exception occured while getting all fees : " + e);
		}
		return new ResponseEntity<>(feesStructure, HttpStatus.OK);
	}
	
	@PostMapping("/savefees")
	public ResponseEntity<String> saveFees(@RequestParam String studentCode, @RequestParam String name,
			@RequestParam String department, @RequestParam String year,@RequestParam String type) {
		String saveFees = "";
		try {	
			String feesDetailsCheck = feesService.checkFeesExists(studentCode,department,year);
			
			if(StringUtils.equalsIgnoreCase(feesDetailsCheck,"Exists")) {
				saveFees="Student Fees Details Already exists  : "+studentCode;
			}else {
				FeesHistory fees = feesService.saveStudentFees(studentCode,name,department,year,type);
				if(fees!=null) {
					saveFees="Student Fees Details Created : "+fees.getStudentCode();
				}
			}	
		} catch (Exception e) {
			logger.info("Exception occured while saving fees for  : " + e);
			saveFees="Student Fees Details Creation Failed : "+studentCode;
			return new ResponseEntity<>(saveFees, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(saveFees, HttpStatus.OK);
	}
	
	@PostMapping("/getStudentFees")
	public ResponseEntity<List<FeesHistory>> getStudentFeesDetails(@RequestParam String studentCode,
			@RequestParam String department) {
		List<FeesHistory> fees = new ArrayList<FeesHistory>();
		
		try {
			fees = feesService.getStudentFees(studentCode,department);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<>(fees, HttpStatus.OK);
	}
	
	@PostMapping("/payfees")
	public String payStudentFees(@RequestParam String studentCode,
			@RequestParam String department,@RequestParam String year,@RequestParam int amount) {
		String res="";
		try {
			res=feesService.payStudentFee(studentCode,department,year,amount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}
	

}
