package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.ITeacherAdjustDao;
import com.rjxy.model.TeacherAdjust;
import com.rjxy.service.ITeacherAdjustService;
@Service
public class TeacherAdjustService implements ITeacherAdjustService {
	private ITeacherAdjustDao theacherAdjustDao;
	@Resource
	public void setTheacherAdjustDao(ITeacherAdjustDao theacherAdjustDao) {
		this.theacherAdjustDao = theacherAdjustDao;
	}
	@Override
	public void add(TeacherAdjust teacherAdjust) {
		// TODO Auto-generated method stub
		theacherAdjustDao.add(teacherAdjust);
	}
	@Override
	public List<TeacherAdjust> listId(String id) {
		// TODO Auto-generated method stub
		return theacherAdjustDao.listId(id);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		theacherAdjustDao.delete(id);
	}
	@Override
	public void update(TeacherAdjust teacherAdjust) {
		// TODO Auto-generated method stub
		theacherAdjustDao.update(teacherAdjust);
	}

}
