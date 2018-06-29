package com.bionische.arkkdevelopers.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.GetBranchEmployeeReportDetails;
import com.bionische.arkkdevelopers.model.GetEmployeeReportDetails;
import com.bionische.arkkdevelopers.model.GetEmployeeSalaryDetails;
import com.bionische.arkkdevelopers.model.GetLabourSalaryDetails;
import com.bionische.arkkdevelopers.model.LabourSalaryDetailsList;
import com.bionische.arkkdevelopers.repository.AttendanceDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetBranchEmployeeReportDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetEmployeeReportDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetEmployeeSalaryDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetLabourSalaryDetailsRepository;
   

@RestController
public class SalaryCalculateApiController {

	@Autowired
	AttendanceDetailsRepository attendanceDetailsRepository;
	
	@Autowired
	GetEmployeeSalaryDetailsRepository getEmployeeSalaryDetailsRepository;
	
	@Autowired
	GetLabourSalaryDetailsRepository getLabourSalaryDetailsRepository;
	
	@Autowired
	GetEmployeeReportDetailsRepository getEmployeeReportDetailsRepository;
	
	@Autowired
	GetBranchEmployeeReportDetailsRepository getBranchEmployeeReportDetailsRepository;
	
	
	@RequestMapping(value = { "/getEmpSalaryDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeSalaryDetails> getEmpSalaryDetails(@RequestParam("empId") String empId, @RequestParam("month") int month,@RequestParam("year") int year)
	
	{ 
		 
	 
		  
		    Calendar calendar = Calendar.getInstance();
		    // Note that month is 0-based in calendar, bizarrely.
		    calendar.set(year, month - 1, 1);
		    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
 
		    int count = 0;
		    for (int day = 1; day <= daysInMonth; day++) {
		        calendar.set(year, month - 1, day);
		        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		        if (dayOfWeek == Calendar.SUNDAY ) {
		            count++;
		            // Or do whatever you need to with the result.
		        }
		    } 
		    GetEmployeeSalaryDetails getEmployeeSalaryDetails=new GetEmployeeSalaryDetails();
		    
		    List<GetEmployeeSalaryDetails> getEmployeeSalaryDetailsList=new ArrayList<GetEmployeeSalaryDetails>();
		    int attendDayCount=attendanceDetailsRepository.getEmpDayCount(empId, year+"-"+month+"-01", year+"-"+month+"-"+daysInMonth);
		    getEmployeeSalaryDetails= getEmployeeSalaryDetailsRepository.getEmpDetails(Integer.parseInt(empId));
		    
		    float basicSalary=(getEmployeeSalaryDetails.getSalary()/daysInMonth);
		    
		    getEmployeeSalaryDetails.setNoOfDays(attendDayCount);
		    getEmployeeSalaryDetails.setSalary((Math.round(basicSalary*attendDayCount)));
		    
		    getEmployeeSalaryDetailsList.add(getEmployeeSalaryDetails);
		    System.out.println("getEmployeeSalaryDetails  "+getEmployeeSalaryDetails.toString());
		return getEmployeeSalaryDetailsList;
	}
	
	
	@RequestMapping(value = { "/getLabourSalaryDetails" }, method = RequestMethod.POST)
	public @ResponseBody GetLabourSalaryDetails getLabourSalaryDetails(@RequestParam("labourId") String labourId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	
	{
		 
	 
		   
		    
		    GetLabourSalaryDetails getLabourSalaryDetails=new GetLabourSalaryDetails();
		  
		    List<GetEmployeeReportDetails> getEmployeeReportDetailsList=new ArrayList<GetEmployeeReportDetails>();
		    try {
		    	
		   
		    	getEmployeeReportDetailsList= getEmployeeReportDetailsRepository.getAttendenceByUserIdAndBetweenDate(labourId, fromDate, toDate);
		    	  System.out.println("getEmployeeReportDetailsList   "+getEmployeeReportDetailsList.toString());
		    }
		    catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		    try {
		    getLabourSalaryDetails= getLabourSalaryDetailsRepository.getEmpDetails(Integer.parseInt(labourId));
		    System.out.println("getLabourSalaryDetails   "+getLabourSalaryDetails.toString());
		    }
		    catch (Exception e) {
				System.out.println(e.getMessage());// TODO: handle exception
			}
		    LabourSalaryDetailsList labourSalaryDetails;
		    List<LabourSalaryDetailsList> labourSalaryDetailsList=new ArrayList<LabourSalaryDetailsList>();
		    float workingHour;
		    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		    Date d2 = null;
		    Date d1 =null;
		    int workingDays=0;
		    float salary=0;
		    for(int i=0;i<getEmployeeReportDetailsList.size();i++)
		    {
		    	labourSalaryDetails=new LabourSalaryDetailsList();
		    	 // workingHour=
		    	    try {
						d1 = format.parse(getEmployeeReportDetailsList.get(i).getInTime());
						d2=format.parse(getEmployeeReportDetailsList.get(i).getOutTime());
						    workingHour = d2.getTime() - d1.getTime();
						   
						    float diffHours = workingHour / (60 * 60 * 1000) % 24;
						    System.out.println("diffHours  "+diffHours);
						    labourSalaryDetails.setWorkingHour(diffHours);
						    salary=salary+((getLabourSalaryDetails.getSalary()/8)*diffHours);
						    labourSalaryDetails.setAmount(((getLabourSalaryDetails.getSalary()/8)*diffHours));
						    labourSalaryDetails.setDate(getEmployeeReportDetailsList.get(i).getDate());
						    labourSalaryDetails.setInTime(getEmployeeReportDetailsList.get(i).getInTime());
						    labourSalaryDetails.setOutTime(getEmployeeReportDetailsList.get(i).getOutTime());
						    labourSalaryDetailsList.add(labourSalaryDetails);
						    ++workingDays;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	    getLabourSalaryDetails.setLabourSalaryDetailsList(labourSalaryDetailsList);
		    	    getLabourSalaryDetails.setNoOfDays(workingDays);
		    	    getLabourSalaryDetails.setSalary(Math.round(salary));
		    	//labourSalaryDetailsList.setAmount(amount);
		    	
		    }
		    
		    
		    System.out.println("getLabourSalaryDetails   "+getLabourSalaryDetails.toString());
		return getLabourSalaryDetails;
	}
	
	
	@RequestMapping(value = { "/getLabourSalaryDetailsBySite" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBranchEmployeeReportDetails> getLabourSalaryDetailsBySite(@RequestParam("siteId") String siteId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
	 List<GetBranchEmployeeReportDetails> getBranchEmployeeReportDetails=new ArrayList<GetBranchEmployeeReportDetails>();
	
	
		try {
			getBranchEmployeeReportDetails=getBranchEmployeeReportDetailsRepository.getAttendenceBySiteAndBetweenDate(siteId, fromDate, toDate);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		    Date d2 = null;
		    Date d1 =null;
		     
		    float workingHour;
		  for(int i=0;i<getBranchEmployeeReportDetails.size();i++)
		    {
		 try {
				d1 = format.parse(getBranchEmployeeReportDetails.get(i).getInTime());
				d2=format.parse(getBranchEmployeeReportDetails.get(i).getOutTime());
				    workingHour = d2.getTime() - d1.getTime();
				    float diffHours = workingHour / (60 * 60 * 1000) % 24;
				    getBranchEmployeeReportDetails.get(i).setSalary(Math.round((getBranchEmployeeReportDetails.get(i).getSalary()/8)+diffHours));
				    
		 }catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		    }
		  System.out.println(getBranchEmployeeReportDetails.toString());
		return getBranchEmployeeReportDetails;
		
	}

	
	
	
	
	@RequestMapping(value = { "/getEmployeeSalaryDetailsBySite" }, method = RequestMethod.POST)
	public @ResponseBody List<GetBranchEmployeeReportDetails> getEmployeeSalaryDetailsBySite(@RequestParam("branchId") String branchId, @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
	 List<GetBranchEmployeeReportDetails> getBranchEmployeeReportDetails=new ArrayList<GetBranchEmployeeReportDetails>();
	
	
		try {
			getBranchEmployeeReportDetails=getBranchEmployeeReportDetailsRepository.getAttendenceByBranchAndBetweenDate(branchId, fromDate, toDate);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		    Date d2 = null;
		    Date d1 =null;
		     
		    float workingHour;
		  for(int i=0;i<getBranchEmployeeReportDetails.size();i++)
		    {
		 try {
				d1 = format.parse(getBranchEmployeeReportDetails.get(i).getInTime());
				d2=format.parse(getBranchEmployeeReportDetails.get(i).getOutTime());
				    workingHour = d2.getTime() - d1.getTime();
				    float diffHours = workingHour / (60 * 60 * 1000) % 24;
				    getBranchEmployeeReportDetails.get(i).setSalary(Math.round((getBranchEmployeeReportDetails.get(i).getSalary()/8)+diffHours));
				    
		 }catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		    }
		  System.out.println(getBranchEmployeeReportDetails.toString());
		return getBranchEmployeeReportDetails;
		
	}
	
}
