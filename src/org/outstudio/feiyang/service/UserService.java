package org.outstudio.feiyang.service;

import java.util.List;

import org.outstudio.feiyang.entity.User;

public interface UserService {
	/**
	 * ����û��ǵ�һ����Ȩ,�򱣴��û���Ϣ;���򷵻��û���Ϣ
	 * @param user
	 * @return 
	 */
	public User saveOrGetUser(User user);
	
	/**
	 * ���ݼӷ�����Ϊ�û��ӷ�
	 * @param fromOid
	 */
	public void addScoreForUser(String openid,int type);
	
	/**
	 * �����û�openid�õ��û���Ϣ
	 * @param openid
	 * @return
	 */
	public User getUserByOid(String openid);
	
	/**
	 * @return ���շ����ɸߵ����ź���������û�
	 */
	public List<User> getScoreSortedUsers();
	
	
}
