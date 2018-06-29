package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.AttendanceDetails;

public interface AttendanceDetailsRepository extends JpaRepository<AttendanceDetails, Integer>
{

	AttendanceDetails save(AttendanceDetails attendanceDetails);
	
	List<AttendanceDetails> findByUserId(String userId);
	
	List<AttendanceDetails> findByUserIdAndLogDate(String userId, String logDate);
	
	@Query(value="Select count(DeviceLogId) from DeviceLogs where UserId=:empId AND LogDate BETWEEN :fromDate AND :toDate AND Direction='out'" ,nativeQuery=true)

	int getEmpDayCount(@Param("empId")String empId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
 
 	
}
