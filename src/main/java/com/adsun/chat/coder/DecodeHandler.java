package com.adsun.chat.coder;

import java.util.List;

import com.adsun.chat.message.Message;
import com.adsun.chat.message.MessageConstant;
import com.adsun.chat.message.MessageConstant.MESSAGE_TYPE;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
@Sharable
public class DecodeHandler extends MessageToMessageDecoder<ByteBuf>{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		
		if (msg.readableBytes() >= MessageConstant.BASE_LEN) {
			
			/**
			 * 长度过长，跳过
			 */
			if (msg.readableBytes() >= MessageConstant.MAX_LEN) {
				msg.skipBytes(msg.readableBytes());
			}
			
			int beginReader;
			
			while (true) {
				/**
				 * 获取包开始的index
				 */
				beginReader = msg.readerIndex();
				/**
				 * 标记当前index
				 */
				msg.markReaderIndex();
				
				/**
				 * 读到header，跳出循环
				 */
				if (msg.readInt() == MessageConstant.HEADER_) {
					break;
				}
				/**
				 * 没有读到header，返回之前标记的index
				 */
				msg.resetReaderIndex();
				/**
				 * 跳过一个字节
				 */
				msg.readByte();
				/**
				 * 当前可读字节长度不够，直接返回，让bytebuf继续接收信息
				 */
				if (msg.readableBytes() < MessageConstant.BASE_LEN) {
					return;
				}
			}
			/**
			 * 读取message type
			 */
			int messageType = msg.readInt();
			/**
			 * 读取message长度信息
			 */
			int length = msg.readInt();
			/**
			 * 当前可读字节长度不够，直接返回，让bytebuf继续接收信息
			 */
			if (msg.readableBytes() < length) {
				msg.readerIndex(beginReader);
				return;
			}
			
			byte[] data = new byte[length];
			msg.readBytes(data);
			Message message = new Message(data, MESSAGE_TYPE.getMessageType(messageType));
			out.add(message);
		}
	}
	
}
