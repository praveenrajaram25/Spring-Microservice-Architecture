package com.college.student.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.student.model.FeesHistory;

@FeignClient("FEES-SERVICE")
public interface FeesInterface {
	
	@PostMapping("/fees/savefees")
	public ResponseEntity<String> saveFees(@RequestParam String studentCode, @RequestParam String name,
			@RequestParam String department, @RequestParam String year,@RequestParam String type) ;
	
	@PostMapping("/fees/getStudentFees")
	public ResponseEntity<List<FeesHistory>> getStudentFeesDetails(@RequestParam String studentCode,
			@RequestParam String department);

}
