package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IAdjustDao;
import com.rjxy.model.Adjust;

@Repository
public class AdjustDao extends BaseDao<Adjust> implements IAdjustDao {

	@Override
	public List<Adjust> listState(String state) {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listState",state);
	}

	@Override
	public List<Adjust> listStateLab(Adjust adjust) {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listStateLab",adjust);
	}

	@Override
	public List<Adjust> listId1() {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listId1");
	}

	@Override
	public List<Adjust> listId0() {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listId0");
	}

	@Override
	public List<Adjust> listId(String state) {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listId", state);
	}

	@Override
	public List<Adjust> listId30() {
		// TODO Auto-generated method stub
		return openSession().selectList(Adjust.class.getName() + ".listId30");
	}

	@Override
	public Adjust selectId(int id) {
		// TODO Auto-generated method stub
		return openSession().selectOne(Adjust.class.getName() + ".selectId", id);
	}
	
}
