package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IImgDao;
import com.rjxy.model.Img;
import com.rjxy.service.IImgService;

@Service
public class ImgService implements IImgService {
	private IImgDao imgDao;
	@Resource
	public void setImgDao(IImgDao imgDao) {
		this.imgDao = imgDao;
	}
	@Override
	public void add(Img img) {
		// TODO Auto-generated method stub
		imgDao.add(img);
	}
	@Override
	public List<Img> listId(int id) {
		// TODO Auto-generated method stub
		return imgDao.listId(id);
	}
	@Override
	public List<Img> list() {
		// TODO Auto-generated method stub
		return imgDao.list();
	}

}
