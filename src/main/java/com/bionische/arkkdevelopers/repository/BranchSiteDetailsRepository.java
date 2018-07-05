package com.bionische.arkkdevelopers.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.BranchSiteDetails;

public interface BranchSiteDetailsRepository extends JpaRepository<BranchSiteDetails, Integer>
{

	
	
	BranchSiteDetails save(BranchSiteDetails branchSiteDetails);
	
	List<BranchSiteDetails> findByInt1(int int1);

	
	@Query(value=" SELECT * from branch_site_details where branch_site_id IN(:branchList) and int_1=0",nativeQuery=true)

	List<BranchSiteDetails> getBranchDetailsBranchId(@Param("branchList")List<String> branchList);

	List<BranchSiteDetails> findByTypeAndInt1(int type,int int1);
	
	@Transactional
	@Modifying
	@Query("UPDATE BranchSiteDetails  SET int_1=1 WHERE branchSiteId=:branchSiteId")
	int updateBranchDeleteStatus(@Param("branchSiteId")int branchSiteId);
	
}
