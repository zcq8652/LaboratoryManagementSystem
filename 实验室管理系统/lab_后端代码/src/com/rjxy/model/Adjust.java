package com.rjxy.model;

public class Adjust {
	private int ad_Id;
	private String t_name;
	private String t_Id;
	private String ad_content;
	private String ad_date;
	private String ad_state;
	public Adjust() {
		super();
	}
	public Adjust(int ad_Id, String t_name, String t_Id, String ad_content, String ad_date, String ad_state) {
		super();
		this.ad_Id = ad_Id;
		this.t_name = t_name;
		this.t_Id = t_Id;
		this.ad_content = ad_content;
		this.ad_date = ad_date;
		this.ad_state = ad_state;
	}
	public int getAd_Id() {
		return ad_Id;
	}
	public void setAd_Id(int ad_Id) {
		this.ad_Id = ad_Id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_Id() {
		return t_Id;
	}
	public void setT_Id(String t_Id) {
		this.t_Id = t_Id;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public String getAd_date() {
		return ad_date;
	}
	public void setAd_date(String ad_date) {
		this.ad_date = ad_date;
	}
	public String getAd_state() {
		return ad_state;
	}
	public void setAd_state(String ad_state) {
		this.ad_state = ad_state;
	}
	@Override
	public String toString() {
		return "Adjust [ad_Id=" + ad_Id + ", t_name=" + t_name + ", t_Id=" + t_Id + ", ad_content=" + ad_content
				+ ", ad_date=" + ad_date + ", ad_state=" + ad_state + "]";
	}


}
