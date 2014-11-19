package org.outstudio.feiyang.entity;

public class User {
	
	private String openid;
	private String nickname;
	private int sex;
	private String province;
	private String headImgUrl;
	
	private int score;
	private String dept;
	private double lastLocationX;
	private double lastLocationY;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getLastLocationX() {
		return lastLocationX;
	}
	public void setLastLocationX(double lastLocationX) {
		this.lastLocationX = lastLocationX;
	}
	public double getLastLocationY() {
		return lastLocationY;
	}
	public void setLastLocationY(double lastLocationY) {
		this.lastLocationY = lastLocationY;
	}
	@Override
	public String toString() {
		return "User [openid=" + openid + ", nickname=" + nickname + ", sex="
				+ sex + ", province=" + province + ", headImgUrl=" + headImgUrl
				+ ", score=" + score + ", dept=" + dept + ", lastLocationX="
				+ lastLocationX + ", lastLocationY=" + lastLocationY + "]";
	}
	
}
