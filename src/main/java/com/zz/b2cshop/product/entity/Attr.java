package com.zz.b2cshop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

/**
 * 
 * @author working-cat
 * 品类
 */
@Entity
@Table(name="b2c_attr")
public class Attr extends PO {
	
	public static final int ATTR_TYPE_GOODS_SPLITER = 1 ;	// 拆分属性
	public static final int ATTR_TYPE_STOCK_SPLITER = 2 ;	// 选购属性
	public static final int ATTR_TYPE_PRICE = 3 ;			// 价格属性
	public static final int ATTR_TYPE_FILKTER = 4 ;			// 筛选属性

	private static final long serialVersionUID = 5055390783499083497L;

	@Column
	private String name;

	/**
	 * 特殊属性串，包括拆分，选购，价格
	 */
	@Column
	private String specialAttr;
	/**
	 * 自定义增加的附加属性串
	 */
	@Column
	private String normalAttr;

	// 页面显示属性
	private String splitName;
	private String splitValue;
	private String changeName;
	private String changeValue;
	private String priceName;
	private String priceValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialAttr() {
		return specialAttr;
	}

	public void setSpecialAttr(String specialAttr) {
		this.specialAttr = specialAttr;
	}

	public String getNormalAttr() {
		return normalAttr;
	}

	public void setNormalAttr(String normalAttr) {
		this.normalAttr = normalAttr;
	}

	public String getSplitName() {
		return splitName;
	}

	public void setSplitName(String splitName) {
		this.splitName = splitName;
	}

	public String getSplitValue() {
		return splitValue;
	}

	public void setSplitValue(String splitValue) {
		this.splitValue = splitValue;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(String changeValue) {
		this.changeValue = changeValue;
	}

	public String getPriceName() {
		return priceName;
	}

	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}

	public String getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(String priceValue) {
		this.priceValue = priceValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((changeName == null) ? 0 : changeName.hashCode());
		result = prime * result + ((changeValue == null) ? 0 : changeValue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((normalAttr == null) ? 0 : normalAttr.hashCode());
		result = prime * result + ((priceName == null) ? 0 : priceName.hashCode());
		result = prime * result + ((priceValue == null) ? 0 : priceValue.hashCode());
		result = prime * result + ((specialAttr == null) ? 0 : specialAttr.hashCode());
		result = prime * result + ((splitName == null) ? 0 : splitName.hashCode());
		result = prime * result + ((splitValue == null) ? 0 : splitValue.hashCode());
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
		Attr other = (Attr) obj;
		if (changeName == null) {
			if (other.changeName != null)
				return false;
		} else if (!changeName.equals(other.changeName))
			return false;
		if (changeValue == null) {
			if (other.changeValue != null)
				return false;
		} else if (!changeValue.equals(other.changeValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (normalAttr == null) {
			if (other.normalAttr != null)
				return false;
		} else if (!normalAttr.equals(other.normalAttr))
			return false;
		if (priceName == null) {
			if (other.priceName != null)
				return false;
		} else if (!priceName.equals(other.priceName))
			return false;
		if (priceValue == null) {
			if (other.priceValue != null)
				return false;
		} else if (!priceValue.equals(other.priceValue))
			return false;
		if (specialAttr == null) {
			if (other.specialAttr != null)
				return false;
		} else if (!specialAttr.equals(other.specialAttr))
			return false;
		if (splitName == null) {
			if (other.splitName != null)
				return false;
		} else if (!splitName.equals(other.splitName))
			return false;
		if (splitValue == null) {
			if (other.splitValue != null)
				return false;
		} else if (!splitValue.equals(other.splitValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrandAttr [name=" + name + ", specialAttr=" + specialAttr + ", normalAttr=" + normalAttr
				+ ", splitName=" + splitName + ", splitValue=" + splitValue + ", changeName=" + changeName
				+ ", changeValue=" + changeValue + ", priceName=" + priceName + ", priceValue=" + priceValue + "]";
	}

}
