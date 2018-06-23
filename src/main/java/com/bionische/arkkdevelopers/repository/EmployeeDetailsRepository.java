package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.arkkdevelopers.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer>{

	
	EmployeeDetails save(EmployeeDetails employeeDetails);
	EmployeeDetails findByEmpId(int empId);
	
	List<EmployeeDetails> findByBranchContaining(String branch);
	
	
}
