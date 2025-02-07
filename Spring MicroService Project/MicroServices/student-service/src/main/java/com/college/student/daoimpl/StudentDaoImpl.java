package com.college.student.daoimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college.student.dao.StudentDao;
import com.college.student.model.Student;
import com.college.student.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void addStudent(Student student) {
		try {
			studentRepo.save(student);
		}catch (Exception e) {
			logger.info("Exception occured while saving students : "+e);
		}	
	}

	@Override
	public void terminateStudent(int id) {
		try {
			studentRepo.deleteByStudentCode(id);
		}catch (Exception e) {
			logger.info("Exception occured while deleting student : "+e);
		}	
		
	}

	@Override
	public Student getStudentData(int id) {
		Optional<Student> std = null;
		try {
			std= studentRepo.findByStudentCode(id);
		}catch (Exception e) {
			logger.info("Exception occured while getting student data : "+e);
		}
		
		if(std.isPresent()) {
			return std.get();
		}else {
			return null;
		}
		
	}

	@Override
	public List<Student> getAllStudents() {
		try {
			return studentRepo.findAll();
		}catch (Exception e) {
			logger.info("Exception occured while getting all student : "+e);
		}
		return null;
	}

	@Override
	public List<Student> getStudentsListForFeesUpdate() {
		try {
			
			return studentRepo.getStudentsForFeesUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public String updateStudentFeesStaus(int studentCode,String status) {
		String res="success";
		try {
			studentRepo.updateFeesStatus(studentCode,status);
		} catch (Exception e) {
			logger.info("Exception occured while updating Student Fee status in student table :"+e);
			res="Fail";
		}
		return res;
	}

}
