package com.rjxy.model;

public class Safe {
	private int sf_Id;
	private String sf_u_Id;
	private String sf_u_name;
	private String sf_time;
	private String sf_result;
	public Safe() {
		super();
	}
	public Safe(int sf_Id, String sf_u_Id, String sf_u_name, String sf_time, String sf_result) {
		super();
		this.sf_Id = sf_Id;
		this.sf_u_Id = sf_u_Id;
		this.sf_u_name = sf_u_name;
		this.sf_time = sf_time;
		this.sf_result = sf_result;
	}
	public int getSf_Id() {
		return sf_Id;
	}
	public void setSf_Id(int sf_Id) {
		this.sf_Id = sf_Id;
	}
	public String getSf_u_Id() {
		return sf_u_Id;
	}
	public void setSf_u_Id(String sf_u_Id) {
		this.sf_u_Id = sf_u_Id;
	}
	public String getSf_u_name() {
		return sf_u_name;
	}
	public void setSf_u_name(String sf_u_name) {
		this.sf_u_name = sf_u_name;
	}
	public String getSf_time() {
		return sf_time;
	}
	public void setSf_time(String sf_time) {
		this.sf_time = sf_time;
	}
	public String getSf_result() {
		return sf_result;
	}
	public void setSf_result(String sf_result) {
		this.sf_result = sf_result;
	}
	@Override
	public String toString() {
		return "Safe [sf_Id=" + sf_Id + ", sf_u_Id=" + sf_u_Id + ", sf_u_name=" + sf_u_name + ", sf_time=" + sf_time
				+ ", sf_result=" + sf_result + "]";
	}

}
