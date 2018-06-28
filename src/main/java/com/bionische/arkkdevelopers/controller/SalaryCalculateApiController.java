package com.bionische.arkkdevelopers.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.GetEmployeeSalaryDetails;
import com.bionische.arkkdevelopers.repository.AttendanceDetailsRepository;
import com.bionische.arkkdevelopers.repository.GetEmployeeSalaryDetailsRepository;

@RestController
public class SalaryCalculateApiController {

	@Autowired
	AttendanceDetailsRepository attendanceDetailsRepository;
	
	@Autowired
	GetEmployeeSalaryDetailsRepository getEmployeeSalaryDetailsRepository;
	
	
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
	
	
	
}
