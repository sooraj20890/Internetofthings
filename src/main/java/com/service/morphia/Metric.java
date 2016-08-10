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

@Entity("metrics")
@Indexes(
	    @Index(fields = @Field("timeStamp"))
	)
public class Metric {
	//morphia mapping class	
	@Id
	private ObjectId id;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	private String timeStamp;
	private String value;
	
	@Reference
	private List<Metric> allMetrics = new ArrayList<Metric>();
	
	@Reference
	private List<Metric> metricsInRange = new ArrayList<Metric>();
	
	
	
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

	public List<Metric> getAllMetrics() {
		return allMetrics;
	}

	public void setAllMetrics(List<Metric> allMetrics) {
		this.allMetrics = allMetrics;
	}

	public List<Metric> getMetricsInRange() {
		return metricsInRange;
	}

	public void setMetricsInRange(List<Metric> metricsInRange) {
		this.metricsInRange = metricsInRange;
	}

	public Metric()
	{
		
	}

	public Metric(String timeStamp, String value) {
		this.timeStamp = timeStamp;
		this.value = value;
		
	}
	
}
