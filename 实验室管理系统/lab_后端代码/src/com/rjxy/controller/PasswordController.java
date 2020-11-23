package com.rjxy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Admin;
import com.rjxy.model.Student;
import com.rjxy.model.Teacher;
import com.rjxy.service.IAdminService;
import com.rjxy.service.IStudentService;
import com.rjxy.service.ITeacherService;
import com.rjxy.util.CodeUtil;

@Controller
@RequestMapping("/Password")
public class PasswordController {
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
	//管理员重置用户密码
	public String Password(String status,String id,HttpServletRequest req){
		//标志修改是否成功
		int message = 0;
		//判断用户类型
		if(status.equals("student")){
			//判断用户是否存在
			Student student = studentService.load(id);
			if(student != null){
				student.setU_password(CodeUtil.getMD5Encoding("123456"));
				message = studentService.updatePassword(student);
			}
		}else if(status.equals("teacher")){
			Teacher teacher = teacherService.load(id);
			if(teacher != null){
				teacher.setU_password(CodeUtil.getMD5Encoding("123456"));
				message = teacherService.updatePassword(teacher);
			}
		}else if(status.equals("admin")){
			Admin admin = adminService.load(id);
			if(admin != null){
				admin.setU_password(CodeUtil.getMD5Encoding("123456"));
				message = adminService.updatePassword(admin);
			}
		}
		return "redirect:/Main/toPassword?message="+message;
	}
}
