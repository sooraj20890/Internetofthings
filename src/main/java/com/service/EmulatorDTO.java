package com.service;

public class EmulatorDTO {
	//data transfer object to transport data in business layer	
	String timeStamp;
	String value;
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public EmulatorDTO(String timeStamp, String value) {
	
		this.timeStamp = timeStamp;
		this.value = value;
	}
	public EmulatorDTO() {
		
	}

}
