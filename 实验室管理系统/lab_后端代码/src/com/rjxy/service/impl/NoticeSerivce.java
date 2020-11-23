package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.INoticeDao;
import com.rjxy.model.Notice;
import com.rjxy.service.INoticeService;
@Service
public class NoticeSerivce implements INoticeService {
	private INoticeDao noticeDao;
	@Resource
	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	@Override
	public List<Notice> list() {
		// TODO Auto-generated method stub
		return noticeDao.list();
	}
	@Override
	public void add(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.add(notice);
	}
	@Override
	public void delete(int n_Id) {
		// TODO Auto-generated method stub
		noticeDao.delete(n_Id);
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		noticeDao.deleteAll();
	}

}
