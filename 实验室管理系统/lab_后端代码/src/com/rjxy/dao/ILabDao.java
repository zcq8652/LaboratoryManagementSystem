package com.rjxy.dao;

import com.rjxy.model.Lab;

public interface ILabDao extends IBaseDao<Lab> {
	public int addLab(Lab lab);
	public int updatea_id(Lab lab);
}
