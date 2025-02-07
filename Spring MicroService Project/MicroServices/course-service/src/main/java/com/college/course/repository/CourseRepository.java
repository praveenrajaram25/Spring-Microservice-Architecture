package com.college.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.course.model.Course;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository  extends JpaRepository<Course, Number>{

	@Query("SELECT c FROM Course c WHERE c.department = :department AND c.year = :year")
	List<Course> getCourseForStudent(@Param("department")  String department, @Param("year")  String year);

}
