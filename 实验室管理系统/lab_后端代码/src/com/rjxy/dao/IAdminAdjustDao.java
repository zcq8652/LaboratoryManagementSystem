package com.rjxy.dao;

import java.util.List;

import com.rjxy.model.AdminAdjust;

public interface IAdminAdjustDao extends IBaseDao<AdminAdjust> {
	public List<AdminAdjust> listId(String id);
}
