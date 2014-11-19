package org.outstudio.feiyang.wechat;

import static org.easywechat.util.MessageFactory.createNewsMsg;
import static org.easywechat.util.MessageFactory.createTextMsg;

import javax.servlet.annotation.WebServlet;

import org.easywechat.msg.BaseMsg;
import org.easywechat.msg.req.BaseEvent;
import org.easywechat.msg.req.BaseReqMsg;
import org.easywechat.msg.req.LocationEvent;
import org.easywechat.msg.req.MenuEvent;
import org.easywechat.msg.req.TextReqMsg;
import org.easywechat.servlet.WeixinServletSupport;
import org.outstudio.feiyang.util.Consts;

@WebServlet("/coreServlet")
public class CoreServlet extends WeixinServletSupport {

	private static final long serialVersionUID = 220064237770624544L;

	@Override
	protected String getToken() {
		return "out";
	}

	@Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
		return createTextMsg("¸ÐÐ»ÄúµÄ¹Ø×¢£¡");
	}

	@Override
	protected BaseMsg handleMenuClickEvent(MenuEvent event) {
		String eventKey = event.getEventKey();
		// TODO Auto-generated method stub
		return super.handleMenuClickEvent(event);
	}

	
	
	@Override
	protected BaseMsg handleLocationEvent(LocationEvent event) {
		double x = event.getLatitude();
		double y = event.getLongitude();
		return null;
	}

	@Override
	protected BaseMsg handleTextMsg(TextReqMsg msg) {
		String content = msg.getContent();
		if (content.equalsIgnoreCase("help")) {
			return createTextMsg("help msg");
		} else if (content.equalsIgnoreCase("sq")) {
			return createNewsMsg("", null, Consts.HOME_PIC_URL,
					Consts.AUTH_URL);
		}
		return null;
	}

}
