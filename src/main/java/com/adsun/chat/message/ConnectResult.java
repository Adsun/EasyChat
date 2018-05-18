package com.adsun.chat.message;

import java.util.Date;

import com.adsun.chat.server.utils.UUIDutils;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class ConnectResult extends BasicResult{
	private String uuid;
	private String publicKey;
	private Date serverTime;
	
	public ConnectResult() {
		this.uuid = UUIDutils.getUUID();
		this.publicKey = "";
		this.serverTime = new Date();
		setResultCode("200");
		setResultStr("连接成功！");
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public Date getServerTime() {
		return serverTime;
	}
	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}
	
	
}
