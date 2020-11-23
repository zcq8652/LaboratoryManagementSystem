package com.rjxy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rjxy.dao.IAdminDao;
import com.rjxy.model.Admin;
import com.rjxy.service.IAdminService;

@Service
public class AdminService implements IAdminService {
	private IAdminDao adminDao;
	@Resource
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	public Admin load(String a_Id) {
		Admin admin = adminDao.load(a_Id);
		return admin;
	}
	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}
	@Override
	public int updatePassword(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updatePassword(admin);
	}


}
