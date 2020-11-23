package com.rjxy.model;

public class Notice {
	private int n_Id;
	private String a_name;
	private String n_content;
	private String n_date;
	public Notice() {
		super();
	}
	public Notice(int n_Id, String a_name, String n_content, String n_date) {
		super();
		this.n_Id = n_Id;
		this.a_name = a_name;
		this.n_content = n_content;
		this.n_date = n_date;
	}
	public int getN_Id() {
		return n_Id;
	}
	public void setN_Id(int n_Id) {
		this.n_Id = n_Id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	@Override
	public String toString() {
		return "Notice [n_Id=" + n_Id + ", a_name=" + a_name + ", n_content=" + n_content + ", n_date=" + n_date + "]";
	}

	
}
