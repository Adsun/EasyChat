package com.adsun.chat.client.utils;

import io.netty.channel.Channel;

/**
 * @author fengxiang
 * @date 2018年5月18日
 */
public class ChannelContext {
	private String userName;
	private Channel channel;
	private String msgTo;
	private String uuid;
	private String publicKey;
	
	private static ChannelContext channelContext = null;
	
	public synchronized static ChannelContext getInstance() {
		if (channelContext == null) {
			channelContext = new ChannelContext();
		}
		return channelContext;
	}
	
	private ChannelContext() {}

	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
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
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the publicKey
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * @param publicKey the publicKey to set
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
