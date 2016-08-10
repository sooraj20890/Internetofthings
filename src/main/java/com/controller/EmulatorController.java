package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.AlertModel;
import com.model.EmulatorModel;
import com.model.TimeStampModel;
import com.service.AlertDTO;
import com.service.EmulatorDTO;
import com.service.EmulatorService;


@RestController
@RequestMapping("api/emulator")
public class EmulatorController {

//Rest Controller which exposes 5 APIs	
	@Autowired
	EmulatorService emulatorService; 
	@RequestMapping(
			value="/createMetric",
			method= RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public EmulatorModel saveMetric(@RequestBody EmulatorModel emulatorModel)
	{
		String timeStamp = emulatorModel.getTimeStamp();
		String value = emulatorModel.getValue();
		EmulatorDTO emulatorDTO=new EmulatorDTO();
		emulatorDTO.setTimeStamp(timeStamp);
		emulatorDTO.setValue(value);
		emulatorService.saveMetricsService(emulatorDTO);
		return emulatorModel;
	}
	 
	@RequestMapping(
			value="/readAllMetrics",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<EmulatorModel> getMetrics()
	{
		List<EmulatorModel> emulatorModelList=new ArrayList<EmulatorModel>();
		List<EmulatorDTO> emulatorDTOList = emulatorService.viewMetricsService();
		for (EmulatorDTO emulatorDTO : emulatorDTOList) {
			EmulatorModel emulatorModel= emulatorService.reverseConverter(emulatorDTO);
			emulatorModelList.add(emulatorModel);
		}
		return emulatorModelList;
	}
	
	@RequestMapping(
			value="/readAllMetricsInTimeRange",
			method= RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<EmulatorModel> getMetricsInRange(@RequestBody TimeStampModel timeStampModel)
	{
		List<EmulatorModel> emulatorModelList=new ArrayList<EmulatorModel>();
		List<EmulatorDTO> emulatorDTOList = emulatorService.viewMetricsInRangeService(timeStampModel.getStartTimeStamp(), timeStampModel.getEndTimeStamp());
		for (EmulatorDTO emulatorDTO : emulatorDTOList) {
			EmulatorModel emulatorModel= emulatorService.reverseConverter(emulatorDTO);
			emulatorModelList.add(emulatorModel);
		}
		return emulatorModelList;
	}
	
	@RequestMapping(
			value="/readAllAlerts",
			method= RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<AlertModel> getAlerts( )
	{
		List<AlertModel> alertModelList=new ArrayList<AlertModel>();
		List<AlertDTO> alertDTOList = emulatorService.seeAlerts();
		for (AlertDTO alertDTO : alertDTOList) {
			AlertModel alertModel = emulatorService.alertReverseConverter(alertDTO);
			alertModelList.add(alertModel);
		}
		return alertModelList;
	}
	
	@RequestMapping(
			value="/readAllAlertsInTimeRange",
			method= RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<AlertModel> getAlertsInRange(@RequestBody TimeStampModel timeStampModel)
	{
		List<AlertModel> alertModelList=new ArrayList<AlertModel>();
		List<AlertDTO> alertDTOList = emulatorService.seeInRangeAlerts(timeStampModel.getStartTimeStamp(), timeStampModel.getEndTimeStamp());
		for (AlertDTO alertDTO : alertDTOList) {
			AlertModel alertModel= emulatorService.alertReverseConverter(alertDTO);
			alertModelList.add(alertModel);
		}
		return alertModelList;
	}

}
