package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Adjust;

public interface IAdjustService {
	public List<Adjust> list();
	public List<Adjust> listId1();
	public List<Adjust> listId(String state);
	public List<Adjust> listId0();
	public List<Adjust> listId30();
	public List<Adjust> listState(String state);
	public List<Adjust> listStateLab(Adjust adjust);
	public void add(Adjust adjust);
	public void update(Adjust adjust);
	public void dalete(int id);
	public Adjust selectId(int id);
}
