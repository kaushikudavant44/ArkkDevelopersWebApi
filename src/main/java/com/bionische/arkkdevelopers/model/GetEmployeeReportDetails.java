package com.bionische.arkkdevelopers.model;

public class GetEmployeeReportDetails {
	
	private int empId;
	
	private String name;
	
	private String branch;
	
	private String date;
	
	private String inTime;
	
	private String outTime;
	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GetEmployeeReportDetails [empId=" + empId + ", name=" + name + ", branch=" + branch + ", date=" + date
				+ ", inTime=" + inTime + ", outTime=" + outTime + "]";
	}
	
	
	

}
