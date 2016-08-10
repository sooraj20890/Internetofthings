package com.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.service.EmulatorDTO;
import com.service.EmulatorService;

@Rule (name = "Under weight rule",
description = "you are under weight")
public class UnderWeightRule {
//under weight easy rule	
	private EmulatorDTO emulatorDTO;
	
	@Condition
    public boolean checkInput() {
		String value = emulatorDTO.getValue();
       
       int weight = Integer.parseInt(value);
       if(weight < 135)
       {
    	   System.out.println("inside underweight if");
    	   return true;
       }
       else
    	   { return false;}
    }
	
	@Action
    public void actionMethod() throws Exception {
		String timeStamp=emulatorDTO.getTimeStamp();
		String value=emulatorDTO.getValue();
		String alertMessage = "you are under weight";
		EmulatorService emulatorService=new EmulatorService();
		emulatorService.saveAlert(timeStamp, value, alertMessage);
    }
	
	 public void setInput(EmulatorDTO emulatorDTO) {
	        this.emulatorDTO = emulatorDTO;
	    }
}
