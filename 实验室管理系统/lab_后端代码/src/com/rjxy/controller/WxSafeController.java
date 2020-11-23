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
	//��ȫ���
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//��ȡ��ȫ�����Ϣ
		String sf_u_Id = req.getParameter("sf_u_Id");
		String sf_u_name = req.getParameter("sf_u_name");
		String sf_result = req.getParameter("sf_result");
		//��ȡϵͳ��ǰʱ��
		Date date = new Date();
		String sf_time = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//��װ����
		Safe safe = new Safe();
		safe.setSf_u_Id(sf_u_Id);
		safe.setSf_u_name(sf_u_name);
		safe.setSf_time(sf_time);
		safe.setSf_result(sf_result);
		//��������
		safeService.add(safe);
	}
	//�鿴��ȫ�����
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ��ȫ�������
		List<Safe> safes = safeService.list();
		jsonObject.put("safes", safes);
		resp.getWriter().write(jsonObject.toString());
	}
	//ɾ�����ݸ���id
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ����id
		int sf_Id = Integer.parseInt(req.getParameter("sf_Id"));
		//ɾ������
		safeService.delete(sf_Id);
		//��ȡ���°�ȫ�������
		List<Safe> safes = safeService.list();
		jsonObject.put("safes", safes);
		resp.getWriter().write(jsonObject.toString());
	}
}
