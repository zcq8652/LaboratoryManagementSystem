package com.rjxy.util;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Cookie
 * 		解决了发送的不同请求的数据共享问题
 * 		使用：
 * 			创建Cookie对象
 * 			设置Cookie(可选)
 * 			响应Cookie信息给客户端
 * 		注意：
 *			一个Cookie对象存储一条数据
 *		特点：
 *			浏览器的数据存储技术
 *			存储的声明在服务器端
 *			临时存储：浏览器关闭即失效
 *			定时存储：设置了Cookie的有效期，存储在硬盘中
 *			默认Cookie信息存储好之后，每次请求都会附带，除非设置有效路径
 *		获取：
 *			获取Cookie信息数组
 *			遍历数组获取Cookie信息
 * @author eryue
 *
 */
public class CookieServlet {	
	public void setCookie(HttpServletRequest req,HttpServletResponse resp,String name,String value,int time,String path) {
		//创建Cookie对象
		Cookie c = new Cookie(name,value);
		//设置Cookie
			//设置有效时间
			c.setMaxAge(time);
			//设置有效路径
			c.setPath(req.getContextPath());
		//响应Cookie信息给客户端
		resp.addCookie(c);
	}
	public String getCookie(HttpServletRequest req) throws IOException {
		//获取Cookil信息
		Cookie[] c = req.getCookies();
		//处理Cookil信息
		String a_Id = "";
		if(c!=null) {
			//遍历Cookil信息
			for(Cookie ck:c) {
				if("a_Id".equals(ck.getName())) {
					a_Id=ck.getValue();
				}
			}
		}
		return a_Id;
	}	
}
