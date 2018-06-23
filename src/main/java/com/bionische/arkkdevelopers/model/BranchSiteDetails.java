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

	@Column(name = "string_2")
	private String string_2;

	@Column(name = "string_1")
	private String string_1;

	@Column(name = "type")
	private int type;

	@Column(name = "int_2")
	private int int_2;

	@Column(name = "int_1")
	private int int_1;

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

	public int getInt_2() {
		return int_2;
	}

	public void setInt_2(int int_2) {
		this.int_2 = int_2;
	}

	public int getInt_1() {
		return int_1;
	}

	public void setInt_1(int int_1) {
		this.int_1 = int_1;
	}

	@Override
	public String toString() {
		return "BranchSiteDetails [branchSiteId=" + branchSiteId + ", name=" + name + ", date=" + date + ", contact="
				+ contact + ", address=" + address + ", string_2=" + string_2 + ", string_1=" + string_1 + ", type="
				+ type + ", int_2=" + int_2 + ", int_1=" + int_1 + "]";
	}
	
	

}
