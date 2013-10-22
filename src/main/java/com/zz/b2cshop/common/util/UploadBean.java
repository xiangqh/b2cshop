package com.zz.b2cshop.common.util;

import java.io.File;

public class UploadBean {

	private File[] up;

	private String[] upContentType;

	private String[] upFileName;

	public File[] getUp() {
		return up;
	}

	public void setUp(File[] up) {
		this.up = up;
	}

	public String[] getUpContentType() {
		return upContentType;
	}

	public void setUpContentType(String[] upContentType) {
		this.upContentType = upContentType;
	}

	public String[] getUpFileName() {
		return upFileName;
	}

	public void setUpFileName(String[] upFileName) {
		this.upFileName = upFileName;
	}

}
