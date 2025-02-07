package com.college.student.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.student.model.Course;


@FeignClient("COURSE-SERVICE")
public interface CourseInterface {
	
	@PostMapping("/course/coursedata")
	public ResponseEntity<List<Course>> getStudentCourse(@RequestParam String department,@RequestParam String year);

}
