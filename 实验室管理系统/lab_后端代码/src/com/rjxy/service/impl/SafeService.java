package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.ISafeDao;
import com.rjxy.model.Safe;
import com.rjxy.service.ISafeService;
@Service
public class SafeService implements ISafeService {
	private ISafeDao safeDao;
	@Resource
	public void setSafeDao(ISafeDao safeDao) {
		this.safeDao = safeDao;
	}
	@Override
	public List<Safe> list() {
		// TODO Auto-generated method stub
		return safeDao.list();
	}
	@Override
	public void add(Safe safe) {
		// TODO Auto-generated method stub
		safeDao.add(safe);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		safeDao.delete(id);
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		safeDao.deleteAll();
	}
}
