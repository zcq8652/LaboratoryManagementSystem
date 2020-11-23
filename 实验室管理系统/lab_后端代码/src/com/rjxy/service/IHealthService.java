package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Health;

public interface IHealthService {
	public List<Health> list();
	public void add(Health health);
	public void delete(int id);
	public void deleteAll();
}
