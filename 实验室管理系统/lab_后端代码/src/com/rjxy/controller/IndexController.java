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
		//����Cookies,�鿴Cookies�Ƿ����Զ���½��Ϣ
		CookieServlet cookieServlet = new CookieServlet();
		//��ȡCookie����Ϣ
		String u_Id = cookieServlet.getCookie(req);
		if(u_Id == null){
			//��ϢΪ�գ�ǰ����½����
			return "admin/login";
		}else{
			//��Ϣ��Ϊ�գ��鿴��Ϣ�Ƿ����
			Admin admin = adminService.load(u_Id);
			if(admin != null){
				//�����½��Ϣ
				ServletContext context = session.getServletContext();
				context.setAttribute(u_Id, 1);
				session.setAttribute("admin", admin);
				//�ض�����ҳ��
				return "redirect:/Index/toMain";
			}else{
				//��Ϣ��Ӧ�û��Ѳ����ڣ���Ϣ���ٿ��ã�ǰ����½����
				return "admin/login";
			}
		}
	}
	@RequestMapping("toMain")
	public String toMain(){
		return "admin/main/main";
	}
}
