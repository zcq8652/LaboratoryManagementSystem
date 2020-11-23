package com.rjxy.service;

import java.util.List;

import com.rjxy.model.TeacherAdjust;

public interface ITeacherAdjustService {
	public void add(TeacherAdjust teacherAdjust);
	public void delete(int id);
	public List<TeacherAdjust> listId(String id);
	public void update(TeacherAdjust teacherAdjust);
}
