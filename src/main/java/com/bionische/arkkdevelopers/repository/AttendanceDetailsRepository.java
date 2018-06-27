package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.arkkdevelopers.model.AttendanceDetails;

public interface AttendanceDetailsRepository extends JpaRepository<AttendanceDetails, Integer>
{

	AttendanceDetails save(AttendanceDetails attendanceDetails);
	
	List<AttendanceDetails> findByUserId(String userId);
	
	List<AttendanceDetails> findByUserIdAndLogDate(String userId, String logDate);
}
