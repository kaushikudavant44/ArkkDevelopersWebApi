package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.arkkdevelopers.model.BranchSiteDetails;

public interface BranchSiteDetailsRepository extends JpaRepository<BranchSiteDetails, Integer>
{

	
	
	BranchSiteDetails save(BranchSiteDetails branchSiteDetails);
	
	List<BranchSiteDetails> findAll();
	
	
}
