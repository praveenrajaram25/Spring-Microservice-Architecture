package com.college.course.dao;

import java.util.List;

import com.college.course.model.Course;

public interface CourseDao {

	List<Course> getAllCourses();

	List<Course> getCourseforStudents(String department, String year);

}
