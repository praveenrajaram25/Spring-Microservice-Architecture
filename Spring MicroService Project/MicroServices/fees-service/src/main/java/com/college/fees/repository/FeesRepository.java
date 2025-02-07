package com.college.fees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.fees.model.Fees;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface FeesRepository extends JpaRepository<Fees, Number>{

	
	@Query("SELECT f FROM Fees f WHERE f.department = :department AND f.year = :year AND type = :type" )
	Fees getStudentFeesStructure(@Param(value = "department") String department,@Param(value = "year")  String year, @Param(value = "type") String type);

}
