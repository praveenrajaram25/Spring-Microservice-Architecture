package com.college.course.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.course.controller.CourseController;
import com.college.course.dao.CourseDao;
import com.college.course.model.Course;
import com.college.course.repository.CourseRepository;
import com.college.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	public static final Logger logger =  LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	CourseDao courseDao;

	@Override
	public List<Course> getCourses() {
		try {
			return courseDao.getAllCourses();
		}catch(Exception e) {
			
		}
		return null;
	}


	@Override
	public List<Course> getStudentCourse(String department, String year) {
		List<Course> coursesForStudent = new ArrayList<Course>();
		try {
			
			coursesForStudent=  courseDao.getCourseforStudents(department,year);
			
		}catch (Exception e) {
			logger.info("Exception occured while getting student course :"+e);
		}
		return coursesForStudent;
		
	}

}
