package com.college.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college.fees.model.FeesHistory;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface FeesHistoryRepository extends JpaRepository<FeesHistory, Number>{

	
	@Query("SELECT fs FROM FeesHistory fs WHERE fs.studentCode= :studentCode AND fs.department= :department AND fs.year= :year")
	FeesHistory checkFeesData(String studentCode, String department, String year);

	@Query("SELECT fs FROM FeesHistory fs WHERE fs.studentCode= :studentCode AND fs.department= :department")
	List<FeesHistory> getStudentFeesData(String studentCode, String department);
	
	

}
