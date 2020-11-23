package com.rjxy.dao;

import com.rjxy.model.Teacher;

public interface ITeacherDao extends IBaseDao<Teacher> {
	public int updatePassword(Teacher teacher);
}
