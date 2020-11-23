package com.rjxy.dao;

import com.rjxy.model.Health;

public interface IHealthDao extends IBaseDao<Health> {
	public void deleteAll();
}
