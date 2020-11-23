package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IStudentDao;
import com.rjxy.model.Student;
@Repository
public class StudentDao extends BaseDao<Student> implements IStudentDao {

	@Override
	public int updatePassword(Student student) {
		// TODO Auto-generated method stub
		return openSession().update(Student.class.getName() + ".updatePassword", student);
	}

}
