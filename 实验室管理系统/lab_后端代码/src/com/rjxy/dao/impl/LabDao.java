package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.ILabDao;
import com.rjxy.model.Lab;

@Repository
public class LabDao extends BaseDao<Lab> implements ILabDao {

	@Override
	public int addLab(Lab lab) {
		// TODO Auto-generated method stub
		return openSession().insert(Lab.class.getName() + ".addLab", lab);
	}

	@Override
	public int updatea_id(Lab lab) {
		// TODO Auto-generated method stub
		return  openSession().insert(Lab.class.getName() + ".updatea_id", lab);
	}

}
