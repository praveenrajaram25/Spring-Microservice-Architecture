package com.college.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.college.student.feign.CourseInterface;
import com.college.student.feign.FeesInterface;
import com.college.student.model.Student;
import com.college.student.model.StudentProfile;
import com.college.student.repository.StudentRepository;
import com.college.student.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	
	
	
	@PostMapping("/admit")
	public String admitStudent(@RequestBody Student student) {
		String res = "";
		logger.info("Student Admission Started...");
		try {	
			res = studentService.admitStudent(student);
		} catch (Exception e) {
			logger.info("Exception occured while admitting Student in College "+e);
		}
		logger.info("Student Admission Completed...");
		return res;
	}
	
	@PostMapping("/terminate")
	public String terminateStudent(@RequestParam int id) {
		String res = "";
		logger.info("Student Termination Started...");
		try {
			Student student = studentService.getStudentDataById(id);
			if(student!=null) {
				res = studentService.terminateStudent(id,student);
			}else {
				res="No Student registered in this Id :"+id;
				logger.info(res);
			}	
		} catch (Exception e) {
			logger.info("Exception occured while admitting Student in College "+e);
		}
		logger.info("Student Termination Completed...");
		return res;
	}
	
	
	@GetMapping("/studentdata")
	public List<Student> getStudents() {
		List<Student> student = new ArrayList<Student>();
		logger.info("Students Data Fetch Started...");
		try {
			student = studentService.getStudentData();
				
		} catch (Exception e) {
			logger.info("Exception occured while getting Students in College "+e);
		}
		logger.info("Student Data Fetch Completed...");
		return student;
	}
	
	@PostMapping("/studentDetails")
	public ResponseEntity<Student> getStudentDeatils(@RequestParam int id) {
		
		Student student = null;
		
		try {
			student = studentService.getStudentDataById(id);
 		}catch (Exception e) {
			logger.info("Exception occured while getting Student Details "+e);
		}
		
		if(student!=null) {
			return new ResponseEntity<>(student,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(student,HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/profile")
	public ResponseEntity<StudentProfile> getStudentProfile(@RequestParam int id) {

		StudentProfile profile = new StudentProfile();
		try {
			profile = studentService.getStudentProfile(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}
	
	@PostMapping("/updateFeesStatus")
	public String updateStudentFeeStatus(@RequestParam int id,@RequestParam String status) {

		String res ="";
		try {
			res = studentService.getUpdateFeesStatus(id,status);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
}
