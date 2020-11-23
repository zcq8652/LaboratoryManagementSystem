package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IImgDao;
import com.rjxy.model.Img;
@Repository
public class ImgDao extends BaseDao<Img> implements IImgDao {

	@Override
	public List<Img> listId(int id) {
		// TODO Auto-generated method stub
		return openSession().selectList(Img.class.getName() + ".listId", id);
	}

}
