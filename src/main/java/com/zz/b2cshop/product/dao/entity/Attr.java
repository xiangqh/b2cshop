package com.zz.b2cshop.product.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh 品类属性表
 */
@Entity
@Table(name = "b2c_attr_val")
public class Attr extends PO {

	private static final long serialVersionUID = -39749884435132928L;

	public static final int ATTR_TYPE_GOODS_SPLITER = 1; // 拆分属性
	public static final int ATTR_TYPE_STOCK_SPLITER = 2; // 选购属性
	public static final int ATTR_TYPE_PRICE = 3; // 价格属性
	public static final int ATTR_TYPE_FILKTER = 4; // 筛选属性

	public Attr() {
	}

	public Attr(String attr_name, Integer attr_type, String attr_val) {
		this.attr_name = attr_name;
		this.attr_type = attr_type;
		this.attr_val = attr_val;
	}

	@ManyToOne
	@JoinColumn(name = "pt_id")
	private ProductType productType;
	/**
	 * "属性名 例如：颜色/尺寸"
	 */
	@Column
	private String attr_name;
	/**
	 * "属性别名，即后台属性的显示名称"
	 */
	@Column
	private String alias_name;
	/**
	 * "属性类别"
	 */
	@Column
	private Integer attr_type;

	@Column
	private String attr_val;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public String getAlias_name() {
		return alias_name;
	}

	public void setAlias_name(String alias_name) {
		this.alias_name = alias_name;
	}

	public Integer getAttr_type() {
		return attr_type;
	}

	public void setAttr_type(Integer attr_type) {
		this.attr_type = attr_type;
	}

	public String getAttr_val() {
		return attr_val;
	}

	public void setAttr_val(String attr_val) {
		this.attr_val = attr_val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alias_name == null) ? 0 : alias_name.hashCode());
		result = prime * result + ((attr_name == null) ? 0 : attr_name.hashCode());
		result = prime * result + ((attr_type == null) ? 0 : attr_type.hashCode());
		result = prime * result + ((attr_val == null) ? 0 : attr_val.hashCode());
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
		if (alias_name == null) {
			if (other.alias_name != null)
				return false;
		} else if (!alias_name.equals(other.alias_name))
			return false;
		if (attr_name == null) {
			if (other.attr_name != null)
				return false;
		} else if (!attr_name.equals(other.attr_name))
			return false;
		if (attr_type == null) {
			if (other.attr_type != null)
				return false;
		} else if (!attr_type.equals(other.attr_type))
			return false;
		if (attr_val == null) {
			if (other.attr_val != null)
				return false;
		} else if (!attr_val.equals(other.attr_val))
			return false;
		return true;
	}

}
