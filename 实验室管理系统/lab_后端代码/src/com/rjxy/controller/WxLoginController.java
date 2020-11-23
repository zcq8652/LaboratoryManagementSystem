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
@RequestMapping("/WxLogin")
public class WxLoginController {
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
	//΢��ѧ���˵�¼����
	@RequestMapping(value="/student")
	public void student(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡ��½��Ϣ
		String stu_name = req.getParameter("stu_name");
		String stu_password = req.getParameter("stu_password");
		JSONObject jsonObject = new JSONObject();
		//У����Ϣ�Ƿ���ȷ
		Student student = studentService.load(stu_name);
		if(student == null || student.getU_password() == null){
			jsonObject.put("message", "NO");
		}else if(student.getU_password().equals(CodeUtil.getMD5Encoding(stu_password))){
			jsonObject.put("message", "YES");
			student.setU_password(stu_password);
			jsonObject.put("user", student);
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
	//΢�Ž�ʦ�˵�¼����
	@RequestMapping(value="/teacher")
	public void reacher(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡ��½��Ϣ
		String tea_name = req.getParameter("tea_name");
		String tea_password = req.getParameter("tea_password");
		JSONObject jsonObject = new JSONObject();
		//У����Ϣ�Ƿ���ȷ
		Teacher teacher = teacherService.load(tea_name);
		if(teacher == null || teacher.getU_password() == null){
			jsonObject.put("message", "NO");
		}else if(teacher.getU_password().equals(CodeUtil.getMD5Encoding(tea_password))){
			jsonObject.put("message", "YES");
			teacher.setU_password(tea_password);
			jsonObject.put("user",teacher);
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
	//΢�Ź���Ա�˵�¼����
	@RequestMapping(value="/admin")
	public void admin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡ��½��Ϣ
		String adm_name = req.getParameter("adm_name");
		String adm_password = req.getParameter("adm_password");
		JSONObject jsonObject = new JSONObject();
		//У����Ϣ�Ƿ���ȷ
		Admin admin = adminService.load(adm_name);
		if(admin == null || admin.getU_password() == null){
			jsonObject.put("message", "NO");
		}else if(admin.getU_password().equals(CodeUtil.getMD5Encoding(adm_password))){
			jsonObject.put("message", "YES");
			admin.setU_password(adm_password);
			jsonObject.put("user",admin);
		}else{
			jsonObject.put("message", "NO");
		}
		resp.getWriter().write(jsonObject.toString());
	}
}
