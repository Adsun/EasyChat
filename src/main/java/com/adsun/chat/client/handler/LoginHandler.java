package com.adsun.chat.client.handler;

import java.util.Scanner;

import com.adsun.chat.client.utils.ServerChannel;
import com.adsun.chat.message.Message;

/**
 * @author fengxiang
 * @date 2018年5月18日
 */
public class LoginHandler {
	public static void login() {
		while (ServerChannel.channel == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("wait for connect server...");
		}
		System.out.println("connect server successed!");
		
		System.out.print("please input your login name:");
		
			Scanner sc = new Scanner(System.in);
			try {
				String input = sc.nextLine();
				ServerChannel.channel.writeAndFlush(new Message(input.trim()));
			} finally {
				sc.close();
			}
		
	}
}
