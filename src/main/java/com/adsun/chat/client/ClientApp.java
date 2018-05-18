package com.adsun.chat.client;

import java.util.Scanner;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class ClientApp {
	public static void main(String[] args) {
		/**
		 * 启动连接server线程
		 */
		Thread t1 = new Thread(new ConnectServerRunnable());
		t1.start();
		while (true) {
			Scanner sc = new Scanner(System.in);
			try {
				String input = sc.nextLine();
				
			} finally {
				sc.close();
			}
		}
		
		
	}
}
