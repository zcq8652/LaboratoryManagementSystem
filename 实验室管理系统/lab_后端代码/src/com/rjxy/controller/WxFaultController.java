package com.rjxy.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Fault;
import com.rjxy.service.IFaultService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxFault")
public class WxFaultController {
	private IFaultService faultService;
	@Resource
	public void setFaultService(IFaultService faultService) {
		this.faultService = faultService;
	}
	//故障申报
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//获取故障信息
		String f_u_Id = req.getParameter("f_u_Id");
		String f_u_name = req.getParameter("f_u_name");
		String f_content = req.getParameter("f_content");
		//获取系统当前时间
		Date date = new Date();
		String f_date = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//封装数据
		Fault fault = new Fault();
		fault.setF_u_Id(f_u_Id);
		fault.setF_u_name(f_u_name);
		fault.setF_content(f_content);
		fault.setF_date(f_date);
		//保存数据
		faultService.add(fault);
	}
	//删除申报
	@RequestMapping("delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取故障Id
		int f_Id = Integer.parseInt(req.getParameter("f_Id"));
		//删除数据
		faultService.delete(f_Id);
		//获取故障数据
		List<Fault> faults = faultService.list();
		//数据转json
		jsonObject.put("faults", faults);
		//数据发给前端
		resp.getWriter().write(jsonObject.toString());
	}
	//获取全部故障申报
	@RequestMapping("select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取故障数据
		List<Fault> faults = faultService.list();
		jsonObject.put("faults", faults);
		resp.getWriter().write(jsonObject.toString());
	}
}
