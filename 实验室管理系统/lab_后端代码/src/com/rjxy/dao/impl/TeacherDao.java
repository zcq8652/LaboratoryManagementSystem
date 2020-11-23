package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.ITeacherDao;
import com.rjxy.model.Teacher;
@Repository
public class TeacherDao extends BaseDao<Teacher> implements ITeacherDao {

	@Override
	public int updatePassword(Teacher teacher) {
		// TODO Auto-generated method stub
		return openSession().update(Teacher.class.getName() + ".updatePassword", teacher);
	}

}
