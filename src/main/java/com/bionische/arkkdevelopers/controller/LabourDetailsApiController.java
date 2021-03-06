package com.bionische.arkkdevelopers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.arkkdevelopers.model.GetEmployeeReportDetails;
import com.bionische.arkkdevelopers.model.Info;
import com.bionische.arkkdevelopers.model.LabourDetails;
import com.bionische.arkkdevelopers.repository.GetEmployeeReportDetailsRepository;
import com.bionische.arkkdevelopers.repository.LabourDetailsRepository;

@RestController
public class LabourDetailsApiController {

	
	@Autowired
	LabourDetailsRepository labourDetailsRepository;
	
	@Autowired
	GetEmployeeReportDetailsRepository getEmployeeReportDetailsRepository;
	
	
	@RequestMapping(value = { "/insertLabourDetails" }, method = RequestMethod.POST)
	public @ResponseBody LabourDetails  insertLabourDetails(@RequestBody LabourDetails LabourDetails)
	{
		LabourDetails labourDetailsRes=new LabourDetails();

		try {
			labourDetailsRes=	labourDetailsRepository.save(LabourDetails);
			
		}
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		
		return labourDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getLabourDetailsByLabourId" }, method = RequestMethod.POST)
	public @ResponseBody LabourDetails  getLabourDetailsByLabourId(@RequestParam("labourId") int labourId)
	{
		LabourDetails labourDetailsRes=new LabourDetails();

		try {
			labourDetailsRes=	labourDetailsRepository.findByLabourIdAndInt1(labourId, 0);
			
		}
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		
		return labourDetailsRes;
	}
	
	
	@RequestMapping(value = { "/getLabourDetailsBySiteId" }, method = RequestMethod.POST)
	public @ResponseBody List<LabourDetails>  getLabourDetailsBySiteId(@RequestParam("siteId") int siteId)
	{
		List<LabourDetails> labourDetailsList=new ArrayList<LabourDetails>();

		try {
			labourDetailsList=	labourDetailsRepository.findBySiteContainingAndInt1(siteId, 0);
			
		}
		
		
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		
		return labourDetailsList;
		
	}
	
	
	
	@RequestMapping(value = { "/deleteLabour" }, method = RequestMethod.POST)
	public @ResponseBody Info  deleteLabour(@RequestParam("labourId") int labourId)
	{
		Info info=new Info();
int res=0;
		try {
			res=	labourDetailsRepository.deleteLabour(labourId);
			if(res>0)
			{
				info.setError(false);
				info.setMessage("Delete Successfully");
			}
		}
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		
		return info;
	}
	
	
	@RequestMapping(value = { "/getEmpAttendenceByLabourIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeReportDetails> getEmpAttendenceByLabourIdAndDate(@RequestParam("userId") String empId, @RequestParam("from")String fromDate, @RequestParam("to")String toDate)
	{
		System.out.println("dsfsf");
		List<GetEmployeeReportDetails> getEmployeeReportDetailsList=new ArrayList<GetEmployeeReportDetails>();
		Info info=new Info();
		try
		{
			getEmployeeReportDetailsList= getEmployeeReportDetailsRepository.getAttendenceByUserIdAndBetweenDate(empId, fromDate, toDate);
			System.out.println("res:"+getEmployeeReportDetailsList.toString());
			 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return getEmployeeReportDetailsList;
	}
	
	
	@RequestMapping(value = { "/getAttendenceBySiteAndBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeReportDetails> getAttendenceBySiteAndBetweenDate(@RequestParam("site") String site, @RequestParam("from")String fromDate, @RequestParam("to")String toDate)
	{
		System.out.println("dsfsf");
		List<GetEmployeeReportDetails> getEmployeeReportDetailsList=new ArrayList<GetEmployeeReportDetails>();
		Info info=new Info();
		try
		{
			getEmployeeReportDetailsList= getEmployeeReportDetailsRepository.getAttendenceBySiteAndBetweenDate(site, fromDate, toDate);
			System.out.println("res:"+getEmployeeReportDetailsList.toString());
			 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		
		
		return getEmployeeReportDetailsList;
	}
	
} 
