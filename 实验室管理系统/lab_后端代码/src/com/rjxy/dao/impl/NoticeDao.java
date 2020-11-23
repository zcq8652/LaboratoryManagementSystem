package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.INoticeDao;
import com.rjxy.model.Notice;
@Repository
public class NoticeDao extends BaseDao<Notice> implements INoticeDao {

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		openSession().delete(Notice.class.getName() + ".deleteAll");
	}

}
