package com.rjxy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Safe;
import com.rjxy.service.ISafeService;

@Controller
@RequestMapping("/Safe")
public class SafeController {
	private ISafeService safeService;
	@Resource
	public void setSafeService(ISafeService safeService) {
		this.safeService = safeService;
	}
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String query(Model model){
		//获取安全检查数据
		List<Safe> safes = safeService.list();
		model.addAttribute("safes", safes);
		model.addAttribute("path", "safe.jsp");
		return "admin/main/main";
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(){
		//删除所有数据
		safeService.deleteAll();
		return "redirect:/Main/toSafe";
	}
}
