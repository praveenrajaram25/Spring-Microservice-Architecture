package com.college.course.service;

import java.util.List;

import com.college.course.model.Course;

public interface CourseService {

	List<Course> getCourses();

	List<Course> getStudentCourse(String department, String year);

}
