package org.outstudio.feiyang.dao;

import org.outstudio.feiyang.entity.Support;

public interface SupportDao {
	public boolean checkSupport(Support support);
	
	public void addSupport(Support support);
}
