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

import com.rjxy.model.Safe;
import com.rjxy.service.ISafeService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxSafe")
public class WxSafeController {
	private ISafeService safeService;
	@Resource
	public void setSafeService(ISafeService safeService) {
		this.safeService = safeService;
	}
	//安全检查
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//获取安全检查信息
		String sf_u_Id = req.getParameter("sf_u_Id");
		String sf_u_name = req.getParameter("sf_u_name");
		String sf_result = req.getParameter("sf_result");
		//获取系统当前时间
		Date date = new Date();
		String sf_time = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//封装数据
		Safe safe = new Safe();
		safe.setSf_u_Id(sf_u_Id);
		safe.setSf_u_name(sf_u_name);
		safe.setSf_time(sf_time);
		safe.setSf_result(sf_result);
		//保存数据
		safeService.add(safe);
	}
	//查看安全检查结果
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取安全检查数据
		List<Safe> safes = safeService.list();
		jsonObject.put("safes", safes);
		resp.getWriter().write(jsonObject.toString());
	}
	//删除数据根据id
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取数据id
		int sf_Id = Integer.parseInt(req.getParameter("sf_Id"));
		//删除数据
		safeService.delete(sf_Id);
		//获取最新安全检查数据
		List<Safe> safes = safeService.list();
		jsonObject.put("safes", safes);
		resp.getWriter().write(jsonObject.toString());
	}
}
