package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Lab;

public interface ILabService {
	public List<Lab> list();
	public int addLab(Lab lab);
	public Lab load(String id);
	public int updatea_id(Lab lab);
}
