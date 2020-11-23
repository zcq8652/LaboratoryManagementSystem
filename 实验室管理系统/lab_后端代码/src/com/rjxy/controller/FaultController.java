package com.rjxy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.service.IFaultService;

@Controller
@RequestMapping("/Fault")
public class FaultController {
	private IFaultService faultService;
	@Resource
	public void setFaultService(IFaultService faultService) {
		this.faultService = faultService;
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(){
		//É¾³ýÊý¾Ý
		faultService.deleteAll();
		return "redirect:/Main/toFault";
	}
}
