package com.adsun.chat.message;

import java.io.UnsupportedEncodingException;

import com.adsun.chat.message.MessageConstant.MESSAGE_TYPE;
import com.alibaba.fastjson.JSON;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class Message {
	
	private static String defaultCharset = "utf-8";
	private MESSAGE_TYPE messageType;
	private Object context;

	public Object getContext() {
		return context;
	}

	public void setContext(Object context) {
		this.context = context;
	}

	public Message(Object context, MESSAGE_TYPE messageType) {
		this.setContext(context);
		this.setMessageType(messageType);
	}
	
	public Message(String context) {
		this.setContext(context);
		this.setMessageType(MESSAGE_TYPE.STRING);
	}
	
	public String getDefaultCharset() {
		return defaultCharset;
	}
	public Message(byte[] data, MESSAGE_TYPE messageType) {
		this.setMessageType(messageType);
		try {
			if (messageType.getType() >= 10) {
				String text = new String(data, defaultCharset);
				this.setContext(JSON.parseObject(text, messageType.getClazz()));
			} else if (messageType.getType() == 0) {
				this.setContext(data);
			} else if (messageType.getType() == 1) {
				String text = new String(data, defaultCharset);
				this.setContext(text);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String toString() {
		if (messageType.getType() >= 10) {
			return JSON.toJSONString(context);
		} else if (messageType.getType() == 0) {
			String text = "";
			try {
				text = new String((byte[]) context, defaultCharset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return text;
		}
		return context.toString();
	}

	public MESSAGE_TYPE getMessageType() {
		return messageType;
	}

	public void setMessageType(MESSAGE_TYPE messageType) {
		this.messageType = messageType;
	}
}
