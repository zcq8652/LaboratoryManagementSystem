package com.rjxy.model;

public class Lab {
	private String l_Id;
	private String l_name;
	private String l_location;
	private String a_Id;
	public Lab() {
		super();
	}
	public Lab(String l_Id, String l_name, String l_location, String a_Id) {
		super();
		this.l_Id = l_Id;
		this.l_name = l_name;
		this.l_location = l_location;
		this.a_Id = a_Id;
	}
	public String getL_Id() {
		return l_Id;
	}
	public void setL_Id(String l_Id) {
		this.l_Id = l_Id;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_location() {
		return l_location;
	}
	public void setL_location(String l_location) {
		this.l_location = l_location;
	}
	public String getA_Id() {
		return a_Id;
	}
	public void setA_Id(String a_Id) {
		this.a_Id = a_Id;
	}
	@Override
	public String toString() {
		return "Lab [l_Id=" + l_Id + ", l_name=" + l_name + ", l_location=" + l_location + ", a_Id=" + a_Id + "]";
	}

	
}
