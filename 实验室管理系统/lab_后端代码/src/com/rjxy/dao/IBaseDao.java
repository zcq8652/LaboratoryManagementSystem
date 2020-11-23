package com.rjxy.dao;

import java.util.List;

public interface IBaseDao<T> {
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	public T load(String id);
	public List<T> list();
}
