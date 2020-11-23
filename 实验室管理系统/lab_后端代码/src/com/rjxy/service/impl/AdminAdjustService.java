package com.rjxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IAdminAdjustDao;
import com.rjxy.model.AdminAdjust;
import com.rjxy.service.IAdminAdjustService;
@Service
public class AdminAdjustService implements IAdminAdjustService {
	private IAdminAdjustDao adminAdjustDao;
	@Resource
	public void setAdminAdjustDao(IAdminAdjustDao adminAdjustDao) {
		this.adminAdjustDao = adminAdjustDao;
	}
	@Override
	public void add(AdminAdjust adminAdjust) {
		// TODO Auto-generated method stub
		adminAdjustDao.add(adminAdjust);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		adminAdjustDao.delete(id);
	}
	@Override
	public List<AdminAdjust> listId(String id) {
		// TODO Auto-generated method stub
		return adminAdjustDao.listId(id);
	}
	@Override
	public void update(AdminAdjust adminAdjust) {
		// TODO Auto-generated method stub
		adminAdjustDao.update(adminAdjust);
	}
}
