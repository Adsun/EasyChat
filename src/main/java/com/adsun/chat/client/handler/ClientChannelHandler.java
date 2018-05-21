package com.adsun.chat.client.handler;

import com.adsun.chat.client.utils.ChannelContext;
import com.adsun.chat.message.Message;
import com.adsun.chat.observer.MessageHandlerObserverable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * 对和server之间的连接进行处理
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class ClientChannelHandler extends SimpleChannelInboundHandler<Message>{
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		MessageHandlerObserverable.getInstance().notifyObserver(msg);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ChannelContext.getInstance().setChannel(ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
