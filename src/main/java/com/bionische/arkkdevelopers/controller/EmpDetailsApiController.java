package com.bionische.arkkdevelopers.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.AttendanceDetails;
import com.bionische.arkkdevelopers.model.BranchSiteDetails;
import com.bionische.arkkdevelopers.model.EmployeeDetails;
import com.bionische.arkkdevelopers.model.GetEmployeeReportDetails;
import com.bionische.arkkdevelopers.model.Info;
import com.bionische.arkkdevelopers.repository.AttendanceDetailsRepository;
import com.bionische.arkkdevelopers.repository.BranchSiteDetailsRepository;
import com.bionische.arkkdevelopers.repository.EmployeeDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetEmployeeReportDetailsRepository;

@RestController
public class EmpDetailsApiController {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired 
	BranchSiteDetailsRepository branchSiteDetailsRepository;
	
	@Autowired
	GetEmployeeReportDetailsRepository getEmployeeReportDetailsRepository;
	
	@Autowired
	AttendanceDetailsRepository attendanceDetailsRepository;
	
	
	@RequestMapping(value = { "/insertEmployeeDetails" }, method = RequestMethod.POST)
	public @ResponseBody EmployeeDetails insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails)
	{
		EmployeeDetails employeeDetailsRes=new EmployeeDetails();
		try
		{
			employeeDetailsRes= employeeDetailsRepository.save(employeeDetails);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return employeeDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getEmployeeDetailsByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody EmployeeDetails getEmployeeDetailsByEmpId(@RequestParam("empId") int empId)
	{
		EmployeeDetails employeeDetailsRes=new EmployeeDetails();
		try
		{
			employeeDetailsRes= employeeDetailsRepository.findByEmpIdAndInt1(empId,0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return employeeDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getEmployeeDetailsByBranch" }, method = RequestMethod.POST)
	public @ResponseBody List<EmployeeDetails> getEmployeeDetailsByBranch(@RequestParam("branchId") String branchId)
	{
		List<EmployeeDetails> employeeDetailsList=new ArrayList<EmployeeDetails>();
		try
		{
			employeeDetailsList= employeeDetailsRepository.findByBranchContainingAndInt1(branchId,0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return employeeDetailsList;
	}
	
	
	@RequestMapping(value = { "/getEmployeeDetailsByBranch" }, method = RequestMethod.GET)
	public @ResponseBody List<BranchSiteDetails> getEmployeeDetailsByBranch()
	{
		List<BranchSiteDetails> branchSiteDetailsList=new ArrayList<BranchSiteDetails>();
		try
		{
			branchSiteDetailsList= branchSiteDetailsRepository.findAll();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return branchSiteDetailsList;
	}
	
	
	@RequestMapping(value = { "/insertBranchSiteDetails" }, method = RequestMethod.POST)
	public @ResponseBody BranchSiteDetails insertBranchSiteDetails(@RequestBody BranchSiteDetails branchSiteDetails)
	{
		BranchSiteDetails branchSiteDetailsRes=new BranchSiteDetails();
		try
		{
			branchSiteDetailsRes= branchSiteDetailsRepository.save(branchSiteDetails);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return branchSiteDetailsRes;
	}
	

	@RequestMapping(value = { "/getBranchDetailsByEmpId" }, method = RequestMethod.POST)
	public @ResponseBody List<BranchSiteDetails> getBranchDetailsByEmpId(@RequestParam("empId") int empId)
	{
		List<BranchSiteDetails> branchSiteDetailsList=new ArrayList<BranchSiteDetails>();
		
		EmployeeDetails employeeDetailsRes=new EmployeeDetails();
		try
		{
			employeeDetailsRes= employeeDetailsRepository.findByEmpIdAndInt1(empId,0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		List<String> branchList=new ArrayList<String>();
		
		branchList= Arrays.asList(employeeDetailsRes.getBranch().split(","));
		
		try
		{
			
			branchSiteDetailsList= branchSiteDetailsRepository.getBranchDetailsBranchId(branchList);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return branchSiteDetailsList;
	}


	@RequestMapping(value = { "/getBranchSiteDetailsByType" }, method = RequestMethod.POST)
	public @ResponseBody List<BranchSiteDetails> getBranchSiteDetailsByType(@RequestParam("type") int type)
	{
		List<BranchSiteDetails> branchSiteDetailsList=new ArrayList<BranchSiteDetails>();
		
		  
		try
		{
			
			branchSiteDetailsList= branchSiteDetailsRepository.findByTypeAndInt1(type,0);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return branchSiteDetailsList;
	}
	
	@RequestMapping(value = { "/deleteEmployeeById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteEmployeeById(@RequestParam("empId") int empId)
	{
		EmployeeDetails employeeDetailsRes=new EmployeeDetails();
		Info info=new Info();
		try
		{
			int res= employeeDetailsRepository.updateEmployeeDeleteStatus(empId);
			System.out.println("res:"+res);
			if(res>0)
			{
				info.setMessage("Employee Deleted Successfully!!");
				info.setError(false);
			}
			else {
				info.setMessage(" Delete Failed!!");
				info.setError(true);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return info;
	}

	
	@RequestMapping(value = { "/getEmpAttendenceByEmpIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeReportDetails> getEmpAttendenceByEmpIdAndDate(@RequestParam("empId") String empId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate)
	{
		List<GetEmployeeReportDetails> getEmployeeReportDetailsList=new ArrayList<GetEmployeeReportDetails>();
		Info info=new Info();
		try
		{
			getEmployeeReportDetailsList= getEmployeeReportDetailsRepository.getAttendenceByEmpIdAndBetweenDate(empId, fromDate, toDate);
			System.out.println("res:"+getEmployeeReportDetailsList.toString());
			 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return getEmployeeReportDetailsList;
	}
	
	@RequestMapping(value = { "/insertEmployeeManualAttendance" }, method = RequestMethod.POST)
	public @ResponseBody AttendanceDetails insertEmployeeManualAttendance(@RequestBody AttendanceDetails attendanceDetails)
	{
		
		System.out.println("sscdcscs");
		AttendanceDetails attendanceDetailsRes=new AttendanceDetails();
		try
		{
			//attendanceDetailsRes= attendanceDetailsRepository.saveData(attendanceDetails.getDirection(), attendanceDetails.getLogDate(), attendanceDetails.getUserId(), attendanceDetails.getDeviceId(), attendanceDetails.getDeviceLogId());
			attendanceDetailsRes= attendanceDetailsRepository.save(attendanceDetails);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
			
		return attendanceDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getAttendenceByBranchAndBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeReportDetails> getAttendenceByBranchAndBetweenDate(@RequestParam("branch") String branch, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate)
	{
		List<GetEmployeeReportDetails> getEmployeeReportDetailsList=new ArrayList<GetEmployeeReportDetails>();
		Info info=new Info();
		try
		{
			getEmployeeReportDetailsList= getEmployeeReportDetailsRepository.getAttendenceByBranchAndBetweenDate(branch, fromDate, toDate);
			System.out.println("res:"+getEmployeeReportDetailsList.toString());
			 
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return getEmployeeReportDetailsList;
	}
	
}
