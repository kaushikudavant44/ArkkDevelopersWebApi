package com.bionische.arkkdevelopers.model;

public class LabourSalaryDetailsList {

	
	
	float amount;
	float workingHour;
	String date;
	String inTime;
	String outTime;
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getWorkingHour() {
		return workingHour;
	}
	public void setWorkingHour(float workingHour) {
		this.workingHour = workingHour;
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
	@Override
	public String toString() {
		return "LabourSalaryDetailsList [amount=" + amount + ", workingHour=" + workingHour + ", date=" + date
				+ ", inTime=" + inTime + ", outTime=" + outTime + "]";
	}
	
	
	
}
