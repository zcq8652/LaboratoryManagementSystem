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

import com.rjxy.model.Notice;
import com.rjxy.service.INoticeService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WcNotice")
public class WxNoticeController {
	private INoticeService noticeService;
	@Resource
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	//����Ա���ӹ���
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//��ȡ������Ϣ
		String adm_name = req.getParameter("adm_name");
		String n_content = req.getParameter("n_content");
		//��ȡϵͳ��ǰʱ��
		Date date = new Date();
		String n_date = new SimpleDateFormat("MM-dd").format(date);
		//��װ����
		Notice notice = new Notice();
		notice.setA_name(adm_name);
		notice.setN_content(n_content);
		notice.setN_date(n_date);
		//��������
		noticeService.add(notice);
	}
	//����Աɾ������
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ����Id
		int n_Id = Integer.parseInt(req.getParameter("n_Id"));
		//ɾ������
		noticeService.delete(n_Id);
		//��ȡɾ����Ĺ�������
		List<Notice> notices = noticeService.list();
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
	//��ҳ��ȡ����ʮ������
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ��������
		List<Notice> notices = noticeService.list();
		//�жϹ��������Ƿ����10��
		if(notices.size()>10){
			int size = notices.size();
			//�Ƴ���������
			for(int i=10;i<size;i++){
				notices.remove(10);
			}
		}
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
	//�������Ļ�ȡȫ������
	@RequestMapping("/selectList")
	public void selectList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ��������
		List<Notice> notices = noticeService.list();
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
}
