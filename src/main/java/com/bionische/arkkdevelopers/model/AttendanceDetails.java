package com.bionische.arkkdevelopers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DeviceLogs")
public class AttendanceDetails {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DeviceLogId")
	private int deviceLogId;
	
	@Column(name = "DeviceId")
	private int deviceId;
	
	@Column(name = "DownloadDate")
	private String downloadDate;
	
	@Column(name = "UserId")
	private String userId;
	
	@Column(name = "LogDate")
	private String logDate;
	
	@Column(name = "Direction")
	private String direction;
	
	@Column(name = "AttDirection")
	private String attDirection;
	
	@Column(name = "C1")
	private String c1;
	
	@Column(name = "C2")
	private String c2;
	
	@Column(name = "C3")
	private String c3;
	
	@Column(name = "C4")
	private String c4;
	
	@Column(name = "C5")
	private String c5;
	
	@Column(name = "C6")
	private String c6;
	
	@Column(name = "C7")
	private String c7;
	
	@Column(name = "WorkCode")
	private String workCode;

	public int getDeviceLogId() {
		return deviceLogId;
	}

	public void setDeviceLogId(int deviceLogId) {
		this.deviceLogId = deviceLogId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAttDirection() {
		return attDirection;
	}

	public void setAttDirection(String attDirection) {
		this.attDirection = attDirection;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public String getC3() {
		return c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public String getC4() {
		return c4;
	}

	public void setC4(String c4) {
		this.c4 = c4;
	}

	public String getC5() {
		return c5;
	}

	public void setC5(String c5) {
		this.c5 = c5;
	}

	public String getC6() {
		return c6;
	}

	public void setC6(String c6) {
		this.c6 = c6;
	}

	public String getC7() {
		return c7;
	}

	public void setC7(String c7) {
		this.c7 = c7;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	@Override
	public String toString() {
		return "AttendanceDetails [deviceLogId=" + deviceLogId + ", deviceId=" + deviceId + ", downloadDate="
				+ downloadDate + ", userId=" + userId + ", logDate=" + logDate + ", direction=" + direction
				+ ", attDirection=" + attDirection + ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + ", c4=" + c4 + ", c5="
				+ c5 + ", c6=" + c6 + ", c7=" + c7 + ", workCode=" + workCode + "]";
	}

	
	
}
