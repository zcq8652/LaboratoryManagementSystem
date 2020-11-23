package com.rjxy.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Admin;
import com.rjxy.service.IAdminService;
import com.rjxy.util.CookieServlet;

@Controller
@RequestMapping("/Index")
public class IndexController {
	private IAdminService adminService;
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	@RequestMapping("/toLogin")
	public String toMain(HttpServletRequest req,Model model,HttpSession session) throws IOException {
		//创建Cookies,查看Cookies是否有自动登陆信息
		CookieServlet cookieServlet = new CookieServlet();
		//获取Cookie中信息
		String u_Id = cookieServlet.getCookie(req);
		if(u_Id == null){
			//信息为空，前往登陆界面
			return "admin/login";
		}else{
			//信息不为空，查看信息是否可用
			Admin admin = adminService.load(u_Id);
			if(admin != null){
				//保存登陆信息
				ServletContext context = session.getServletContext();
				context.setAttribute(u_Id, 1);
				session.setAttribute("admin", admin);
				//重定向到主页面
				return "redirect:/Index/toMain";
			}else{
				//信息对应用户已不存在，信息不再可用，前往登陆界面
				return "admin/login";
			}
		}
	}
	@RequestMapping("toMain")
	public String toMain(){
		return "admin/main/main";
	}
}
