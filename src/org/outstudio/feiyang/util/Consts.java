package org.outstudio.feiyang.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Consts {
	public static final String APP_ID = "";
	public static final String APP_SECRET = "";
	
	//ÎªµãÔÞ¼Ó·Ö
	public static final int SHARE_SCORE = 1;
	
	public static final String APP_HOST = "";
	
	public static final String HOME_PIC_URL = APP_HOST + "pic/home.jpg";

	private static final String REDIRECT_URI = APP_HOST + "fenxiang?openid=0";
	private static String encodedRedirectUri;
	static {
		try {
			encodedRedirectUri = URLEncoder.encode(REDIRECT_URI, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public static final String AUTH_URL = "https://open.weixin.qq.com/connect/"
			+ "oauth2/authorize?appid="+APP_ID + "&redirect_uri="
			+ encodedRedirectUri
			+ "&response_type=code&scope=snsapi_userinfo#wechat_redirect";
}
