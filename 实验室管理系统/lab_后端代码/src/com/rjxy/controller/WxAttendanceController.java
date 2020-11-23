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
	//ǩ����ǩ��
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//��ȡǩ����ǩ������
		String t_name = req.getParameter("t_name");
		String t_Id = req.getParameter("t_Id");
		String at_at = req.getParameter("at_at");
		//��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//��װ����
		Attendance attendance = new Attendance();
		attendance.setT_Id(t_Id);
		attendance.setT_name(t_name);
		attendance.setAt_at(at_at);
		attendance.setAt_time(Timestamp.valueOf(sdf.format(date)));
		//�洢����
		attendanceService.add(attendance);
	}
	//�������
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡǩ������
		List<Attendance> attendances = attendanceService.list();
		//����ʱ������
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		for (Attendance attendance : attendances) {
			attendance.setSat_time(sdf.format(attendance.getAt_time()).toString());
			attendance.setAt_time(null);
		}
		jsonObject.put("attendances", attendances);
		resp.getWriter().write(jsonObject.toString());
	}
	//ɾ����������
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡid
		int at_Id = Integer.parseInt(req.getParameter("at_Id"));
		//ɾ������
		attendanceService.delete(at_Id);
		//��ȡ����ǩ������
		List<Attendance> attendances = attendanceService.list();
		//����ʱ������
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		for (Attendance attendance : attendances) {
			attendance.setSat_time(sdf.format(attendance.getAt_time()).toString());
			attendance.setAt_time(null);
		}
		jsonObject.put("attendances", attendances);
		resp.getWriter().write(jsonObject.toString());
	}
}
