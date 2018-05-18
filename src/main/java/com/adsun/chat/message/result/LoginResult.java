package com.adsun.chat.message.result;

/**
 * @author fengxiang
 * @date 2018年5月18日
 */
public class LoginResult extends BasicResult{
	private String userName;
	private int resultCode;
	private int errorMsg;
	private String publicKey;
	private String encryptType;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the resultCode
	 */
	public int getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the errorMsg
	 */
	public int getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(int errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the publicKey
	 */
	public String getPublicKey() {
		return publicKey;
	}
	/**
	 * @param publicKey the publicKey to set
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	/**
	 * @return the encryptType
	 */
	public String getEncryptType() {
		return encryptType;
	}
	/**
	 * @param encryptType the encryptType to set
	 */
	public void setEncryptType(String encryptType) {
		this.encryptType = encryptType;
	}
	
}
