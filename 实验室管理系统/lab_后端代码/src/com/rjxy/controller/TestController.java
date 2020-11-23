package com.rjxy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value="/test1")
	public void test(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取登陆信息
		String stu_name = req.getParameter("stu_name");
		String stu_password = req.getParameter("stu_password");
		System.out.println(stu_name+"---------------------"+stu_password);
		System.out.println("1====================");
		resp.getWriter().write("{message:'YES'}");
	}
}
