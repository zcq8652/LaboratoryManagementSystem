package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IFaultDao;
import com.rjxy.model.Fault;

@Repository
public class FaultDao extends BaseDao<Fault> implements IFaultDao {

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		openSession().delete(Fault.class.getName() + ".deleteAll");
	}

}
