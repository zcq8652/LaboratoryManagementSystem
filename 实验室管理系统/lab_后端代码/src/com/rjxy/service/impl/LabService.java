package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.ILabDao;
import com.rjxy.model.Lab;
import com.rjxy.service.ILabService;
@Service
public class LabService implements ILabService {
	private ILabDao labDao;
	@Resource
	public void setLabDao(ILabDao labDao) {
		this.labDao = labDao;
	}
	@Override
	public List<Lab> list() {
		// TODO Auto-generated method stub
		return labDao.list();
	}
	@Override
	public int addLab(Lab lab) {
		// TODO Auto-generated method stub
		return labDao.addLab(lab);
	}
	@Override
	public Lab load(String id) {
		// TODO Auto-generated method stub
		return labDao.load(id);
	}
	@Override
	public int updatea_id(Lab lab) {
		// TODO Auto-generated method stub
		return labDao.updatea_id(lab);
	}

}
