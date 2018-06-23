package com.bionische.arkkdevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.arkkdevelopers.model.LabourDetails;

public interface LabourDetailsRepository extends JpaRepository<LabourDetails, Integer>{

	
	
	LabourDetails save(LabourDetails labourDetails);
	
	LabourDetails findByLabourId(int labourId);
	
}
