package com.adsun.chat.client.handler;

import java.util.Scanner;

import com.adsun.chat.client.utils.ChannelContext;
import com.adsun.chat.message.Message;
import com.adsun.chat.message.MessageConstant.MESSAGE_TYPE;
import com.adsun.chat.message.result.LoginResult;
import com.adsun.chat.observer.MessageHandlerObserverable;
import com.adsun.chat.observer.Observer;

/**
 * 对用户登录进行处理
 * @author fengxiang
 * @date 2018年5月18日
 */
public class LoginHandler implements Observer{
	private Message message = null;
	public void login() {
		MessageHandlerObserverable.getInstance().registerObserver(this);
		while (ChannelContext.getInstance().getChannel() == null) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("wait for connect server...");
		}
		
		System.out.println("connect server successed!");
		this.inputUserName();
		while (true) {
			if (message != null && message.getMessageType() == MESSAGE_TYPE.LOGINRESULT) {
				LoginResult lr = (LoginResult) message.getContext();
				if (0 == lr.getResultCode()) {
					ChannelContext.getInstance().setPublicKey(lr.getPublicKey());
					ChannelContext.getInstance().setUserName(lr.getUserName());
					ChannelContext.getInstance().setUuid(lr.getUuid());
					System.out.println("login successed!");
					break;
				} else if (-1 == lr.getResultCode()) {
					System.out.println("login failed:" + lr.getErrorMsg());
					this.inputUserName();
				}
			}
		}
		MessageHandlerObserverable.getInstance().removeObserver(this);
	}
	
	private void inputUserName() {
		System.out.print("please input your login name:");
		
		Scanner sc = new Scanner(System.in);
		try {
			String input = sc.nextLine();
			ChannelContext.getInstance().getChannel().writeAndFlush(new Message(input.trim()));
		} finally {
			sc.close();
		}
	}

	public void update(Message message) {
		this.message = message;
	}
}
