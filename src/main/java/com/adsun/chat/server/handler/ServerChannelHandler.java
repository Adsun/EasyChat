package com.adsun.chat.server.handler;

import com.adsun.chat.message.ConnectResult;
import com.adsun.chat.message.Message;
import com.adsun.chat.message.MessageConstant.MESSAGE_TYPE;
import com.adsun.chat.server.utils.ClientConnectMannage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class ServerChannelHandler extends SimpleChannelInboundHandler<Message>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		/*Channel channel = ClientConnectMannage.getChannel(msg.getValue());
		channel.writeAndFlush(new Message("ok!"));*/
		System.out.println(msg.toString());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ConnectResult result = new ConnectResult();
		ClientConnectMannage.addChannel(result.getUuid(), ctx.channel());
		ctx.writeAndFlush(new Message(result, MESSAGE_TYPE.CONNECTRESULT));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
