package com.zz.b2cshop.mall.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

@Entity
@Table(name = "b2c_mall_setting")
public class MallSetting extends PO {

	private static final long serialVersionUID = -2253783146245034676L;

	@Column
	private Integer mall_id;

	@Column
	private String setting_key;

	@Column
	private String setting_value;

	public Integer getMall_id() {
		return mall_id;
	}

	public void setMall_id(Integer mall_id) {
		this.mall_id = mall_id;
	}

	public String getSetting_key() {
		return setting_key;
	}

	public void setSetting_key(String setting_key) {
		this.setting_key = setting_key;
	}

	public String getSetting_value() {
		return setting_value;
	}

	public void setSetting_value(String setting_value) {
		this.setting_value = setting_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mall_id == null) ? 0 : mall_id.hashCode());
		result = prime * result + ((setting_key == null) ? 0 : setting_key.hashCode());
		result = prime * result + ((setting_value == null) ? 0 : setting_value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MallSetting other = (MallSetting) obj;
		if (mall_id == null) {
			if (other.mall_id != null)
				return false;
		} else if (!mall_id.equals(other.mall_id))
			return false;
		if (setting_key == null) {
			if (other.setting_key != null)
				return false;
		} else if (!setting_key.equals(other.setting_key))
			return false;
		if (setting_value == null) {
			if (other.setting_value != null)
				return false;
		} else if (!setting_value.equals(other.setting_value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MallSetting [mall_id=" + mall_id + ", setting_key=" + setting_key + ", setting_value=" + setting_value
				+ "]";
	}
}
