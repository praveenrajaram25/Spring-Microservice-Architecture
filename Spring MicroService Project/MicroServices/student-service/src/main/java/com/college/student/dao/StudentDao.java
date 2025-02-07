package com.college.student.dao;

import java.util.List;

import com.college.student.model.Student;

public interface StudentDao {

	void addStudent(Student student);

	void terminateStudent(int id);

	Student getStudentData(int id);

	List<Student> getAllStudents();

	List<Student> getStudentsListForFeesUpdate();

	String updateStudentFeesStaus(int studentCode, String status);

}
