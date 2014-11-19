package org.outstudio.feiyang.entity;

public class Support {
	
	private String openid;
	private String fromOid;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getFromOid() {
		return fromOid;
	}
	public void setFromOid(String fromOid) {
		this.fromOid = fromOid;
	}
	@Override
	public String toString() {
		return "Support [openid=" + openid + ", fromOid=" + fromOid + "]";
	}
	
	
}
