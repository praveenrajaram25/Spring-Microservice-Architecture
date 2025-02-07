package com.college.course.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.college.course.dao.CourseDao;
import com.college.course.model.Course;
import com.college.course.repository.CourseRepository;


@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public List<Course> getCourseforStudents(String department, String year) {
		return courseRepo.getCourseForStudent(department,year);
	}

}
