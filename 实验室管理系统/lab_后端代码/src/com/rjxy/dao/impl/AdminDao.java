package com.rjxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IAdminDao;
import com.rjxy.model.Admin;
@Repository
public class AdminDao extends BaseDao<Admin> implements IAdminDao{

	@Override
	public int updatePassword(Admin admin) {
		// TODO Auto-generated method stub
		return openSession().update(Admin.class.getName() + ".updatePassword", admin);
	}

}
