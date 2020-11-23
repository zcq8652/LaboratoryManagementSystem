package com.rjxy.service;

import java.util.List;

import com.rjxy.model.Notice;

public interface INoticeService {
	public List<Notice> list();
	public void add(Notice notice);
	public void delete(int n_Id);
	public void deleteAll();
}
