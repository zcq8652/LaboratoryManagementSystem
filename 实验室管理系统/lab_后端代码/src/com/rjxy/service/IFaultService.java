package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Fault;

public interface IFaultService {
	public List<Fault> list();
	public void add(Fault fault);
	public void delete(int f_Id);
	public void deleteAll();
}
