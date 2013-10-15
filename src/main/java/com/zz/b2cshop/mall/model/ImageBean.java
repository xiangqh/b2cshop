package com.zz.b2cshop.mall.model;

/**
 * @author xiangqh
 *
 */
public class ImageBean {

	private int width;
	private int height;

	public ImageBean() {
	}

	public ImageBean(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("ImageBean [width=%s, height=%s]", width, height);
	}

}
