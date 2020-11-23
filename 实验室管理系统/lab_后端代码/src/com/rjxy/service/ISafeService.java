package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Safe;

public interface ISafeService {
	public List<Safe> list();
	public void add(Safe safe);
	public void delete(int id);
	public void deleteAll();
}
