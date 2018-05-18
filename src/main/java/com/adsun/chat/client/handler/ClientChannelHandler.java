package com.adsun.chat.client.handler;

import com.adsun.chat.client.utils.ServerChannel;
import com.adsun.chat.message.Message;
import com.adsun.chat.observer.MessageHandlerObserverable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class ClientChannelHandler extends SimpleChannelInboundHandler<Message>{
	
	private MessageHandlerObserverable ob;
	
	public ClientChannelHandler(MessageHandlerObserverable ob) {
		this.setOb(ob);
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
		/*System.out.println(msg.toString());
		ConnectResult result = JSON.parseObject(msg.toString(), ConnectResult.class);
		
		ctx.writeAndFlush(new Message(result.getUuid()));*/
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ServerChannel.channel = ctx.channel();
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	/**
	 * @return the ob
	 */
	public MessageHandlerObserverable getOb() {
		return ob;
	}

	/**
	 * @param ob the ob to set
	 */
	public void setOb(MessageHandlerObserverable ob) {
		this.ob = ob;
	}
	
}
