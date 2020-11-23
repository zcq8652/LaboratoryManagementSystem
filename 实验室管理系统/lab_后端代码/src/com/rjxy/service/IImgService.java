package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Img;

public interface IImgService {
	public void add(Img img);
	public List<Img> listId(int id);
	public List<Img> list();
}
