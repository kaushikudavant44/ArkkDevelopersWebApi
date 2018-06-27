package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.GetEmployeeReportDetails;

public interface GetEmployeeReportDetailsRepository extends JpaRepository<GetEmployeeReportDetails, Integer>{

	@Query(value="SELECT d.DeviceLogId as device_log_id, d.UserId as user_id, e.name, DATE(d.LogDate)as date, COALESCE((SELECT TIME(dd.LogDate) FROM DeviceLogs dd WHERE"
			+ " dd.UserId=d.UserId AND DATE(dd.LogDate)=DATE(d.LogDate) AND dd.Direction='in'), 0)AS in_time,"
			+ " COALESCE((SELECT TIME(da.LogDate) FROM DeviceLogs da WHERE da.UserId=d.UserId AND DATE(da.LogDate)=DATE(d.LogDate)"
			+ " AND da.Direction='out'), 0)AS out_time FROM DeviceLogs d, emp_details e, branch_site_details b WHERE"
			+ " d.UserId=e.emp_id AND d.UserId=:userId AND d.Direction='out' AND d.LogDate BETWEEN :fromDate AND :toDate GROUP by d.LogDate" ,nativeQuery=true)
	List<GetEmployeeReportDetails> getAttendenceByEmpIdAndBetweenDate(@Param("userId")String userId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
}
