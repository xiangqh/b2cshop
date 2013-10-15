package com.zz.b2cshop.mall.model;

/**
 * @author xiangqh
 *
 */
public class ImageSettingBean {

	private ImageBean img1;
	private ImageBean img2;
	private ImageBean img3;
	private ImageBean img4;
	private ImageBean img5;

	public ImageBean getImg1() {
		return img1;
	}

	public void setImg1(ImageBean img1) {
		this.img1 = img1;
	}

	public ImageBean getImg2() {
		return img2;
	}

	public void setImg2(ImageBean img2) {
		this.img2 = img2;
	}

	public ImageBean getImg3() {
		return img3;
	}

	public void setImg3(ImageBean img3) {
		this.img3 = img3;
	}

	public ImageBean getImg4() {
		return img4;
	}

	public void setImg4(ImageBean img4) {
		this.img4 = img4;
	}

	public ImageBean getImg5() {
		return img5;
	}

	public void setImg5(ImageBean img5) {
		this.img5 = img5;
	}

	@Override
	public String toString() {
		return String.format("ImageSettingBean [img1=%s, img2=%s, img3=%s, img4=%s, img5=%s]", img1, img2, img3, img4,
				img5);
	}

}
