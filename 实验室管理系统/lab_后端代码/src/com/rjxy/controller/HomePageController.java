package com.rjxy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.service.IAdjustService;

@Controller
@RequestMapping("/HomePage")
public class HomePageController {
	private IAdjustService adjustService;
	@Resource
	public void setAdjustService(IAdjustService adjustService) {
		this.adjustService = adjustService;
	}
//	@RequestMapping("/toAdjust")
//	public String toAdjust(Model model){
//		List<Adjust> adjusts = adjustService.
//	}
}
