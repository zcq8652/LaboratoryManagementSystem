package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.TeacherAdjust;

public interface ITeacherAdjustDao extends IBaseDao<TeacherAdjust> {
	public List<TeacherAdjust> listId(String id);
}
