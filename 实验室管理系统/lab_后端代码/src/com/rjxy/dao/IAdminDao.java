package com.rjxy.dao;

import com.rjxy.model.Admin;

public interface IAdminDao extends IBaseDao<Admin> {
	public int updatePassword(Admin admin);
}
