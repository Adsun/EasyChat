package com.adsun.chat.client.handler;

import com.adsun.chat.message.ConnectResult;
import com.adsun.chat.message.Message;
import com.alibaba.fastjson.JSON;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class ClientChannelHandler extends SimpleChannelInboundHandler<Message>{

	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		System.out.println(msg.toString());
		ConnectResult result = JSON.parseObject(msg.toString(), ConnectResult.class);
		
		ctx.writeAndFlush(new Message(result.getUuid()));
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
