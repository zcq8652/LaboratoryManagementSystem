package com.rjxy.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("-----------------------------------");
		System.out.println(addr.getHostAddress());
	}

}
