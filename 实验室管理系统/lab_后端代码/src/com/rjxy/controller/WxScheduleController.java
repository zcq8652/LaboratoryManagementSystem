package com.rjxy.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Lab;
import com.rjxy.model.Schedule;
import com.rjxy.service.ILabService;
import com.rjxy.service.IScheduleService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxSchedule")
public class WxScheduleController {
	private IScheduleService scheduleService;
	@Resource
	public void setScheduleService(IScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	private ILabService labService;
	@Resource
	public void setLabService(ILabService labService) {
		this.labService = labService;
	}
	//΢�Ŷ˿α��ѯ
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡ��ѯid
		String id = req.getParameter("l_Id");
		JSONObject jsonObject = new JSONObject();
		List<Schedule> Schedules = null;
		if(id == null){
			//��ѯʵ��������
			List<Lab> labs = labService.list();
			//��ѯ�α�����
			Schedules = scheduleService.listId(labs.get(0).getL_Id());
			jsonObject.put("labs", labs);
		}else{
			//��ѯ�α�����
			Schedules = scheduleService.listId(id);
		}
		jsonObject.put("Schedules", Schedules);
		resp.getWriter().write(jsonObject.toString());
	}
}
