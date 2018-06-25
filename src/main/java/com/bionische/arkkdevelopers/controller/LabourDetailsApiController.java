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

import com.bionische.arkkdevelopers.model.LabourDetails;
import com.bionische.arkkdevelopers.repository.LabourDetailsRepository;

@RestController
public class LabourDetailsApiController {

	
	@Autowired
	LabourDetailsRepository labourDetailsRepository;
	
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
			labourDetailsRes=	labourDetailsRepository.findByLabourId(labourId);
			
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
			labourDetailsList=	labourDetailsRepository.findBySiteContaining(siteId);
			
		}
		
		
catch (Exception e) {
	System.out.println(e.getMessage());// TODO: handle exception
}
		
		return labourDetailsList;
		
	}
	
} 
