package com.service;

import java.util.List;

public interface EmulatorServiceInterface {
//service interface
		void saveAlert(String timeStamp, String value, String alertMessage);

		List<AlertDTO> seeAlerts();

		List<AlertDTO> seeInRangeAlerts(String startTimelapse, String endTimelapse);

		void saveMetricsService(EmulatorDTO emulatorDTO);

		List<EmulatorDTO> viewMetricsService();

		List<EmulatorDTO> viewMetricsInRangeService(String startTimelapse, String endTimelapse);

	
}
