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
	//微信学生端登录功能
	@RequestMapping(value="/student")
	public void student(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//获取登陆信息
		String stu_name = req.getParameter("stu_name");
		String stu_password = req.getParameter("stu_password");
		JSONObject jsonObject = new JSONObject();
		//校验信息是否正确
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
	//微信教师端登录功能
	@RequestMapping(value="/teacher")
	public void reacher(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//获取登陆信息
		String tea_name = req.getParameter("tea_name");
		String tea_password = req.getParameter("tea_password");
		JSONObject jsonObject = new JSONObject();
		//校验信息是否正确
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
	//微信管理员端登录功能
	@RequestMapping(value="/admin")
	public void admin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//获取登陆信息
		String adm_name = req.getParameter("adm_name");
		String adm_password = req.getParameter("adm_password");
		JSONObject jsonObject = new JSONObject();
		//校验信息是否正确
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
