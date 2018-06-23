package com.bionische.arkkdevelopers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.EmployeeDetails;
import com.bionische.arkkdevelopers.repository.EmployeeDetailsRepository;

@RestController
public class EmpDetailsApiController {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	
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
			employeeDetailsRes= employeeDetailsRepository.findByEmpId(empId);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return employeeDetailsRes;
	}
	
	
}
