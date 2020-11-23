package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.Adjust;

public interface IAdjustDao extends IBaseDao<Adjust> {
	public List<Adjust> listState(String state);
	public List<Adjust> listStateLab(Adjust adjust);
	public List<Adjust> listId1();
	public List<Adjust> listId(String state);
	public List<Adjust> listId0();
	public List<Adjust> listId30();
	public Adjust selectId(int id);
}
