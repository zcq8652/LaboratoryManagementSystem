package com.rjxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IStudentDao;
import com.rjxy.model.Student;
import com.rjxy.service.IStudentService;
@Service
public class StudentService implements IStudentService {
	private IStudentDao studentDao;
	@Resource
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}
	@Override
	public Student load(String s_Id) {
		// TODO Auto-generated method stub
		return studentDao.load(s_Id);
	}
	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}
	@Override
	public int updatePassword(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updatePassword(student);
	}
}
