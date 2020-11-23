package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IHealthDao;
import com.rjxy.model.Health;

@Repository
public class HealthDao extends BaseDao<Health> implements IHealthDao {

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		openSession().delete(Health.class.getName() + ".deleteAll");
	}

}
