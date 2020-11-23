package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IFaultDao;
import com.rjxy.model.Fault;
import com.rjxy.service.IFaultService;
@Service
public class FaultService implements IFaultService {
	private IFaultDao faultDao;
	@Resource
	public void setFaultDao(IFaultDao faultDao) {
		this.faultDao = faultDao;
	}
	@Override
	public List<Fault> list() {
		// TODO Auto-generated method stub
		return faultDao.list();
	}
	@Override
	public void add(Fault fault) {
		// TODO Auto-generated method stub
		faultDao.add(fault);
	}
	@Override
	public void delete(int f_Id) {
		// TODO Auto-generated method stub
		faultDao.delete(f_Id);
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		faultDao.deleteAll();
	}

}
