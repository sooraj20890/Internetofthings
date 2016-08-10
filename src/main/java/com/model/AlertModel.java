package com.model;

public class AlertModel {
	//Model class which is used to carry/store the information regarding alerts generated to display
	String timeStamp;
	String value;
	String alertMessage;
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public AlertModel(String timeStamp, String value, String alertMessage) {
		this.timeStamp = timeStamp;
		this.value = value;
		this.alertMessage = alertMessage;
	}
	public AlertModel() {
	}

}
