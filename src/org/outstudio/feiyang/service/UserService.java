package org.outstudio.feiyang.service;

import java.util.List;

import org.outstudio.feiyang.entity.User;

public interface UserService {
	/**
	 * 如果用户是第一次授权,则保存用户信息;否则返回用户信息
	 * @param user
	 * @return 
	 */
	public User saveOrGetUser(User user);
	
	/**
	 * 根据加分类型为用户加分
	 * @param fromOid
	 */
	public void addScoreForUser(String openid,int type);
	
	/**
	 * 根据用户openid得到用户信息
	 * @param openid
	 * @return
	 */
	public User getUserByOid(String openid);
	
	/**
	 * @return 按照分数由高到低排好序的所有用户
	 */
	public List<User> getScoreSortedUsers();
	
	
}
