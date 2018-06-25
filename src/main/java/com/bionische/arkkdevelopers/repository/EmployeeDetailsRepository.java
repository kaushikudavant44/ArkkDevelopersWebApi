package com.bionische.arkkdevelopers.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer>{

	
	EmployeeDetails save(EmployeeDetails employeeDetails);
	
	@Query(value=" SELECT * from emp_details where emp_id=:empId AND del_status=0",nativeQuery=true)
	EmployeeDetails findByEmpId(@Param("empId")int empId);
	
	
	List<EmployeeDetails> findByBranchContaining(String branch);
	
	@Transactional
	@Modifying
	@Query("UPDATE EmployeeDetails  SET int1 =1 WHERE empId=:empId")
	int updateEmployeeDeleteStatus(@Param("empId")int empId);
	
}
