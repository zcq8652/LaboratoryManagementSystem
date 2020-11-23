package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.Attendance;

public interface IAttendanceDao extends IBaseDao<Attendance> {
	public List<Attendance> listAnd(Attendance attendance);
	public List<Attendance> listOr(Attendance attendance);
	public void deleteList(Attendance attendance);
}
