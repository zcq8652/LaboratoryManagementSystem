package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.ITeacherAdjustDao;
import com.rjxy.model.TeacherAdjust;
@Repository
public class TeacherAdjustDao extends BaseDao<TeacherAdjust> implements ITeacherAdjustDao {

	@Override
	public List<TeacherAdjust> listId(String id) {
		// TODO Auto-generated method stub
		return openSession().selectList(TeacherAdjust.class.getName() + ".listId", id);
	}

}
