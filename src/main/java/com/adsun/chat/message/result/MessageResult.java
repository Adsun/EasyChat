package com.adsun.chat.message.result;

import com.adsun.chat.client.utils.ChannelContext;

/**
 * @author fengxiang
 * @date 2018年5月21日
 */
public class MessageResult extends BasicResult{
	private String msg;
	private String msgFrom;
	private String msgTo;
	
	public MessageResult(ChannelContext context, String msg) {
		setUuid(context.getUuid());
		setMsgFrom(context.getUserName());
		setMsgTo(context.getMsgTo());
		setMsg(msg);
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the msgTo
	 */
	public String getMsgTo() {
		return msgTo;
	}
	/**
	 * @param msgTo the msgTo to set
	 */
	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}
	/**
	 * @return the msgFrom
	 */
	public String getMsgFrom() {
		return msgFrom;
	}
	/**
	 * @param msgFrom the msgFrom to set
	 */
	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}
	
}
