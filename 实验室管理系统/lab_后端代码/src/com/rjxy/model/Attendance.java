package com.rjxy.model;

import java.sql.Timestamp;

public class Attendance {
	private int at_Id;
	private String t_name;	   
	private String t_Id;
	private String at_at;
	private Timestamp at_time;
	private String sat_time;
	private Timestamp start_time;
	private Timestamp end_time;
	public Attendance() {
		super();
	}
	public Attendance(int at_Id, String t_name, String t_Id, String at_at, Timestamp at_time, String sat_time,
			Timestamp start_time, Timestamp end_time) {
		super();
		this.at_Id = at_Id;
		this.t_name = t_name;
		this.t_Id = t_Id;
		this.at_at = at_at;
		this.at_time = at_time;
		this.sat_time = sat_time;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public int getAt_Id() {
		return at_Id;
	}
	public void setAt_Id(int at_Id) {
		this.at_Id = at_Id;
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
	public String getAt_at() {
		return at_at;
	}
	public void setAt_at(String at_at) {
		this.at_at = at_at;
	}
	public Timestamp getAt_time() {
		return at_time;
	}
	public void setAt_time(Timestamp at_time) {
		this.at_time = at_time;
	}
	public String getSat_time() {
		return sat_time;
	}
	public void setSat_time(String sat_time) {
		this.sat_time = sat_time;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	@Override
	public String toString() {
		return "Attendance [at_Id=" + at_Id + ", t_name=" + t_name + ", t_Id=" + t_Id + ", at_at=" + at_at
				+ ", at_time=" + at_time + ", sat_time=" + sat_time + ", start_time=" + start_time + ", end_time="
				+ end_time + "]";
	}

}
