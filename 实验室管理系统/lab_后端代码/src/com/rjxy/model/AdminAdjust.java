package com.rjxy.model;

public class AdminAdjust {
	private int aa_Id;
	private String t_name;
	private String aa_content;
	private String aa_date;
	private String aa_state;
	private String u_Id;
	private String ad_state;
	public AdminAdjust() {
		super();
	}
	public AdminAdjust(int aa_Id, String t_name, String aa_content, String aa_date, String aa_state, String u_Id,
			String ad_state) {
		super();
		this.aa_Id = aa_Id;
		this.t_name = t_name;
		this.aa_content = aa_content;
		this.aa_date = aa_date;
		this.aa_state = aa_state;
		this.u_Id = u_Id;
		this.ad_state = ad_state;
	}
	public int getAa_Id() {
		return aa_Id;
	}
	public void setAa_Id(int aa_Id) {
		this.aa_Id = aa_Id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getAa_content() {
		return aa_content;
	}
	public void setAa_content(String aa_content) {
		this.aa_content = aa_content;
	}
	public String getAa_date() {
		return aa_date;
	}
	public void setAa_date(String aa_date) {
		this.aa_date = aa_date;
	}
	public String getAa_state() {
		return aa_state;
	}
	public void setAa_state(String aa_state) {
		this.aa_state = aa_state;
	}
	public String getU_Id() {
		return u_Id;
	}
	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}
	public String getAd_state() {
		return ad_state;
	}
	public void setAd_state(String ad_state) {
		this.ad_state = ad_state;
	}
	@Override
	public String toString() {
		return "AdminAdjust [aa_Id=" + aa_Id + ", t_name=" + t_name + ", aa_content=" + aa_content + ", aa_date="
				+ aa_date + ", aa_state=" + aa_state + ", u_Id=" + u_Id + "]";
	}

	
}
