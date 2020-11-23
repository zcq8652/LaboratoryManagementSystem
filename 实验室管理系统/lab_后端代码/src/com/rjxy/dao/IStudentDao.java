package com.rjxy.dao;

import com.rjxy.model.Student;

public interface IStudentDao extends IBaseDao<Student> {
	public int updatePassword(Student student);
}
