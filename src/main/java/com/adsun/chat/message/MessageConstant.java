package com.adsun.chat.message;

import com.adsun.chat.message.result.*;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class MessageConstant {
	public final static int BASE_LEN = 4 + 4 + 4; //基本长度=HEADER_+MESSAGE_TYPE+内容长度标识=4+4+4
	public final static int MAX_LEN = 2048; //最大长度
	public final static int HEADER_ = 0X76; //消息头
	
	public enum MESSAGE_TYPE {
		BYTES(0,byte[].class),
		STRING(1,String.class),
		CONNECTRESULT(10, ConnectResult.class),
		LOGINRESULT(11,LoginResult.class);

		private int type;
		
		private Class<?> clazz;

		private MESSAGE_TYPE(int type, Class<?> clazz) {
			this.type = type;
			this.clazz = clazz;
		}
		
		public static MESSAGE_TYPE getMessageType(int messageType) {
			if (MESSAGE_TYPE.BYTES.getType() == messageType) {
				return BYTES;
			} else if (MESSAGE_TYPE.STRING.getType() == messageType) {
				return STRING;
			} else if (MESSAGE_TYPE.CONNECTRESULT.getType() == messageType) {
				return CONNECTRESULT;
			}
			return null;
		}

		public Class<?> getClazz() {
			return clazz;
		}

		public void setClazz(Class<?> clazz) {
			this.clazz = clazz;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}
	}
}
