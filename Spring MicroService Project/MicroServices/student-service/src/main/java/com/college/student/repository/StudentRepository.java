package com.college.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.college.student.model.Student;

import jakarta.transaction.Transactional;

@Repository
@EnableTransactionManagement
@Transactional
public interface StudentRepository extends JpaRepository<Student,Number>{

	void deleteByStudentCode(int id);

	Student getByStudentCode(int id);

	Optional<Student> findByStudentCode(int id);

	@Query("SELECT s from Student s  WHERE feesStatus IS NULL")
	List<Student> getStudentsForFeesUpdate();

	
	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.feesStatus = :feesStatus WHERE s.studentCode = :studentCode")
	void updateFeesStatus(@Param("studentCode") int studentCode, @Param("feesStatus") String feesStatus);

	
	

}
