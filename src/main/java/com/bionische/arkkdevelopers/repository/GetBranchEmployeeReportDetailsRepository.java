package com.bionische.arkkdevelopers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.arkkdevelopers.model.GetBranchEmployeeReportDetails;
 
public interface GetBranchEmployeeReportDetailsRepository extends JpaRepository<GetBranchEmployeeReportDetails, Integer>{

	
	@Query(value="SELECT d.DeviceLogId as device_log_id,d.DeviceId, d.UserId as user_id, e.name,e.salary, b.name as branch, DATE(d.LogDate)as date, COALESCE((SELECT TIME(dd.LogDate) FROM DeviceLogs dd WHERE"
			+ " d.DeviceId=dd.DeviceId AND dd.UserId=d.UserId AND DATE(dd.LogDate)=DATE(d.LogDate) AND dd.Direction='in'), 0)AS in_time, COALESCE((SELECT TIME(da.LogDate) FROM DeviceLogs da WHERE d.DeviceId=da.DeviceId AND da.UserId=d.UserId"
			+ " AND DATE(da.LogDate)=DATE(d.LogDate) AND da.Direction='out'), 0)AS out_time FROM DeviceLogs d, labour_details e, branch_site_details b WHERE d.UserId=e.labour_id AND"
			+ " d.DeviceId=:deviceId AND d.Direction='out' AND d.LogDate BETWEEN :fromDate AND :toDate AND d.DeviceId=b.device_id GROUP by d.LogDate order by e.name,d.UserId"  ,nativeQuery=true)

	List<GetBranchEmployeeReportDetails> getAttendenceBySiteAndBetweenDate(@Param("deviceId")String deviceId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);

	
	@Query(value="SELECT d.DeviceLogId as device_log_id,d.DeviceId, d.UserId as user_id, e.name,e.salary, b.name as branch, DATE(d.LogDate)as date, COALESCE((SELECT TIME(dd.LogDate) FROM DeviceLogs dd WHERE"
			+ " d.DeviceId=dd.DeviceId AND dd.UserId=d.UserId AND DATE(dd.LogDate)=DATE(d.LogDate) AND dd.Direction='in'), 0)AS in_time, COALESCE((SELECT TIME(da.LogDate) FROM DeviceLogs da WHERE d.DeviceId=da.DeviceId AND da.UserId=d.UserId"
			+ " AND DATE(da.LogDate)=DATE(d.LogDate) AND da.Direction='out'), 0)AS out_time FROM DeviceLogs d, emp_details e, branch_site_details b WHERE d.UserId=e.emp_id AND"
			+ " d.DeviceId=:deviceId AND d.Direction='out' AND d.LogDate BETWEEN :fromDate AND :toDate AND d.DeviceId=b.device_id GROUP by d.LogDate"  ,nativeQuery=true)

	List<GetBranchEmployeeReportDetails> getAttendenceByBranchAndBetweenDate(@Param("deviceId")String deviceId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);

}
