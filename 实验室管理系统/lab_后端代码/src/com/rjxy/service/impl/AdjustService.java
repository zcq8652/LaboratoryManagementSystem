package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IAdjustDao;
import com.rjxy.model.Adjust;
import com.rjxy.service.IAdjustService;
@Service
public class AdjustService implements IAdjustService {
	private IAdjustDao adjustDao;
	@Resource
	public void setAdjustDao(IAdjustDao adjustDao) {
		this.adjustDao = adjustDao;
	}
	@Override
	public List<Adjust> listState(String state) {
		// TODO Auto-generated method stub
		return adjustDao.listState(state);
	}
	@Override
	public List<Adjust> listStateLab(Adjust adjust) {
		// TODO Auto-generated method stub
		return adjustDao.listStateLab(adjust);
	}
	@Override
	public void add(Adjust adjust) {
		// TODO Auto-generated method stub
		adjustDao.add(adjust);
	}
	@Override
	public List<Adjust> list() {
		// TODO Auto-generated method stub
		return adjustDao.list();
	}
	@Override
	public List<Adjust> listId1() {
		// TODO Auto-generated method stub
		return adjustDao.listId1();
	}
	@Override
	public List<Adjust> listId0() {
		// TODO Auto-generated method stub
		return adjustDao.listId0();
	}
	@Override
	public void update(Adjust adjust) {
		// TODO Auto-generated method stub
		adjustDao.update(adjust);
	}
	@Override
	public void dalete(int id) {
		// TODO Auto-generated method stub
		adjustDao.delete(id);
	}
	@Override
	public List<Adjust> listId(String state) {
		// TODO Auto-generated method stub
		return adjustDao.listState(state);
	}
	@Override
	public List<Adjust> listId30() {
		// TODO Auto-generated method stub
		return adjustDao.listId30();
	}
	@Override
	public Adjust selectId(int id) {
		// TODO Auto-generated method stub
		return adjustDao.selectId(id);
	}

}
