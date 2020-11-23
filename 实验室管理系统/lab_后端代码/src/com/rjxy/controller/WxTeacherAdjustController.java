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

import com.rjxy.model.Adjust;
import com.rjxy.model.TeacherAdjust;
import com.rjxy.service.IAdjustService;
import com.rjxy.service.ITeacherAdjustService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxTeacherAdjust")
public class WxTeacherAdjustController {
	private ITeacherAdjustService teacherAdjustService;
	@Resource
	public void setTeacherAdjustService(ITeacherAdjustService teacherAdjustService) {
		this.teacherAdjustService = teacherAdjustService;
	}
	private IAdjustService adjustService;
	@Resource
	public void setAdjustService(IAdjustService adjustService) {
		this.adjustService = adjustService;
	}

	//��ͣ������
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ��ͣ������
		String t_Id = req.getParameter("t_Id");
		String t_name = req.getParameter("t_name");
		String ta_content = req.getParameter("ta_content");
		//��ȡϵͳ��ǰʱ��
		Date date = new Date();
		String ta_date = new SimpleDateFormat("MM-dd").format(date);
		//��װ���ݣ���ʦ��
		TeacherAdjust ta = new TeacherAdjust();
		ta.setT_Id(t_Id);
		ta.setT_name(t_name);
		ta.setTa_content(ta_content);
		ta.setTa_date(ta_date);
		ta.setTa_state("2");
		//��װ���ݣ�����Ա��
		Adjust adjust = new Adjust();
		adjust.setT_Id(t_Id);
		adjust.setT_name(t_name);
		adjust.setAd_content(ta_content);
		adjust.setAd_date(ta_date);
		adjust.setAd_state("2");
		//�洢����
		adjustService.add(adjust);
		ta.setTa_Id(adjust.getAd_Id());
		teacherAdjustService.add(ta);
		//��ѯ���û���ͣ����������
		List<TeacherAdjust> tas = teacherAdjustService.listId(t_Id);
		jsonObject.put("tas", tas);
		resp.getWriter().write(jsonObject.toString());
	}
	//���û���ͣ����������
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ���û�id
		String u_Id = req.getParameter("u_Id");
		//��ѯ���û���ͣ����������
		List<TeacherAdjust> tas = teacherAdjustService.listId(u_Id);
		jsonObject.put("tas", tas);
		resp.getWriter().write(jsonObject.toString());
	}
	//ɾ����ͣ������
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ���û�id������id
		String u_Id = req.getParameter("u_Id");
		int ta_Id = Integer.valueOf(req.getParameter("ta_Id"));
		//ɾ������
		teacherAdjustService.delete(ta_Id);
		//��ѯ���û���ͣ����������
		List<TeacherAdjust> tas = teacherAdjustService.listId(u_Id);
		jsonObject.put("tas", tas);
		resp.getWriter().write(jsonObject.toString());
	}
}
