package org.outstudio.feiyang.service;

import org.outstudio.feiyang.dao.SupportDaoImpl;
import org.outstudio.feiyang.entity.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportService {
	
	@Autowired
	SupportDaoImpl supportDao;
	
	@Override
	public boolean checkSupport(Support support) {
		return supportDao.checkSupport(support);
	}
	
	@Override
	public void addSupport(Support support) {
		supportDao.addSupport(support);
	}
}
