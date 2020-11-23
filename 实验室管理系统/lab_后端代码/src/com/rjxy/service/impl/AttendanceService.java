package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IAttendanceDao;
import com.rjxy.model.Attendance;
import com.rjxy.service.IAttendanceService;

@Service
public class AttendanceService implements IAttendanceService {
	private IAttendanceDao attendanceDao;
	@Resource
	public void setAttendanceDao(IAttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
	@Override
	public List<Attendance> list() {
		// TODO Auto-generated method stub
		return attendanceDao.list();
	}
	@Override
	public List<Attendance> listAnd(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceDao.listAnd(attendance);
	}
	@Override
	public List<Attendance> listOr(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceDao.listOr(attendance);
	}
	@Override
	public void deleteList(Attendance attendance) {
		// TODO Auto-generated method stub
		attendanceDao.deleteList(attendance);
	}
	@Override
	public void add(Attendance attendance) {
		// TODO Auto-generated method stub
		attendanceDao.add(attendance);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		attendanceDao.delete(id);
	}
}
