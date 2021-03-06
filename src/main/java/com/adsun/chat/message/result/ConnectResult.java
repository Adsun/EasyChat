package com.adsun.chat.message.result;

/**
 * @author fengxiang
 * @date 2018年5月17日
 */
public class ConnectResult extends BasicResult{
	
	private String resultCode;
	private String resultStr;
	
	/**
	 * @return the resultStr
	 */
	public String getResultStr() {
		return resultStr;
	}
	/**
	 * @param resultStr the resultStr to set
	 */
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	
}
