package com.college.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.course.model.Course;
import com.college.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	public static final Logger logger =  LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/courses")
	public List<Course> getCourses(){
		
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			courseList = courseService.getCourses(); 
		}catch (Exception e) {
			logger.info("Exception occured while getting courses :"+e);
		}
		return courseList;
	}
	
	@PostMapping("/coursedata")
	public ResponseEntity<List<Course>> getStudentCourse(@RequestParam String department,@RequestParam String year){
		List<Course> courses = new ArrayList<Course>();
		
		try {
			courses =courseService.getStudentCourse(department,year);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<>(courses,HttpStatus.OK);
		
	}
}
