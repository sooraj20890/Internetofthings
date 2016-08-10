package com.model;

public class EmulatorModel {
	
	//Emulator model class which is used to carry request information across application
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
	public EmulatorModel(String timeStamp, String value) {
		
		this.timeStamp = timeStamp;
		this.value = value;
	}
	public EmulatorModel() {
		
	}
	
	

}
