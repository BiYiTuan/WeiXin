package org.outstudio.feiyang.dao;

import java.util.List;

import org.outstudio.feiyang.entity.User;


public interface UserDao {
	
	public User saveOrGetUser(User user);
	
	public void addScoreForUser(String fromOid,int type);
	
	public User getUserByOid(String openid);
	
	public List<User> getScoreSortedUsers();
	
	
}
