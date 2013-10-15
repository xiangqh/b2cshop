package com.zz.b2cshop.mall.model;

/**
 * @author xiangqh
 *
 */
public class GoodsOptionBean {

	private int can_shelves;
	private int shelves_on;
	private int stock0_buy;

	public GoodsOptionBean() {
	}

	public GoodsOptionBean(int can_shelves, int shelves_on, int stock0_buy) {
		super();
		this.can_shelves = can_shelves;
		this.shelves_on = shelves_on;
		this.stock0_buy = stock0_buy;
	}

	public int getCan_shelves() {
		return can_shelves;
	}

	public void setCan_shelves(int can_shelves) {
		this.can_shelves = can_shelves;
	}

	public int getShelves_on() {
		return shelves_on;
	}

	public void setShelves_on(int shelves_on) {
		this.shelves_on = shelves_on;
	}

	public int getStock0_buy() {
		return stock0_buy;
	}

	public void setStock0_buy(int stock0_buy) {
		this.stock0_buy = stock0_buy;
	}

	@Override
	public String toString() {
		return String.format("GoodsOptionBean [can_shelves=%s, shelves_on=%s, stock0_buy=%s]", can_shelves, shelves_on,
				stock0_buy);
	}

}
