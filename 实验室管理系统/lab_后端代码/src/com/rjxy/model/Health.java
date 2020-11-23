package com.rjxy.model;

import java.util.List;

public class Health {
	private int h_Id;
	private String h_u_Id;
	private String h_u_name;
	private String h_content;
	private String h_time;
	private List<String> imgsPath;
	public Health() {
		super();
	}
	public Health(int h_Id, String h_u_Id, String h_u_name, String h_content, String h_time, List<String> imgsPath) {
		super();
		this.h_Id = h_Id;
		this.h_u_Id = h_u_Id;
		this.h_u_name = h_u_name;
		this.h_content = h_content;
		this.h_time = h_time;
		this.imgsPath = imgsPath;
	}
	public int getH_Id() {
		return h_Id;
	}
	public void setH_Id(int h_Id) {
		this.h_Id = h_Id;
	}
	public String getH_u_Id() {
		return h_u_Id;
	}
	public void setH_u_Id(String h_u_Id) {
		this.h_u_Id = h_u_Id;
	}
	public String getH_u_name() {
		return h_u_name;
	}
	public void setH_u_name(String h_u_name) {
		this.h_u_name = h_u_name;
	}
	public String getH_content() {
		return h_content;
	}
	public void setH_content(String h_content) {
		this.h_content = h_content;
	}
	public String getH_time() {
		return h_time;
	}
	public void setH_time(String h_time) {
		this.h_time = h_time;
	}
	public List<String> getImgsPath() {
		return imgsPath;
	}
	public void setImgsPath(List<String> imgsPath) {
		this.imgsPath = imgsPath;
	}
	@Override
	public String toString() {
		return "Health [h_Id=" + h_Id + ", h_u_Id=" + h_u_Id + ", h_u_name=" + h_u_name + ", h_content=" + h_content
				+ ", h_time=" + h_time + ", imgsPath=" + imgsPath + "]";
	}

}
