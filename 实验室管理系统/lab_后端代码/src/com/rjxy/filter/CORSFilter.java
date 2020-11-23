package com.rjxy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        //*表示允许所有域名跨域
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        //允许跨域的Http方法
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
        filterChain.doFilter(servletRequest, servletResponse);
	}

}
