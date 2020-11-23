package com.rjxy.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Adjust;
import com.rjxy.model.Admin;
import com.rjxy.model.Fault;
import com.rjxy.model.Notice;
import com.rjxy.service.IAdjustService;
import com.rjxy.service.IAdminService;
import com.rjxy.service.IFaultService;
import com.rjxy.service.INoticeService;
import com.rjxy.util.CodeUtil;
import com.rjxy.util.CookieServlet;

@Controller
@RequestMapping("/Login")
public class LoginController {
	private IAdminService adminService;
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	private IAdjustService adjustService;
	@Resource
	public void setAdjustService(IAdjustService adjustService) {
		this.adjustService = adjustService;
	}
	private IFaultService faultService;
	@Resource
	public void setFaultService(IFaultService faultService) {
		this.faultService = faultService;
	}
	private INoticeService noticeService;
	@Resource
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	//登陆判断
	@RequestMapping(value="/toMain",produces = {"application/json;charset=UTF-8"})
	public String toMain(String a_Id,String a_password,String option,HttpSession session,Model model,HttpServletRequest req,HttpServletResponse resp) throws IOException{//		//根据id查询该用户
		Admin admin = adminService.load(a_Id);
		//判断该id用户受否存在
		if(admin == null){
			//用户为空，返回错误信息
			model.addAttribute("message", "该账号不存在");
			req.setAttribute("error", "error");
			return "admin/login";
		}
		//用户不为空，当前id存在判"断密码是否正确
		if(admin.getU_password().equals(CodeUtil.getMD5Encoding(a_password))){
			//密码正确，判断当前用户是否已登陆
			ServletContext context = req.getServletContext();
			if(context.getAttribute(a_Id)==null){
				//该id未登录，保存登陆信息
				context.setAttribute(a_Id, 1);
				session.setAttribute("admin", admin);
				//判断当前用户是否选择下次自动登陆
				if(option != null){
					//创建Cookie保存用户信息
					CookieServlet cookie = new CookieServlet();
					cookie.setCookie(req,resp, "u_Id", a_Id, 3*24*3600,"admin/login");
				}
				//重定向到主页面
				return "redirect:/Login/Main";
			}else{
				//该id已登陆，返回信息
				model.addAttribute("message", "该用户已登陆，若非本人登陆请联系相关管理员");
				req.setAttribute("error", "error");
				return "admin/login";
			}
		}else{
			//密码错误，返回错误信息
			model.addAttribute("message", "密码错误");
			req.setAttribute("error", "error");
			return "admin/login";
		}
	}
	//进入主页面
	@RequestMapping("/Main")
	public String toMain(Model model,HttpSession session){
		Admin admin = (Admin) session.getAttribute("admin");
		List<Adjust> adjusts = null;
		//判断管理员的身份
		if(admin.getU_rank().equals("1")){
			adjusts = adjustService.listState(admin.getU_rank());
			//判断公告数据是否大于5条
			if(adjusts.size()>5){
				int size = adjusts.size();
				//移除多余数据
				for(int i=5;i<size;i++){
					adjusts.remove(5);
				}
			}
		}else{
			
		}
		//获取公告数据
		List<Notice> notices = noticeService.list();
		//判断公告数据是否大于5条
		if(notices.size()>5){
			int size = notices.size();
			//移除多余数据
			for(int i=5;i<size;i++){
				notices.remove(5);
			}
		}
		List<Fault> faults = faultService.list();
		//判断故障申报数据是否大于5条
		if(faults.size()>5){
			int size = faults.size();
			//移除多余数据
			for(int i=5;i<size;i++){
				faults.remove(5);
			}
		}
		model.addAttribute("notices", notices);
		model.addAttribute("faults", faults);
		model.addAttribute("adjusts", adjusts);
		model.addAttribute("path", "homePage.jsp");
		return "admin/main/main";
	}
	
}
