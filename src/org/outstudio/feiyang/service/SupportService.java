package org.outstudio.feiyang.service;

import org.outstudio.feiyang.entity.Support;

public interface SupportService {

	/**
	 * 记录点赞用户之间的对应关系,添加用户openid的对应关系
	 * @param support
	 */
	public void addSupport(Support support);
	
	/**
	 * 判断A用户是否已经为B用户点赞
	 * @return 如果该用户已经为分享者点赞，则返回true;否则返回false
	 */
	public boolean checkSupport(Support support);
	

}
