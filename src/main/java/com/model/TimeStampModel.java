package com.model;

public class TimeStampModel {
	//this class is used to carry the time range values which is used as a condition
    String startTimeStamp;
    String endTimeStamp;
	public String getStartTimeStamp() {
		return startTimeStamp;
	}
	public void setStartTimeStamp(String startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}
	public TimeStampModel(String startTimeStamp, String endTimeStamp) {
	
		this.startTimeStamp = startTimeStamp;
		this.endTimeStamp = endTimeStamp;
	}
	public TimeStampModel() {
		
	}
	public String getEndTimeStamp() {
		return endTimeStamp;
	}
	public void setEndTimeStamp(String endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
}
