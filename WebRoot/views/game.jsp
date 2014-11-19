<%@ page language="java" session="true"
import="java.util.*" import="org.outstudio.feiyang.util.*"
import="org.outstudio.feiyang.entity.*"
 pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>copy_Happy万圣节!</title>
<meta name="description" content="" />
<meta name="author" content="21epub" />
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />
<link rel="shortcut icon" href="./staticfs/diazo/favicon.ico" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />


<script type="text/javascript">
	if (navigator.userAgent.indexOf("MSIE 8.0") >= 0) {
		Array.prototype.indexOf = function(Object) {
			for ( var i = 0; i < this.length; i++)
				if (this[i] == Object)
					return i;
			return -1;
		}
	}
</script>


<script type="text/javascript">
	var isMobilePlayer = 0;

	// 判断是否为移动端运行环境
	if (/AppleWebKit.*Mobile/i.test(navigator.userAgent)
			|| (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/
					.test(navigator.userAgent))) {
		if (window.location.href.indexOf("?mobile") < 0) {
			try {
				if (/Android|webOS|iPhone|iPod|iPad|BlackBerry/i
						.test(navigator.userAgent)) {
					// 判断访问环境是 Android|webOS|iPhone|iPod|BlackBerry 则加载以下样式
					isMobilePlayer = 1;
				} else {
					// 判断访问环境是 其他移动设备 则加载以下样式
				}
			} catch (e) {
			}
		}
	} else {
		// 如果以上都不是，则加载以下样式
	}
</script>





<script type="text/javascript">
	(function() {
		if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) {
			var ieversion = new Number(RegExp.$1);
			if (ieversion <= 8) {
				if (typeof cbt_data != "undefined") {
					try {
						var slave_url = String(cbt_data.data.slave_url);
						if (slave_url && slave_url.length) {
							window.location.href = slave_url;
						} else
							window.location.href = './staticfs/admin-epub360/browser-old.html';

					} catch (e) {
						window.location.href = './staticfs/admin-epub360/browser-old.html';
					}
				}
			}
		}
	})();
</script>

</head>
<body
	class="template-player portaltype-interaction-photogallery site-demo section-pic build">

	<div class="reveal">
		<div class="slides"></div>
	</div>





	<div id="jswait-loading" class="prejsloading"
		style="position:absolute;z-index:999999;background-color: #000; background-repeat:no-repeat; background-position:50% 50%; left:0;top:0;width:100%;height:100%;margin:0;padding:0;text-align: center; display: block;">
		<div
			style="position:absolute;left:50%;top:50%;width:180px; height:4px; margin-left:-90px; margin-top:-2px;background-image:none;background-color:#c9c9c9;"
			class="progress active">
			<div id="loading-progress" class="bar"
				style="width: 0%; height:100%; background-image:none;background: #f80 !important;box-shadow: none;filter: none;"></div>
		</div>
	</div>

	<script type="text/javascript">
		var loading_progress_percent = 15;
		var loading_progress_timer = setInterval(function() {
			compute_loadding_progress();
			set_loading_progress();
		}, 200);
		function compute_loadding_progress() {

			if (loading_progress_percent < 70)
				loading_progress_percent = loading_progress_percent + 5;
			else if (loading_progress_percent > 70
					&& loading_progress_percent < 100)
				loading_progress_percent = loading_progress_percent + 10;
			else {
				clear_loading_progress();
			}

		}
		function set_loading_progress(i) {
			if (document.getElementById('loading-progress') != null) {
				document.getElementById('loading-progress').style.width = loading_progress_percent
						+ '%';
			}
		}
		function clear_loading_progress() {
			clearInterval(loading_progress_timer);
			if (typeof loading_progress_timer1 != 'undefined') {
				clearInterval(loading_progress_timer1);

				interaction_view.containment
						.children('.prejsloading')
						.fadeOut(
								1500,
								function() {
									interaction_view.containment.children(
											'.prejsloading').remove();
									interaction_view
											.play(interaction_view.currentPage);
									if (window.loadAnalytics)
										loadAnalytics();
								})
			}
		}
	</script>




	<script type="text/javascript">
		var player_head = document.getElementsByTagName('head').item(0);
		var player_style = document.createElement('link');
		var desktop_style = './staticfs/diazo/player-built/touchview.built.7c9f96f2.cache.css';
		var mobile_style = './staticfs/diazo/player-built/mobileview.built.072f0394.cache.css';

		if (isMobilePlayer) {
			player_style.setAttribute('rel', 'stylesheet');
			player_style.setAttribute('href', mobile_style);
			player_head.appendChild(player_style);
		} else {
			player_style.setAttribute('rel', 'stylesheet');
			player_style.setAttribute('href', desktop_style);
			player_head.appendChild(player_style);
		}
	</script>
	<style type="text/style">
    body { overflow-x: hidden; }
    .reveal .progress { display:none !important; }
</style>




	<script type="text/javascript">
		var portal_url = './';
		var context_url = './';
		var context_type = 'PhotoGallery';
		var web_url = './staticfs/';
		var dict = {
			"msg" : "success",
			"code" : 200,
			"data" : {}
		};

		var epub360 = epub360 || {};
		epub360.settings = epub360.settings || {};

		epub360.settings.pems = {
			'has_analytics_src' : false
		};
	</script>



	<script type="text/javascript">
		var epub360_book_type = 0; // HTML PACKAGE
	</script>

	<script type="text/javascript" src="./staticfs/index.js"></script>



	<script type="text/javascript"
		src="./staticfs/common/js/requireJS/require.js"></script>
	<script type="text/javascript"
		src="./staticfs/diazo/js/app/settings/requirejs_config.js"></script>
	<script type="text/javascript">
		var epub360_player = '';
		var js_built = 1;
		if (isMobilePlayer) {
			epub360_player = './staticfs/diazo/player-built/mobileview.built.29a4f78a.cache.js';
		} else {
			epub360_player = './staticfs/diazo/player-built/touchview.built.636acbd7.cache.js';
		}

		var ejs = document.createElement('script');
		ejs.type = 'text/javascript';
		ejs.src = epub360_player;
		var script_objs = document.getElementsByTagName('script');
		var s = script_objs[script_objs.length - 1];
		s.parentNode.insertBefore(ejs, s);
	</script>



	<script type="text/javascript">
		var imgUrl = './staticfs/admin-epub360/img/thumb.png';
		var localUrl = window.location.hash == "" ? window.location.href
				: window.location.href.replace(window.location.hash, '');
		var openid = "<%=((User)session.getAttribute("user")).getOpenid()%>";
		var lineLink ="<%=Consts.APP_HOST%>"+ "fenxiang?openid="+openid;
		var descContent = "";
		var shareTitle = 'copy_Happy万圣节!';
		var appid = '';

		if (imgUrl.indexOf(window.location.protocol) < 0) {
			if (imgUrl[0] == '.') {
				imgUrl = '/' + imgUrl;
			}
			imgUrl = window.location.protocol + '//' + window.location.host
					+ imgUrl;
		}

		var message_link = lineLink;

		// 说明：微信事件均放在了interaction_edit/ui/event中
		function shareFriend() {
            WeixinJSBridge.invoke('sendAppMessage',{
                "appid": appid,
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                //_report('send_msg', res.err_msg);
            })
        }
        function shareTimeline() {
            WeixinJSBridge.invoke('shareTimeline',{
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                   //_report('timeline', res.err_msg);
            });
        }
        function shareWeibo() {
            WeixinJSBridge.invoke('shareWeibo',{
                "content": descContent,
                "url": lineLink,
            }, function(res) {
                //_report('weibo', res.err_msg);
            });
        }
        // 当微信内置浏览器完成内部初始化后会触发WeixinJSBridgeReady事件。
        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            // 发送给好友
            WeixinJSBridge.on('menu:share:appmessage', function(argv){
                shareFriend();
            });
            // 分享到朋友圈
            WeixinJSBridge.on('menu:share:timeline', function(argv){
                shareTimeline();
            });
            // 分享到微博
            WeixinJSBridge.on('menu:share:weibo', function(argv){
                shareWeibo();
            });
        }, false);
	</script>


</body>
</html>
