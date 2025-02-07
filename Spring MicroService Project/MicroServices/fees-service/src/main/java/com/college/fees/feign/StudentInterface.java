package com.college.fees.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("STUDENT-SERVICE")
public interface StudentInterface {

	@PostMapping("student/updateFeesStatus")
	public String updateStudentFeeStatus(@RequestParam int id, @RequestParam String status);
}
