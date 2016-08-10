package com.service.morphia;

import java.util.ArrayList;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;
import org.springframework.data.annotation.Id;

@Entity("alerts")
@Indexes(
	    @Index(fields = @Field("timeStamp"))
	)
public class Alert {
//morphia mapping class	
	@Id
	private ObjectId id;
	private String timeStamp;
	private String value;
    private String alertMessage;	
	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	@Reference
	private List<Alert> allAlerts = new ArrayList<Alert>();
	
	@Reference
	private List<Alert> alertsInRange = new ArrayList<Alert>();

	

	public Alert(String timeStamp, String value, String alertMessage) {
		this.timeStamp = timeStamp;
		this.value = value;
		this.alertMessage = alertMessage;
	}

	public Alert() {
	
	}

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

	public List<Alert> getAllAlerts() {
		return allAlerts;
	}

	public void setAllAlerts(List<Alert> allAlerts) {
		this.allAlerts = allAlerts;
	}

	public List<Alert> getAlertsInRange() {
		return alertsInRange;
	}

	public void setAlertsInRange(List<Alert> alertsInRange) {
		this.alertsInRange = alertsInRange;
	}
    
	
}
