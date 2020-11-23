package com.rjxy.service;

import com.rjxy.model.Teacher;

public interface ITeacherService {
	public Teacher load(String s_Id);
	public void update(Teacher teacher);
	public int updatePassword(Teacher teacher);
}
