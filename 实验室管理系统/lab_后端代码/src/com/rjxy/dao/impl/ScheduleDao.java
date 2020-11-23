package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IScheduleDao;
import com.rjxy.model.Schedule;
@Repository
public class ScheduleDao extends BaseDao<Schedule> implements IScheduleDao {

	@Override
	public List<Schedule> listId(String id) {
		// TODO Auto-generated method stub
		return openSession().selectList(Schedule.class.getName() + ".listId", id);
	}

}
