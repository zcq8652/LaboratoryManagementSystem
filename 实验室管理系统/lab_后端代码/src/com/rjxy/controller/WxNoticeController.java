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
	//管理员增加公告
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp){
		//获取公告信息
		String adm_name = req.getParameter("adm_name");
		String n_content = req.getParameter("n_content");
		//获取系统当前时间
		Date date = new Date();
		String n_date = new SimpleDateFormat("MM-dd").format(date);
		//封装数据
		Notice notice = new Notice();
		notice.setA_name(adm_name);
		notice.setN_content(n_content);
		notice.setN_date(n_date);
		//保存数据
		noticeService.add(notice);
	}
	//管理员删除公告
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取公告Id
		int n_Id = Integer.parseInt(req.getParameter("n_Id"));
		//删除数据
		noticeService.delete(n_Id);
		//获取删除后的公告数据
		List<Notice> notices = noticeService.list();
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
	//主页获取最新十条公告
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取公告数据
		List<Notice> notices = noticeService.list();
		//判断公告数据是否大于10条
		if(notices.size()>10){
			int size = notices.size();
			//移除多余数据
			for(int i=10;i<size;i++){
				notices.remove(10);
			}
		}
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
	//公告中心获取全部公告
	@RequestMapping("/selectList")
	public void selectList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取公告数据
		List<Notice> notices = noticeService.list();
		jsonObject.put("notices", notices);
		resp.getWriter().write(jsonObject.toString());
	}
}
