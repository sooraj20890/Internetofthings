package com.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.service.EmulatorDTO;
import com.service.EmulatorService;

@Rule (name = "Over weight rule",
description = "you are over weight")
public class OverWeightRule {
//over weight easy rule	
	private EmulatorDTO emulatorDTO;
	
	@Condition
    public boolean checkInput() {
		String value = emulatorDTO.getValue();
       
       int weight = Integer.parseInt(value);
       if(weight > 165)
    	   return true;
       else
    	   { 
    	   System.out.println("inside overweight else");
    	   return false;}
    }
	
	@Action
    public void actionMethod() throws Exception {
		String timeStamp=emulatorDTO.getTimeStamp();
		String value=emulatorDTO.getValue();
		String alertMessage = "you are over weight";        
        EmulatorService emulatorService=new EmulatorService();
        emulatorService.saveAlert(timeStamp, value, alertMessage);
    }

	 public void setInput(EmulatorDTO emulatorDTO) {
	        this.emulatorDTO = emulatorDTO;
	    }
}
