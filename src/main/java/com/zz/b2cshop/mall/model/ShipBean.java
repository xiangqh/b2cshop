package com.zz.b2cshop.mall.model;

import java.math.BigDecimal;

/**
 * @author xiangqh
 *
 */
public class ShipBean {

	private BigDecimal fastPost;// 快递
	private BigDecimal slowPost;// 平邮
	private BigDecimal ems;

	public ShipBean() {
	}

	public ShipBean(BigDecimal fastPost, BigDecimal slowPost, BigDecimal ems) {
		super();
		this.fastPost = fastPost;
		this.slowPost = slowPost;
		this.ems = ems;
	}

	public BigDecimal getFastPost() {
		return fastPost;
	}

	public void setFastPost(BigDecimal fastPost) {
		this.fastPost = fastPost;
	}

	public BigDecimal getSlowPost() {
		return slowPost;
	}

	public void setSlowPost(BigDecimal slowPost) {
		this.slowPost = slowPost;
	}

	public BigDecimal getEms() {
		return ems;
	}

	public void setEms(BigDecimal ems) {
		this.ems = ems;
	}

	@Override
	public String toString() {
		return String.format("ShipBean [fastPost=%s, slowPost=%s, ems=%s]", fastPost, slowPost, ems);
	}

}
