package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IHealthDao;
import com.rjxy.model.Health;
import com.rjxy.service.IHealthService;
@Service
public class HealthService implements IHealthService {
	private IHealthDao healthDao;
	@Resource
	public void setHealthDao(IHealthDao healthDao) {
		this.healthDao = healthDao;
	}
	@Override
	public List<Health> list() {
		// TODO Auto-generated method stub
		return healthDao.list();
	}
	@Override
	public void add(Health health) {
		// TODO Auto-generated method stub
		healthDao.add(health);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		healthDao.delete(id);
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		healthDao.deleteAll();
	}

}
