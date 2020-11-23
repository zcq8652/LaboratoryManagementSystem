package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.Img;

public interface IImgDao extends IBaseDao<Img> {
	public List<Img> listId(int id);
}
