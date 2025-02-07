package com.college.student.service;

import java.util.List;

import com.college.student.model.Student;
import com.college.student.model.StudentProfile;

public interface StudentService {

	String admitStudent(Student student);

	String terminateStudent(int id, Student student);

	Student getStudentDataById(int id);

	List<Student> getStudentData();

	StudentProfile getStudentProfile(int id);

	String getUpdateFeesStatus(int id, String status);

}
