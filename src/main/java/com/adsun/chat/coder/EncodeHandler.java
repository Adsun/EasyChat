package com.adsun.chat.coder;

import java.util.List;

import com.adsun.chat.message.Message;
import com.adsun.chat.message.MessageConstant;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class EncodeHandler extends MessageToMessageEncoder<Message>{
	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
		ByteBuf buf = Unpooled.buffer();
		/**
		 * 发送header
		 */
		buf.writeInt(MessageConstant.HEADER_);
		/**
		 * 发送message type
		 */
		buf.writeInt(msg.getMessageType().getType());
		/**
		 * 发送长度信息
		 */
		buf.writeInt(msg.toString().getBytes(msg.getDefaultCharset()).length);
		/**
		 * 发送message内容
		 */
		buf.writeBytes(msg.toString().getBytes(msg.getDefaultCharset()));
		out.add(buf);
	}
}
