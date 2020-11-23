package com.rjxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.ITeacherDao;
import com.rjxy.model.Teacher;
import com.rjxy.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService {
	private ITeacherDao teacherDao;
	@Resource
	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	@Override
	public Teacher load(String t_Id) {
		// TODO Auto-generated method stub
		return teacherDao.load(t_Id);
	}
	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherDao.update(teacher);
	}
	@Override
	public int updatePassword(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.updatePassword(teacher);
	}
}
