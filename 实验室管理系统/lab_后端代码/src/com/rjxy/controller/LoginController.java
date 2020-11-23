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
	//��½�ж�
	@RequestMapping(value="/toMain",produces = {"application/json;charset=UTF-8"})
	public String toMain(String a_Id,String a_password,String option,HttpSession session,Model model,HttpServletRequest req,HttpServletResponse resp) throws IOException{//		//����id��ѯ���û�
		Admin admin = adminService.load(a_Id);
		//�жϸ�id�û��ܷ����
		if(admin == null){
			//�û�Ϊ�գ����ش�����Ϣ
			model.addAttribute("message", "���˺Ų�����");
			req.setAttribute("error", "error");
			return "admin/login";
		}
		//�û���Ϊ�գ���ǰid������"�������Ƿ���ȷ
		if(admin.getU_password().equals(CodeUtil.getMD5Encoding(a_password))){
			//������ȷ���жϵ�ǰ�û��Ƿ��ѵ�½
			ServletContext context = req.getServletContext();
			if(context.getAttribute(a_Id)==null){
				//��idδ��¼�������½��Ϣ
				context.setAttribute(a_Id, 1);
				session.setAttribute("admin", admin);
				//�жϵ�ǰ�û��Ƿ�ѡ���´��Զ���½
				if(option != null){
					//����Cookie�����û���Ϣ
					CookieServlet cookie = new CookieServlet();
					cookie.setCookie(req,resp, "u_Id", a_Id, 3*24*3600,"admin/login");
				}
				//�ض�����ҳ��
				return "redirect:/Login/Main";
			}else{
				//��id�ѵ�½��������Ϣ
				model.addAttribute("message", "���û��ѵ�½�����Ǳ��˵�½����ϵ��ع���Ա");
				req.setAttribute("error", "error");
				return "admin/login";
			}
		}else{
			//������󣬷��ش�����Ϣ
			model.addAttribute("message", "�������");
			req.setAttribute("error", "error");
			return "admin/login";
		}
	}
	//������ҳ��
	@RequestMapping("/Main")
	public String toMain(Model model,HttpSession session){
		Admin admin = (Admin) session.getAttribute("admin");
		List<Adjust> adjusts = null;
		//�жϹ���Ա�����
		if(admin.getU_rank().equals("1")){
			adjusts = adjustService.listState(admin.getU_rank());
			//�жϹ��������Ƿ����5��
			if(adjusts.size()>5){
				int size = adjusts.size();
				//�Ƴ���������
				for(int i=5;i<size;i++){
					adjusts.remove(5);
				}
			}
		}else{
			
		}
		//��ȡ��������
		List<Notice> notices = noticeService.list();
		//�жϹ��������Ƿ����5��
		if(notices.size()>5){
			int size = notices.size();
			//�Ƴ���������
			for(int i=5;i<size;i++){
				notices.remove(5);
			}
		}
		List<Fault> faults = faultService.list();
		//�жϹ����걨�����Ƿ����5��
		if(faults.size()>5){
			int size = faults.size();
			//�Ƴ���������
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
