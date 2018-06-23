package com.bionische.arkkdevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.arkkdevelopers.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer>{

	
	EmployeeDetails save(EmployeeDetails employeeDetails);
	EmployeeDetails findByEmpId(int empId);
	
}
