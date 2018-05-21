package com.adsun.chat.client.handler;

import java.util.Scanner;

import com.adsun.chat.client.command.Command;
import com.adsun.chat.client.utils.ChannelContext;
import com.adsun.chat.message.Message;
import com.adsun.chat.message.result.MessageResult;

import io.netty.channel.Channel;

/**
 * 对用户输入的命令进行处理
 * @author fengxiang
 * @date 2018年5月18日
 */
public class ClientMessageHandler {
	
	public void execute() {
		while (true) {
			String input = this.userInput();
			if (Command.EXIT.equals(input)) {
				System.exit(0);
			} else if (input.startsWith(Command.SENDMSG+" ")) {
				String[] args = input.split(" ", 2);
				String msgTo = args[1].trim();
				ChannelContext.getInstance().setMsgTo(msgTo);
			} else if (ChannelContext.getInstance().getChannel() != null && ChannelContext.getInstance().getMsgTo() != null) {
				sendMsgToServer(input);
			}
			break;
		}
	}
	
	private void sendMsgToServer(String str) {
		Channel channel = ChannelContext.getInstance().getChannel();
		MessageResult rt = new MessageResult(ChannelContext.getInstance(), str);
		channel.writeAndFlush(rt);
	}
	
	private String userInput() {
		Scanner sc = new Scanner(System.in);
		String input = "";
		try {
			input = sc.nextLine();
			ChannelContext.getInstance().getChannel().writeAndFlush(new Message(input.trim()));
		} finally {
			sc.close();
		}
		return input;
	}
}
