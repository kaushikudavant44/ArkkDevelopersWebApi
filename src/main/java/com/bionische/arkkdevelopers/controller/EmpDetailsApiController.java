package com.bionische.arkkdevelopers.controller;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.BranchSiteDetails;
import com.bionische.arkkdevelopers.model.EmployeeDetails;
import com.bionische.arkkdevelopers.repository.BranchSiteDetailsRepository;
import com.bionische.arkkdevelopers.repository.EmployeeDetailsRepository;

@RestController
public class EmpDetailsApiController {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired 
	BranchSiteDetailsRepository branchSiteDetailsRepository;
	
	
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
	
	
	@RequestMapping(value = { "/getEmployeeDetailsByBranch" }, method = RequestMethod.POST)
	public @ResponseBody List<EmployeeDetails> getEmployeeDetailsByBranch(@RequestParam("branchId") String branchId)
	{
		List<EmployeeDetails> employeeDetailsList=new ArrayList<EmployeeDetails>();
		try
		{
			employeeDetailsList= employeeDetailsRepository.findByBranchContaining(branchId);
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
			employeeDetailsRes= employeeDetailsRepository.findByEmpId(empId);
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
			
			branchSiteDetailsList= branchSiteDetailsRepository.findByType(type);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return branchSiteDetailsList;
	}
	
	
}
