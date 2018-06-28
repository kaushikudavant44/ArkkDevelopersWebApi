package com.bionische.arkkdevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.GetLabourSalaryDetails;

public interface GetLabourSalaryDetailsRepository extends JpaRepository<GetLabourSalaryDetails, Integer>
{
	@Query(value="Select labour_id, salary, name from labour_details where labour_id=:labourId" ,nativeQuery=true)
	GetLabourSalaryDetails getEmpDetails(@Param("labourId") int labourId);
}
   