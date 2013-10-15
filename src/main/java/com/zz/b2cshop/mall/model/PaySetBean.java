package com.zz.b2cshop.mall.model;

import java.util.Arrays;

/**
 * @author xiangqh
 *
 */
public class PaySetBean {

	/**
	 * "货到付款"
	 */
	private String delivery;

	/**
	 * ems、快递、平邮
	 */
	private String[] arr_delivery;

	/**
	 * "在线支付"
	 */
	private String online_payment;

	/**
	 * ems、快递、平邮
	 */
	private String[] arr_online;
	/**
	 * "银行汇款"
	 */
	private String bank_transfer;

	/**
	 * ems、快递、平邮
	 */
	private String[] arr_bank;

	/**
	 * "邮局汇款"
	 */
	private String remittance;

	/**
	 * ems、快递、平邮
	 */
	private String[] arr_remit;

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String[] getArr_delivery() {
		return arr_delivery;
	}

	public void setArr_delivery(String[] arr_delivery) {
		this.arr_delivery = arr_delivery;
	}

	public String getOnline_payment() {
		return online_payment;
	}

	public void setOnline_payment(String online_payment) {
		this.online_payment = online_payment;
	}

	public String[] getArr_online() {
		return arr_online;
	}

	public void setArr_online(String[] arr_online) {
		this.arr_online = arr_online;
	}

	public String getBank_transfer() {
		return bank_transfer;
	}

	public void setBank_transfer(String bank_transfer) {
		this.bank_transfer = bank_transfer;
	}

	public String[] getArr_bank() {
		return arr_bank;
	}

	public void setArr_bank(String[] arr_bank) {
		this.arr_bank = arr_bank;
	}

	public String getRemittance() {
		return remittance;
	}

	public void setRemittance(String remittance) {
		this.remittance = remittance;
	}

	public String[] getArr_remit() {
		return arr_remit;
	}

	public void setArr_remit(String[] arr_remit) {
		this.arr_remit = arr_remit;
	}

	@Override
	public String toString() {
		return String
				.format("PaySetBean [delivery=%s, arr_delivery=%s, online_payment=%s, arr_online=%s, bank_transfer=%s, arr_bank=%s, remittance=%s, arr_remit=%s]",
						delivery, Arrays.toString(arr_delivery), online_payment, Arrays.toString(arr_online),
						bank_transfer, Arrays.toString(arr_bank), remittance, Arrays.toString(arr_remit));
	}

}
