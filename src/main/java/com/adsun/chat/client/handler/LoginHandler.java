package com.adsun.chat.client.handler;

import java.util.Scanner;

import com.adsun.chat.client.utils.ServerChannel;
import com.adsun.chat.message.Message;
import com.adsun.chat.message.MessageConstant.MESSAGE_TYPE;
import com.adsun.chat.observer.MessageHandlerObserverable;
import com.adsun.chat.observer.Observer;
import com.adsun.chat.observer.Observerable;

/**
 * @author fengxiang
 * @date 2018年5月18日
 */
public class LoginHandler implements Observer{
	private Message message = null;
	public void login() {
		MessageHandlerObserverable.getInstance().registerObserver(this);
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
				while (message != null && message.getMessageType() == MESSAGE_TYPE.LOGINRESULT) {
					
				}
			} finally {
				sc.close();
			}
			
			MessageHandlerObserverable.getInstance().removeObserver(this);
	}

	public void update(Message message) {
		
	}
}
