package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Attendance;

public interface IAttendanceService {
	public List<Attendance> list();
	public List<Attendance> listAnd(Attendance attendance);
	public List<Attendance> listOr(Attendance attendance);
	public void deleteList(Attendance attendance);
	public void delete(int id);
	public void add(Attendance attendance);
}
