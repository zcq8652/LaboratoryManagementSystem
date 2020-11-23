package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IAttendanceDao;
import com.rjxy.model.Attendance;

@Repository
public class AttendanceDao extends BaseDao<Attendance> implements IAttendanceDao {

	@Override
	public List<Attendance> listAnd(Attendance attendance) {
		// TODO Auto-generated method stub
		return openSession().selectList(Attendance.class.getName() + ".listAnd", attendance);
	}

	@Override
	public List<Attendance> listOr(Attendance attendance) {
		// TODO Auto-generated method stub
		return openSession().selectList(Attendance.class.getName() + ".listOr", attendance);
	}

	@Override
	public void deleteList(Attendance attendance) {
		// TODO Auto-generated method stub
		openSession().delete(Attendance.class.getName() + ".deleteList", attendance);
	}

}
