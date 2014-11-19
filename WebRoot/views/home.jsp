<%@ page session="true" import="javax.servlet.http.*"
	import="org.outstudio.feiyang.entity.*"
	import="org.outstudio.feiyang.util.*" import="java.util.*"
	import="org.springframework.beans.factory.annotation.Autowired"
	import="org.outstudio.feiyang.service.UserServiceImpl"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>

<script>
        var imgUrl = "<%=Consts.HOME_PIC_URL%>";
        var openid = "<%=((User) session.getAttribute("user")).getOpenid()%>";
        var lineLink ="<%=Consts.APP_HOST%>"+ "fenxiang?openid="+openid;
        var descContent = "大学生的微社区";
        var shareTitle = "肥羊圈";
        var appid = "<%=Consts.APP_ID%>";
	function shareFriend() {
		WeixinJSBridge.invoke('sendAppMessage', {
			"appid" : appid,
			"img_url" : imgUrl,
			"img_width" : "200",
			"img_height" : "200",
			"link" : lineLink,
			"desc" : descContent,
			"title" : shareTitle
		}, function(res) {
			//_report('send_msg', res.err_msg);
		})
	}
	function shareTimeline() {
		WeixinJSBridge.invoke('shareTimeline', {
			"img_url" : imgUrl,
			"img_width" : "200",
			"img_height" : "200",
			"link" : lineLink,
			"desc" : descContent,
			"title" : shareTitle
		}, function(res) {
			//_report('timeline', res.err_msg);
		});
	}
	function shareWeibo() {
		WeixinJSBridge.invoke('shareWeibo', {
			"content" : descContent,
			"url" : lineLink,
		}, function(res) {
			//_report('weibo', res.err_msg);
		});
	}
	// 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		// 发送给好友
		WeixinJSBridge.on('menu:share:appmessage', function(argv) {
			shareFriend();
		});
		// 分享到朋友圈
		WeixinJSBridge.on('menu:share:timeline', function(argv) {
			shareTimeline();
		});
		// 分享到微博
		WeixinJSBridge.on('menu:share:weibo', function(argv) {
			shareWeibo();
		});
	}, false);
</script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			show : {
				effect : "blind",
				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 1000
			}
		});
		$("#rank").click(function() {
			$("#dialog").dialog("open");
		});
	});
</script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#support").click(function() {
			$.ajax({
				type : "GET",
				url : "support",
				data : "",
				dataType : "text",
				success : function(msg) {
					alert(msg);
				}
			});
		});
	});
</script>

</head>
<body>
	<h1>Hello world!</h1>
	<%!@Autowired
	UserServiceImpl serviceImpl;%>
	<%
		User user = (User) session.getAttribute("user");
		User sharer = new User();
		sharer.setNickname("");
		sharer.setHeadImgUrl("");
		sharer.setScore(0);
		String fromOid;
		int score;
		if (session.getAttribute("sharer") != null) {
			sharer = (User) session.getAttribute("sharer");
			fromOid = sharer.getOpenid();
			score = sharer.getScore();
		}
	%>

	<P>
		openid is
		<%=user.getOpenid()%>. nickname is
		<%=user.getNickname()%>. sex is
		<%=user.getSex()%>. province is
		<%=user.getProvince()%>. headimgurl is
		<%=user.getHeadImgUrl()%>. score is
		<%=user.getScore()%>.
	</P>

	<a href="game">进入游戏</a>
	<div id="dialog" title="Basic dialog">
		<table>
			<tbody>
				<tr width="10%">
					<td>昵称</td>
					<td>积分</td>
				</tr>
				<%
					List<User> list = (List<User>) session.getAttribute("rank");
					Iterator iter = list.iterator();
					while (iter.hasNext()) {
						User ob = (User) iter.next();
						// 进行循环打印，打印出所有的内容，以表格形式
						String nickname = ob.getNickname();
						int totalScore = ob.getScore();
				%><tr>

					<td><%=nickname%></td>
					<td><%=totalScore%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

	<button id="rank">积分榜</button>
	
	<img alt="" src="<%=sharer.getHeadImgUrl()%>">
	<%=sharer.getNickname()%><input id="support" type="button" value="点赞" />
	
</body>
</html>
