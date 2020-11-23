package com.rjxy.model;

public class Img {
	private int i_Id;
	private String i_name;
	private int h_Id;
	public Img() {
		super();
	}
	public Img(int i_Id, String i_name, int h_Id) {
		super();
		this.i_Id = i_Id;
		this.i_name = i_name;
		this.h_Id = h_Id;
	}
	public int getI_Id() {
		return i_Id;
	}
	public void setI_Id(int i_Id) {
		this.i_Id = i_Id;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public int getH_Id() {
		return h_Id;
	}
	public void setH_Id(int h_Id) {
		this.h_Id = h_Id;
	}
	@Override
	public String toString() {
		return "Img [i_Id=" + i_Id + ", i_name=" + i_name + ", h_Id=" + h_Id + "]";
	}
	
}
