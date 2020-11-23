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
	//�����걨
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//��ȡ������Ϣ
		String f_u_Id = req.getParameter("f_u_Id");
		String f_u_name = req.getParameter("f_u_name");
		String f_content = req.getParameter("f_content");
		//��ȡϵͳ��ǰʱ��
		Date date = new Date();
		String f_date = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//��װ����
		Fault fault = new Fault();
		fault.setF_u_Id(f_u_Id);
		fault.setF_u_name(f_u_name);
		fault.setF_content(f_content);
		fault.setF_date(f_date);
		//��������
		faultService.add(fault);
	}
	//ɾ���걨
	@RequestMapping("delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ����Id
		int f_Id = Integer.parseInt(req.getParameter("f_Id"));
		//ɾ������
		faultService.delete(f_Id);
		//��ȡ��������
		List<Fault> faults = faultService.list();
		//����תjson
		jsonObject.put("faults", faults);
		//���ݷ���ǰ��
		resp.getWriter().write(jsonObject.toString());
	}
	//��ȡȫ�������걨
	@RequestMapping("select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ��������
		List<Fault> faults = faultService.list();
		jsonObject.put("faults", faults);
		resp.getWriter().write(jsonObject.toString());
	}
}
