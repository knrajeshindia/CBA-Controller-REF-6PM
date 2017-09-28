package com.cba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cba.processing.OperationalService;

@Controller
public class BankOperationsController {
	@Autowired
	private OperationalService operationalService;
   @RequestMapping(value="bankOperations",method=RequestMethod.GET)
	public String showBankOperations(){
		return "bankOperations";
	}
   @RequestMapping(value="deposit",method=RequestMethod.GET)
  @ResponseBody
   public String showDeposit(){
  		return "";
  	}
   @RequestMapping(value="checkAccountStatus",method=RequestMethod.GET)
   @ResponseBody
    public String checkAccountStatus(
    		@RequestParam("accountNumber") String accountNumber){
	   return operationalService.checkAccountStatusInfo(accountNumber);
   
   	}
}
