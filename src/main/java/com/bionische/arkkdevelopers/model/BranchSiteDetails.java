package com.bionische.arkkdevelopers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch_site_details")
public class BranchSiteDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_site_id")
	private int branchSiteId;

	@Column(name = "name")
	private String name;

	@Column(name = "date")
	private String date;

	@Column(name = "contact")
	private String contact;

	@Column(name = "address")
	private String address;

	@Column(name = "device_id")
	private int deviceId;
	
	@Column(name = "string_2")
	private String string_2;

	@Column(name = "string_1")
	private String string_1;

	@Column(name = "type")
	private int type;

	@Column(name = "int_2")
	private int int2;

	@Column(name = "int_1")
	private int int1;

	public int getBranchSiteId() {
		return branchSiteId;
	}

	public void setBranchSiteId(int branchSiteId) {
		this.branchSiteId = branchSiteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getString_2() {
		return string_2;
	}

	public void setString_2(String string_2) {
		this.string_2 = string_2;
	}

	public String getString_1() {
		return string_1;
	}

	public void setString_1(String string_1) {
		this.string_1 = string_1;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	@Override
	public String toString() {
		return "BranchSiteDetails [branchSiteId=" + branchSiteId + ", name=" + name + ", date=" + date + ", contact="
				+ contact + ", address=" + address + ", deviceId=" + deviceId + ", string_2=" + string_2 + ", string_1="
				+ string_1 + ", type=" + type + ", int2=" + int2 + ", int1=" + int1 + "]";
	}
 
}
