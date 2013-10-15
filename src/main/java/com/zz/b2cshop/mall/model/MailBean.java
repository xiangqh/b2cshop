package com.zz.b2cshop.mall.model;

/**
 * @author xiangqh
 *
 */
public class MailBean {

	private String smtpServer;
	private String email;
	private String pwd;
	private int isCheck;

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}

	@Override
	public String toString() {
		return String.format("MailBean [smtpServer=%s, email=%s, pwd=%s, isCheck=%s]", smtpServer, email, pwd, isCheck);
	}

}
