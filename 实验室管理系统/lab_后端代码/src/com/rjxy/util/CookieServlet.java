package com.rjxy.util;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Cookie
 * 		����˷��͵Ĳ�ͬ��������ݹ�������
 * 		ʹ�ã�
 * 			����Cookie����
 * 			����Cookie(��ѡ)
 * 			��ӦCookie��Ϣ���ͻ���
 * 		ע�⣺
 *			һ��Cookie����洢һ������
 *		�ص㣺
 *			����������ݴ洢����
 *			�洢�������ڷ�������
 *			��ʱ�洢��������رռ�ʧЧ
 *			��ʱ�洢��������Cookie����Ч�ڣ��洢��Ӳ����
 *			Ĭ��Cookie��Ϣ�洢��֮��ÿ�����󶼻ḽ��������������Ч·��
 *		��ȡ��
 *			��ȡCookie��Ϣ����
 *			���������ȡCookie��Ϣ
 * @author eryue
 *
 */
public class CookieServlet {	
	public void setCookie(HttpServletRequest req,HttpServletResponse resp,String name,String value,int time,String path) {
		//����Cookie����
		Cookie c = new Cookie(name,value);
		//����Cookie
			//������Чʱ��
			c.setMaxAge(time);
			//������Ч·��
			c.setPath(req.getContextPath());
		//��ӦCookie��Ϣ���ͻ���
		resp.addCookie(c);
	}
	public String getCookie(HttpServletRequest req) throws IOException {
		//��ȡCookil��Ϣ
		Cookie[] c = req.getCookies();
		//����Cookil��Ϣ
		String a_Id = "";
		if(c!=null) {
			//����Cookil��Ϣ
			for(Cookie ck:c) {
				if("a_Id".equals(ck.getName())) {
					a_Id=ck.getValue();
				}
			}
		}
		return a_Id;
	}	
}
