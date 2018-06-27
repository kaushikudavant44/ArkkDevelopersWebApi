package com.bionische.arkkdevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.GetEmployeeSalaryDetails;

public interface GetEmployeeSalaryDetailsRepository extends JpaRepository<GetEmployeeSalaryDetails, Integer>
{

	@Query(value="Select emp_id, salary, name from emp_details where emp_id=:empId" ,nativeQuery=true)
	GetEmployeeSalaryDetails getEmpDetails(@Param("empId") int empId);
}
