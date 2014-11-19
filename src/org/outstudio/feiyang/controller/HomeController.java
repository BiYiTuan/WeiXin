package org.outstudio.feiyang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.outstudio.feiyang.entity.Support;
import org.outstudio.feiyang.entity.User;
import org.outstudio.feiyang.service.SupportServiceImpl;
import org.outstudio.feiyang.service.UserServiceImpl;
import org.outstudio.feiyang.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final String DEFAULT_FROMOID = "0";

	@Autowired
	UserServiceImpl userService;

	@Autowired
	SupportServiceImpl supportService;

	/**
	 * @throws IOException
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpSession session)
			throws IOException {

		String fromOid = (String) session.getAttribute("fromOid");
		String openid = (String) session.getAttribute("openid");
		String access_token = (String) session.getAttribute("access_token");

		String userinfo_url = "https://api.weixin.qq.com/sns/userinfo?"
				+ "access_token=" + access_token + "&openid=" + openid
				+ "&lang=zh_CN";
		String userinfo = Jsoup.connect(userinfo_url).execute().body();

		JSONObject jsonObject = new JSONObject(userinfo);
		String nickname = jsonObject.getString("nickname");
		int sex = jsonObject.getInt("sex");
		String province = jsonObject.getString("province");
		String headImgUrl = jsonObject.getString("headimgurl");

		User user = new User();
		user.setHeadImgUrl(headImgUrl);
		user.setSex(sex);
		user.setOpenid(openid);
		user.setNickname(nickname);
		user.setProvince(province);

		User sharer = new User();
		// if ((!fromOid.equals(DEFAULT_FROMOID)) && (!fromOid.equals(openid)))
		// {
		// // 为分享者加分
		// serviceImpl.addScoreForUser(fromOid, Consts.SHARE_SCORE);
		// // 根据分享者id查询分享者信息
		// sharer = serviceImpl.getUserByOid(fromOid);
		// }
		sharer = userService.getUserByOid(fromOid);
		// 如果用户是第一次授权,则保存用户信息;否则返回用户信息
		user = userService.saveOrGetUser(user);

		List<User> rank = rank();

		session.setAttribute("sharer", sharer);
		session.setAttribute("user", user);
		session.setAttribute("rank", rank);

		return "home";
	}

	@RequestMapping(value = "/fenxiang", method = RequestMethod.GET)
	public String share(HttpServletRequest request, HttpSession session)
			throws IOException, ServletException {
		/**
		 * 通过朋友圈访问第三方网站时，会带有分享者的openid
		 */
		if (!request.getParameter("openid").equals("0")) {

			String fromOid = request.getParameter("openid");// 分享者的openid
			String redirect_uri = Consts.APP_HOST + "fenxiang?fromOid="
					+ fromOid + "&openid=0";
			String AUTH_URL = "https://open.weixin.qq.com/connect/"
					+ "oauth2/authorize?appid="
					+ Consts.APP_ID
					+ "&redirect_uri="
					+ URLEncoder.encode(redirect_uri, "utf-8")
					+ "&response_type=code&scope=snsapi_userinfo#wechat_redirect";
			// response.sendRedirect(AUTH_URL);//引导到授权页面
			return "redirect:" + AUTH_URL;
		}
		/**
		 * 引导授权页面
		 */
		else {
			String fromOid = DEFAULT_FROMOID;
			if (request.getParameter("fromOid") != null) {
				fromOid = request.getParameter("fromOid");
			}
			String code = request.getParameter("code");
			String access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
					+ "appid="
					+ Consts.APP_ID
					+ "&secret="
					+ Consts.APP_SECRET
					+ "&code=" + code + "&grant_type=authorization_code";
			String jsonData = Jsoup.connect(access_token_url).execute().body();
			JSONObject jsonObject = new JSONObject(jsonData);
			String access_token = (String) jsonObject.get("access_token");
			String openid = (String) jsonObject.get("openid");
			session.setAttribute("openid", openid);
			session.setAttribute("fromOid", fromOid);
			session.setAttribute("access_token", access_token);
			return "redirect:/home";
		}
	}

	/**
	 * 点击进入游戏按钮,为用户加分,同时进入游戏
	 */
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String game(HttpServletRequest request, HttpSession session)
			throws IOException, ServletException {
		// User user = (User) session.getAttribute("user");
		// String openid = user.getOpenid();
		// if (!openid.equals("")) {
		// serviceImpl.addScoreForUser(openid, Consts.SHARE_SCORE);
		// }
		return "game";

	}

	/**
	 * 调用排名接口
	 * 
	 * @return
	 */
	public List<User> rank() {
		return userService.getScoreSortedUsers();
	}

	/**
	 * 点赞功能
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "support", method = RequestMethod.GET)
	public void support(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter printWriter = response.getWriter();
		
		String fromOid = (String) session.getAttribute("fromOid");
		String openid = (String) session.getAttribute("openid");
		Support support = new Support();
		support.setFromOid(fromOid);
		support.setOpenid(openid);
		boolean alreadySupport = supportService.checkSupport(support);
		if (!fromOid.equals(DEFAULT_FROMOID)) {
			if (!alreadySupport) {
				supportService.addSupport(support);
				userService.addScoreForUser(fromOid, Consts.SHARE_SCORE);
				printWriter.write("点赞成功！");
			}else{
				printWriter.write("你已经为他点过赞了！");
			}
		} else {
			printWriter.write("不能为自己点赞哦！");
		}
		printWriter.flush();
		printWriter.close();
		// return "home";
	}

	/**
	 * 测试
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request) {
		// User user = new User();
		// String openid = request.getParameter("o");
		// user.setOpenid(openid);
		// serviceImpl.saveOrGetUser(user);
		// System.out.println(serviceImpl.getScoreSortedUsers());
		return "test";
	}

}
