package com.bionische.arkkdevelopers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetEmployeeReportDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="device_log_id")
	private int deviceLogId;
	
	
	@Column(name="user_Id")
	private int userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="branch")
	private String branchSite;
	
	
	@Column(name="date")
	private String date;
	
	@Column(name="in_time")
	private String inTime;
	
	@Column(name="out_time")
	private String outTime;
 
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBranchSite() {
		return branchSite;
	}

	public void setBranchSite(String branchSite) {
		this.branchSite = branchSite;
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

	public int getDeviceLogId() {
		return deviceLogId;
	}

	public void setDeviceLogId(int deviceLogId) {
		this.deviceLogId = deviceLogId;
	}

	@Override
	public String toString() {
		return "GetEmployeeReportDetails [deviceLogId=" + deviceLogId + ", userId=" + userId + ", name=" + name
				+ ", branchSite=" + branchSite + ", date=" + date + ", inTime=" + inTime + ", outTime=" + outTime + "]";
	}

	

	 

	 

 
	

}
