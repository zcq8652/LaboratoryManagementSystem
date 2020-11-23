package com.rjxy.model;

public class Teacher {
	private String u_Id;
	private String u_name;
	private String u_password;
	private String u_position;
	public Teacher() {
		super();
	}
	public Teacher(String u_Id, String u_name, String u_password, String u_position) {
		super();
		this.u_Id = u_Id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_position = u_position;
	}
	public String getU_Id() {
		return u_Id;
	}
	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_position() {
		return u_position;
	}
	public void setU_position(String u_position) {
		this.u_position = u_position;
	}
	@Override
	public String toString() {
		return "Teacher [u_Id=" + u_Id + ", u_name=" + u_name + ", u_password=" + u_password + ", u_position="
				+ u_position + "]";
	}


}
