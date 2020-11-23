package com.rjxy.service;

import com.rjxy.model.Admin;

public interface IAdminService {
	public Admin load(String A_Id);
	public void update(Admin admin);
	public int updatePassword(Admin admin);
}
