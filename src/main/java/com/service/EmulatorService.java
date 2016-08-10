package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.easyrules.api.Rule;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.easyrules.core.RulesEngineParameters;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.AlertModel;
import com.model.EmulatorModel;
import com.rules.OverWeightRule;
import com.rules.UnderWeightRule;
import com.service.morphia.Alert;
import com.service.morphia.Metric;
import com.service.morphia.MorphiaImplementation;

@Service
public class EmulatorService implements EmulatorServiceInterface {
//auto wired entities need to be services
	//service impl
	@Autowired 
	MorphiaImplementation morphiaImplementation=new MorphiaImplementation();;
	
	Datastore datastore = morphiaImplementation.createDatastore();
	@Override
	public void saveMetricsService(EmulatorDTO emulatorDTO) {
		
		
		OverWeightRule overWeightRule=new OverWeightRule();
		overWeightRule.setInput(emulatorDTO);
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
		rulesEngine.registerRule(overWeightRule);
		rulesEngine.fireRules();
		
		UnderWeightRule underWeightRule=new UnderWeightRule();
		underWeightRule.setInput(emulatorDTO);
		RulesEngine rulesEngineUnderWeight = RulesEngineBuilder.aNewRulesEngine().build();
		rulesEngineUnderWeight.registerRule(underWeightRule);
		rulesEngineUnderWeight.fireRules();
		
		morphiaImplementation.storeMetric(emulatorDTO.getTimeStamp(), emulatorDTO.getValue(), datastore);
	}
	
	public EmulatorDTO converter(EmulatorModel emulator)
	{
	EmulatorDTO emulatorDTO=new EmulatorDTO();
	emulatorDTO.setTimeStamp(emulator.getTimeStamp());
	emulatorDTO.setValue(emulator.getValue());
	return emulatorDTO;
    }
	
	public AlertDTO alertConverter(AlertModel alert)
	{
		AlertDTO alertDTO=new AlertDTO();
		alertDTO.setTimeStamp(alert.getTimeStamp());
		alertDTO.setValue(alert.getValue());
		alertDTO.setAlertMessage(alert.getAlertMessage());
	    return alertDTO;
    }
	
	public EmulatorModel reverseConverter(EmulatorDTO emulatorDTO)
	{
	EmulatorModel emulator=new EmulatorModel();
	emulator.setTimeStamp(emulatorDTO.getTimeStamp());
	emulator.setValue(emulatorDTO.getValue());
	return emulator;
    }
	
	public AlertModel alertReverseConverter(AlertDTO alertDTO)
	{
	AlertModel alert=new AlertModel();
	alert.setTimeStamp(alertDTO.getTimeStamp());
	alert.setValue(alertDTO.getValue());
	alert.setAlertMessage(alertDTO.getAlertMessage());
	return alert;
    }

	@Override
	public List<EmulatorDTO> viewMetricsService() {
		List<Metric> metricList=morphiaImplementation.retrieveMetric(datastore);
		List<EmulatorDTO> emulatorDTOList = new ArrayList<EmulatorDTO>();
		for (Metric metric : metricList) {
			EmulatorDTO emulatorDTO=new EmulatorDTO();
			emulatorDTO.setTimeStamp(metric.getTimeStamp());
			emulatorDTO.setValue(metric.getValue());
			emulatorDTOList.add(emulatorDTO);
		}
		return emulatorDTOList;
	}
	
	@Override
	public List<AlertDTO> seeAlerts() {
		List<Alert> alertList=morphiaImplementation.retrieveAlert(datastore);
		List<AlertDTO> alertDTOList = new ArrayList<AlertDTO>();
		for (Alert alert : alertList) {
			AlertDTO alertDTO=new AlertDTO();
			alertDTO.setTimeStamp(alert.getTimeStamp());
			alertDTO.setValue(alert.getValue());
			alertDTO.setAlertMessage(alert.getAlertMessage());
			alertDTOList.add(alertDTO);
		}
		return alertDTOList;
	}
	
	@Override
	public List<EmulatorDTO> viewMetricsInRangeService(String starTimeLapse,String endTimeLapse) {
		List<Metric> metricList=morphiaImplementation.retrieveMetricInRange(starTimeLapse, starTimeLapse, datastore);
		List<EmulatorDTO> emulatorDTOList = new ArrayList<EmulatorDTO>();
		for (Metric metric : metricList) {
			EmulatorDTO emulatorDTO=new EmulatorDTO();
			emulatorDTO.setTimeStamp(metric.getTimeStamp());
			emulatorDTO.setValue(metric.getValue());
			emulatorDTOList.add(emulatorDTO);
		}
		return emulatorDTOList;
	}
	
	@Override
	public List<AlertDTO> seeInRangeAlerts(String starTimeLapse,String endTimeLapse) {
		List<Alert> alertList=morphiaImplementation.retrieveAlertInRange(starTimeLapse, endTimeLapse, datastore);
		List<AlertDTO> alertDTOList = new ArrayList<AlertDTO>();
		for (Alert alert : alertList) {
			AlertDTO alertDTO=new AlertDTO();
			alertDTO.setTimeStamp(alert.getTimeStamp());
			alertDTO.setValue(alert.getValue());
			alertDTO.setAlertMessage(alert.getAlertMessage());
			alertDTOList.add(alertDTO);
		}
		return alertDTOList;
	}
	
	
	@Override
	public void saveAlert(String timeStamp,String value,String alertMessage)
	{
		morphiaImplementation.storeAlert(timeStamp, value, alertMessage, datastore);
	}

}
