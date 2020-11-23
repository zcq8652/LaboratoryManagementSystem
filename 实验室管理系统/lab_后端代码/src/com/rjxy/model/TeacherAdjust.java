package com.rjxy.model;

public class TeacherAdjust {
	private int ta_Id;
	private String t_name;
	private String t_Id;
	private String ta_content;
	private String ta_date;
	private String ta_state;
	public TeacherAdjust() {
		super();
	}
	public TeacherAdjust(int ta_Id, String t_name, String t_Id, String ta_content, String ta_date, String ta_state) {
		super();
		this.ta_Id = ta_Id;
		this.t_name = t_name;
		this.t_Id = t_Id;
		this.ta_content = ta_content;
		this.ta_date = ta_date;
		this.ta_state = ta_state;
	}
	public int getTa_Id() {
		return ta_Id;
	}
	public void setTa_Id(int ta_Id) {
		this.ta_Id = ta_Id;
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
	public String getTa_content() {
		return ta_content;
	}
	public void setTa_content(String ta_content) {
		this.ta_content = ta_content;
	}
	public String getTa_date() {
		return ta_date;
	}
	public void setTa_date(String ta_date) {
		this.ta_date = ta_date;
	}
	public String getTa_state() {
		return ta_state;
	}
	public void setTa_state(String ta_state) {
		this.ta_state = ta_state;
	}
	@Override
	public String toString() {
		return "TeacherAdjust [ta_Id=" + ta_Id + ", t_name=" + t_name + ", t_Id=" + t_Id + ", ta_content=" + ta_content
				+ ", ta_date=" + ta_date + ", ta_state=" + ta_state + "]";
	}

	
}
