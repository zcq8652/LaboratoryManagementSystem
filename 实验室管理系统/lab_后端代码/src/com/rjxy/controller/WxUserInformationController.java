package com.rjxy.controller;

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

@Controller
@RequestMapping("/WxUser")
public class WxUserInformationController {
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
	@RequestMapping(value="/Password")
	public void admin(HttpServletRequest req, HttpServletResponse resp){
		//��ȡ�޸���Ϣ
		String u_Id = req.getParameter("u_Id");
		String u_position= req.getParameter("u_position");
		String n_password = CodeUtil.getMD5Encoding(req.getParameter("n_password"));
		//�ж��û�����
		if(u_position.equals("0")){
			//�������ݷ�װ��
			Student student = new Student();
			student.setU_Id(u_Id);
			student.setU_password(n_password);
			//�޸����ݿ�����
			studentService.updatePassword(student);
		}else if(u_position.equals("1")){
			//�������ݷ�װ��
			Teacher teacher = new Teacher();
			teacher.setU_Id(u_Id);
			teacher.setU_password(n_password);
			//�޸����ݿ�����
			teacherService.updatePassword(teacher);
		}else if(u_position.equals("2")){
			//�������ݷ�װ��
			Admin admin = new Admin();
			admin.setU_Id(u_Id);
			admin.setU_password(n_password);
			//�޸����ݿ�����
			adminService.updatePassword(admin);
		}
	}

}
