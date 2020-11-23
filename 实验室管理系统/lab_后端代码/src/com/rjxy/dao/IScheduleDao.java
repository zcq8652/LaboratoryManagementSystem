package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.Schedule;

public interface IScheduleDao extends IBaseDao<Schedule> {
	public List<Schedule> listId(String id);
}
