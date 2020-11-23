package com.rjxy.service;

import java.util.List;

import com.rjxy.model.AdminAdjust;
import com.rjxy.model.TeacherAdjust;

public interface IAdminAdjustService {
	public void add(AdminAdjust adminAdjust);
	public void delete(int id);
	public List<AdminAdjust> listId(String id);
	public void update(AdminAdjust adminAdjust);
}
