package com.rjxy.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Admin;
import com.rjxy.model.Student;
import com.rjxy.model.Teacher;
import com.rjxy.service.IAdminService;
import com.rjxy.service.IStudentService;
import com.rjxy.service.ITeacherService;
import com.rjxy.util.CodeUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxRegister")
public class WxRegisterController {
	private IStudentService studentService;
	@Resource
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	private IAdminService adminService;
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	private ITeacherService teacherService;
	@Resource
	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}
	//΢��ѧ����ע��
	@RequestMapping("/student")
	public void student(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡע����Ϣ
		String stu_id = req.getParameter("stu_id"); 
		String stu_name = req.getParameter("stu_name");
		String stu_password = req.getParameter("stu_password");
		JSONObject jsonObject = new JSONObject();
		//�жϵ�ǰ�˺��Ƿ��Ѵ���
		Student student = studentService.load(stu_id);
		if(student == null){
			jsonObject.put("message", "NO");
		}else if(student.getU_password() == null){
			Student stu = new Student(stu_id,stu_name,CodeUtil.getMD5Encoding(stu_password),"0");
			studentService.update(stu);
			jsonObject.put("message", "YES");
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
	//΢�Ž�ʦ��ע��
	@RequestMapping("/teacher")
	public void teacher(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡע����Ϣ
		String tea_id = req.getParameter("tea_id"); 
		String tea_name = req.getParameter("tea_name");
		String tea_password = req.getParameter("tea_password");
		JSONObject jsonObject = new JSONObject();
		//�жϵ�ǰ�˺��Ƿ��Ѵ���
		Teacher teacher = teacherService.load(tea_name);
		if(teacher == null){
			jsonObject.put("message", "NO");
		}else if(teacher.getU_password() == null){
			Teacher tea = new Teacher(tea_id,tea_name,CodeUtil.getMD5Encoding(tea_password),"1");
			teacherService.update(tea);
			jsonObject.put("message", "YES");
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
	//΢�Ź���Ա��ע��
	@RequestMapping("/admin")
	public void admin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡע����Ϣ
		String adm_id = req.getParameter("adm_id"); 
		String adm_name = req.getParameter("adm_name");
		String adm_password = req.getParameter("adm_password");
		JSONObject jsonObject = new JSONObject();
		//�жϵ�ǰ�˺��Ƿ��Ѵ���
		Admin admin = adminService.load(adm_id);
		if(admin == null){
			jsonObject.put("message", "NO");
		}else if(admin.getU_password() == null){
			Admin adm = new Admin(adm_id,adm_name,CodeUtil.getMD5Encoding(adm_password),"0","2");
			adminService.update(adm);
			jsonObject.put("message", "YES");
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
}
