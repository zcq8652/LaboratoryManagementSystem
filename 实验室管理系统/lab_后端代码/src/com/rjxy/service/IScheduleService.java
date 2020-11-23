package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Schedule;

public interface IScheduleService {
	public void add(Schedule schedule);
	public List<Schedule> listId(String id);
}
