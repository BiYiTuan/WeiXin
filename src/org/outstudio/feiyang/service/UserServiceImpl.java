package org.outstudio.feiyang.service;

import java.util.List;

import org.outstudio.feiyang.dao.UserDaoImpl;
import org.outstudio.feiyang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public User saveOrGetUser(User user){
		return userDao.saveOrGetUser(user);
	}

	@Override
	public void addScoreForUser(String openid,int type) {
		userDao.addScoreForUser(openid,type);
	}

	public User getUserByOid(String openid){
		return userDao.getUserByOid(openid);
	}

	@Override
	public List<User> getScoreSortedUsers() {
		return userDao.getScoreSortedUsers();
	}

	
	
}
