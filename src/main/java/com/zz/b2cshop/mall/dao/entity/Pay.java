package com.zz.b2cshop.mall.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh
 *
 */
@Entity
@Table(name = "b2c_pay")
public class Pay extends PO {

	private static final long serialVersionUID = 7514117552034247905L;

	/**
	 * @design.function column="pay_type" column-desc="tinyint"
	 *                  description="支付类型"
	 */
	@Column
	private Integer payment_type;

	/**
	 * @design.function column="ship_value" column-desc="varchar，长度1000"
	 *                  description="配送方式内容，用json格式字符串"
	 */
	@Column
	private String ship_value;

	@Column
	private Integer is_delete;

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer is_delete) {
		this.is_delete = is_delete;
	}

	public String getShip_value() {
		return ship_value;
	}

	public void setShip_value(String ship_value) {
		this.ship_value = ship_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((is_delete == null) ? 0 : is_delete.hashCode());
		result = prime * result + ((payment_type == null) ? 0 : payment_type.hashCode());
		result = prime * result + ((ship_value == null) ? 0 : ship_value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Pay))
			return false;
		Pay other = (Pay) obj;
		if (is_delete == null) {
			if (other.is_delete != null)
				return false;
		} else if (!is_delete.equals(other.is_delete))
			return false;
		if (payment_type == null) {
			if (other.payment_type != null)
				return false;
		} else if (!payment_type.equals(other.payment_type))
			return false;
		if (ship_value == null) {
			if (other.ship_value != null)
				return false;
		} else if (!ship_value.equals(other.ship_value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Pay [payment_type=%s, is_delete=%s, ship_value=%s]", payment_type, is_delete, ship_value);
	}

}
