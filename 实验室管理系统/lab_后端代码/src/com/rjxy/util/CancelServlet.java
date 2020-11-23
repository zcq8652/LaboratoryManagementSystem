package com.rjxy.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.rjxy.model.Admin;

public class CancelServlet implements HttpSessionListener {
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Admin admin = (Admin)se.getSession().getAttribute("admin");
		ServletContext servletContext = se.getSession().getServletContext();
		servletContext.removeAttribute(admin.getU_Id());
		System.out.println("œ˙ªŸ¡À");
	}

}
