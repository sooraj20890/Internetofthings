package com.service.morphia;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
@Service
public class MorphiaImplementation {
	//morphia service impl which communicates with mongodb using datastore
	//data is persistent across transactions as in real time
	 public MorphiaImplementation() {
	    }
	 
	 public Datastore createDatastore()
	 {
		 final Morphia morphia = new Morphia();
		 final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_datastore");
	        datastore.ensureIndexes();
	        return datastore;
	 }
	 
	 public void storeMetric(String timeStamp,String value,Datastore datastore)
	 {
		
		 final Metric aMetric=new Metric(timeStamp, value);
		 datastore.save(aMetric);
		 System.out.println(" aMetric timestamp " + aMetric.getTimeStamp() );
		 
	 }
	 
	 public void storeAlert(String timeStamp,String value,String alertMessage,Datastore datastore)
	 {
		 final Alert anAlert=new Alert(timeStamp, value, alertMessage);
		 datastore.save(anAlert);
		 
	 }
	 
	 public List<Metric> retrieveMetric(Datastore datastore)
	 {
		 final Query<Metric> query = datastore.createQuery(Metric.class);
		 final List<Metric> metrics = query.asList();
		 return metrics;
	 }
	 
	 public List<Alert> retrieveAlert(Datastore datastore)
	 {
		 final Query<Alert> query = datastore.createQuery(Alert.class);
		 final List<Alert> alerts = query.asList();
		 return alerts;
	 }
	 
	 public List<Metric> retrieveMetricInRange(String startTimeStamp,String endTimeStamp,Datastore datastore)
	 {
		 List<Metric> metricInRange = datastore.createQuery(Metric.class)
				                       .filter("timeStamp >",startTimeStamp )
				                       .filter("timeStamp <", endTimeStamp)
				                       .asList();
		       
		 return metricInRange;
	 }
	 public List<Alert> retrieveAlertInRange(String startTimeStamp,String endTimeStamp,Datastore datastore)
	 {
		 List<Alert> alertInRange = datastore.createQuery(Alert.class)
                 .filter("timeStamp >",startTimeStamp )
                 .filter("timeStamp <", endTimeStamp)
                 .asList();

         return alertInRange;
	 }

}
