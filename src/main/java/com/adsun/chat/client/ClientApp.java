package com.adsun.chat.client;

import com.adsun.chat.client.handler.ClientChannelHandler;
import com.adsun.chat.coder.DecodeHandler;
import com.adsun.chat.coder.EncodeHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class ClientApp {
	public static void main(String[] args) throws InterruptedException {

		EventLoopGroup workerGroup = new NioEventLoopGroup();  
        Bootstrap bootstrap = new Bootstrap();  
        try {
			bootstrap.group(workerGroup).channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							socketChannel.pipeline().addLast(new DecodeHandler()); 
							socketChannel.pipeline().addLast(new EncodeHandler());
//							socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
//							socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
							socketChannel.pipeline().addLast(new ClientChannelHandler()); 
							
							
						}
					});
			ChannelFuture future = bootstrap.connect("localhost", 8379).sync();
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();  
		}  
	
	}
}
