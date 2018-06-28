package com.bionische.arkkdevelopers.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetLabourSalaryDetails {

	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="labour_id")
	private int labourId;
	
	 @Transient
	private int noOfDays;
	
	@Column(name="name")
	private String name;
	
 
	
	@Column(name="salary")
	private int salary;

	@Transient
	List<LabourSalaryDetailsList> labourSalaryDetailsList;

	public int getLabourId() {
		return labourId;
	}



	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}



	public int getNoOfDays() {
		return noOfDays;
	}



	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public List<LabourSalaryDetailsList> getLabourSalaryDetailsList() {
		return labourSalaryDetailsList;
	}



	public void setLabourSalaryDetailsList(List<LabourSalaryDetailsList> labourSalaryDetailsList) {
		this.labourSalaryDetailsList = labourSalaryDetailsList;
	}



	@Override
	public String toString() {
		return "GetLabourSalaryDetails [labourId=" + labourId + ", noOfDays=" + noOfDays + ", name=" + name
				+ ", salary=" + salary + ", labourSalaryDetailsList=" + labourSalaryDetailsList + "]";
	}



	 

	
	
	
}
