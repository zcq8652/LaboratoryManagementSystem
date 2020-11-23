package com.rjxy.service;

import com.rjxy.model.Student;

public interface IStudentService {
	public Student load(String s_Id);
	public void update(Student studnet);
	public int updatePassword(Student studnet);
}
