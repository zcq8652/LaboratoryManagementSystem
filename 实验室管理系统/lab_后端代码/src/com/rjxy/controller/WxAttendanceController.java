package com.rjxy.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Attendance;
import com.rjxy.service.IAttendanceService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxAttendance")
public class WxAttendanceController {
	private IAttendanceService attendanceService;
	@Resource
	public void setAttendanceService(IAttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	//签到与签退
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取签到或签退数据
		String t_name = req.getParameter("t_name");
		String t_Id = req.getParameter("t_Id");
		String at_at = req.getParameter("at_at");
		//获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//封装数据
		Attendance attendance = new Attendance();
		attendance.setT_Id(t_Id);
		attendance.setT_name(t_name);
		attendance.setAt_at(at_at);
		attendance.setAt_time(Timestamp.valueOf(sdf.format(date)));
		//存储数据
		attendanceService.add(attendance);
	}
	//考勤情况
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取签到数据
		List<Attendance> attendances = attendanceService.list();
		//处理时间数据
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		for (Attendance attendance : attendances) {
			attendance.setSat_time(sdf.format(attendance.getAt_time()).toString());
			attendance.setAt_time(null);
		}
		jsonObject.put("attendances", attendances);
		resp.getWriter().write(jsonObject.toString());
	}
	//删除考勤数据
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取id
		int at_Id = Integer.parseInt(req.getParameter("at_Id"));
		//删除数据
		attendanceService.delete(at_Id);
		//获取最新签到数据
		List<Attendance> attendances = attendanceService.list();
		//处理时间数据
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		for (Attendance attendance : attendances) {
			attendance.setSat_time(sdf.format(attendance.getAt_time()).toString());
			attendance.setAt_time(null);
		}
		jsonObject.put("attendances", attendances);
		resp.getWriter().write(jsonObject.toString());
	}
}
