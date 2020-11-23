package com.rjxy.model;

public class Fault {
	private int f_Id;
	private String f_u_Id;
	private String f_u_name;
	private String f_content;
	private String f_date;
	public Fault() {
		super();
	}
	public Fault(int f_Id, String f_u_Id, String f_u_name, String f_content, String f_date) {
		super();
		this.f_Id = f_Id;
		this.f_u_Id = f_u_Id;
		this.f_u_name = f_u_name;
		this.f_content = f_content;
		this.f_date = f_date;
	}
	public int getF_Id() {
		return f_Id;
	}
	public void setF_Id(int f_Id) {
		this.f_Id = f_Id;
	}
	public String getF_u_Id() {
		return f_u_Id;
	}
	public void setF_u_Id(String f_u_Id) {
		this.f_u_Id = f_u_Id;
	}
	public String getF_u_name() {
		return f_u_name;
	}
	public void setF_u_name(String f_u_name) {
		this.f_u_name = f_u_name;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public String getF_date() {
		return f_date;
	}
	public void setF_date(String f_date) {
		this.f_date = f_date;
	}
	@Override
	public String toString() {
		return "Fault [f_Id=" + f_Id + ", f_u_Id=" + f_u_Id + ", f_u_name=" + f_u_name + ", f_content=" + f_content
				+ ", f_date=" + f_date + "]";
	}

}
