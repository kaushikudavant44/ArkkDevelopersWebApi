package com.bionische.arkkdevelopers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_details")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_details_id")
	private int empDetailsId;
	
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="device_id")
	private int deviceId;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="document")
	private String document;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;

	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;

	public int getEmpDetailsId() {
		return empDetailsId;
	}

	public void setEmpDetailsId(int empDetailsId) {
		this.empDetailsId = empDetailsId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empDetailsId=" + empDetailsId + ", empId=" + empId + ", name=" + name + ", gender="
				+ gender + ", dob=" + dob + ", email=" + email + ", mobileNo=" + mobileNo + ", address=" + address
				+ ", branch=" + branch + ", designation=" + designation + ", salary=" + salary + ", deviceId="
				+ deviceId + ", photo=" + photo + ", document=" + document + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + "]";
	}

	

}
