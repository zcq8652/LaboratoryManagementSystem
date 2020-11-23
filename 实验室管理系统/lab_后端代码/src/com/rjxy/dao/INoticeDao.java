package com.rjxy.dao;

import com.rjxy.model.Notice;

public interface INoticeDao extends IBaseDao<Notice> {
	public void deleteAll();
}
