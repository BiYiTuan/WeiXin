package org.outstudio.feiyang.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Consts {
	public static final String APP_ID = "wx96938bdbea72e953";
	public static final String APP_SECRET = "377110ff21e4a7a40d63058d0d366b91";
	
	//为点赞加分
	public static final int SHARE_SCORE = 1;
	
	public static final String APP_HOST = "http://42.96.130.124:8080/FeiYang/";
	
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
