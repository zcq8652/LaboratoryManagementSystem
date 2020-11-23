package com.rjxy.model;

public class Schedule {
	private int sc_Id;
	private String l_Id;
	private String mon;
	private String tue;
	private String wed;
	private String thurs;
	private String fri;
	private String sat;
	private String sun;
	public Schedule() {
		super();
	}
	public Schedule(int sc_Id, String l_Id, String mon, String tue, String wed, String thurs, String fri, String sat,
			String sun) {
		super();
		this.sc_Id = sc_Id;
		this.l_Id = l_Id;
		this.mon = mon;
		this.tue = tue;
		this.wed = wed;
		this.thurs = thurs;
		this.fri = fri;
		this.sat = sat;
		this.sun = sun;
	}
	public int getSc_Id() {
		return sc_Id;
	}
	public void setSc_Id(int sc_Id) {
		this.sc_Id = sc_Id;
	}
	public String getL_Id() {
		return l_Id;
	}
	public void setL_Id(String l_Id) {
		this.l_Id = l_Id;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getTue() {
		return tue;
	}
	public void setTue(String tue) {
		this.tue = tue;
	}
	public String getWed() {
		return wed;
	}
	public void setWed(String wed) {
		this.wed = wed;
	}
	public String getThurs() {
		return thurs;
	}
	public void setThurs(String thurs) {
		this.thurs = thurs;
	}
	public String getFri() {
		return fri;
	}
	public void setFri(String fri) {
		this.fri = fri;
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		this.sat = sat;
	}
	public String getSun() {
		return sun;
	}
	public void setSun(String sun) {
		this.sun = sun;
	}
	@Override
	public String toString() {
		return "Schedule [sc_Id=" + sc_Id + ", l_Id=" + l_Id + ", mon=" + mon + ", tue=" + tue + ", wed=" + wed
				+ ", thurs=" + thurs + ", fri=" + fri + ", sat=" + sat + ", sun=" + sun + "]";
	}

	
}
