package com.adsun.chat.client;

import com.adsun.chat.client.handler.LoginHandler;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class ClientApp {
	public static void main(String[] args) {
		/**
		 * 启动连接server线程
		 */
		Thread t1 = new Thread(new ConnectServerRunnable(), "connect");
		t1.start();
		LoginHandler.login();
	}
}
