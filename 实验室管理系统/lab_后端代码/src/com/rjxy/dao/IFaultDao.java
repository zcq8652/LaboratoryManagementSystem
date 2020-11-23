package com.rjxy.dao;

import com.rjxy.model.Fault;

public interface IFaultDao extends IBaseDao<Fault> {
	public void deleteAll();
}
