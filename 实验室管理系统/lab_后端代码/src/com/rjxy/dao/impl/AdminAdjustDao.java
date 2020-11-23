package com.rjxy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rjxy.dao.IAdminAdjustDao;
import com.rjxy.model.AdminAdjust;
@Repository
public class AdminAdjustDao extends BaseDao<AdminAdjust> implements IAdminAdjustDao {

	@Override
	public List<AdminAdjust> listId(String id) {
		// TODO Auto-generated method stub
		return openSession().selectList(AdminAdjust.class.getName() + ".listId", id);
	}

}
