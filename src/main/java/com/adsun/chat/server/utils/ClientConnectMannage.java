package com.adsun.chat.server.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */

public class ClientConnectMannage {
	private final static Map<String, Channel> map = new ConcurrentHashMap<String, Channel>();
	
	public static void addChannel(String id, Channel channel) {
		map.put(id, channel);
	}
	
	public static Channel getChannel(String id) {
		return map.get(id);
	}
	
}
