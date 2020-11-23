package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.ISafeDao;
import com.rjxy.model.Safe;
@Repository
public class SafeDao extends BaseDao<Safe> implements ISafeDao {

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		openSession().delete(Safe.class.getName() + ".deleteAll");
	}

}
