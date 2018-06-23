package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.BranchSiteDetails;

public interface BranchSiteDetailsRepository extends JpaRepository<BranchSiteDetails, Integer>
{

	
	
	BranchSiteDetails save(BranchSiteDetails branchSiteDetails);
	
	List<BranchSiteDetails> findAll();

	
	@Query(value=" SELECT * from branch_site_details where branch_site_id IN(select branch from emp_details where emp_id=:empId) ",nativeQuery=true)

	List<BranchSiteDetails> getBranchDetailsByEmpId(@Param("empId")int empId);
	
	
}
