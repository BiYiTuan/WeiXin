package org.outstudio.feiyang.service;

import org.outstudio.feiyang.entity.Support;

public interface SupportService {

	/**
	 * ��¼�����û�֮��Ķ�Ӧ��ϵ,����û�openid�Ķ�Ӧ��ϵ
	 * @param support
	 */
	public void addSupport(Support support);
	
	/**
	 * �ж�A�û��Ƿ��Ѿ�ΪB�û�����
	 * @return ������û��Ѿ�Ϊ�����ߵ��ޣ��򷵻�true;���򷵻�false
	 */
	public boolean checkSupport(Support support);
	

}
