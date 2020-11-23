package com.rjxy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Admin;
import com.rjxy.model.Notice;
import com.rjxy.service.INoticeService;

@Controller
@RequestMapping("/Notice")
public class NoticeController {
	private INoticeService noticeService;
	@Resource
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	//删除数据
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(){
		//删除全部数据
		noticeService.deleteAll();
		return "redirect:/Main/toNotice";
	}
	//发布公告
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(String n_content,HttpSession session){
		//获取当前用户信息
		Admin admin = (Admin) session.getAttribute("admin");
		//获取系统当前时间
		Date date = new Date();
		String n_date = new SimpleDateFormat("MM-dd").format(date);
		//封装数据
		Notice notice = new Notice();
		notice.setA_name(admin.getU_name());
		notice.setN_content(n_content);
		notice.setN_date(n_date);
		//保存数据
		noticeService.add(notice);
		return "redirect:/Main/toNotice";
	}
}
