package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IScheduleDao;
import com.rjxy.model.Schedule;
import com.rjxy.service.IScheduleService;
@Service
public class ScheduleService implements IScheduleService {
	private IScheduleDao scheduleDao;
	@Resource
	public void setScheduleDao(IScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	@Override
	public void add(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleDao.add(schedule);
	}
	@Override
	public List<Schedule> listId(String id) {
		// TODO Auto-generated method stub
		return scheduleDao.listId(id);
	}
}
