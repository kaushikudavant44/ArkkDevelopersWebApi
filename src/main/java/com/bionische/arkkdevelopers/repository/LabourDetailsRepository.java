package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.arkkdevelopers.model.LabourDetails;

public interface LabourDetailsRepository extends JpaRepository<LabourDetails, Integer>{

	
	
	LabourDetails save(LabourDetails labourDetails);
	
	LabourDetails findByLabourIdAndInt1(int labourId, int int1);

	List<LabourDetails> findBySiteContainingAndInt1(int site, int int1);
	
	@Transactional
	@Modifying
	@Query("UPDATE LabourDetails  SET int1 =1 WHERE labourId=:labourId")
	int deleteLabour(@Param("labourId")int labourId);
	
	
}
