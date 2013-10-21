package com.zz.b2cshop.product.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

/**
 * 
 * @author working-cat 品类
 */
@Entity
@Table(name = "b2c_attr")
public class ProductType extends PO {

	private static final long serialVersionUID = 3738368787429663897L;

	@Column
	private String name;

	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
	private List<Attr> attrs;

	public ProductType() {
	}

	public ProductType(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attr> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<Attr> attrs) {
		this.attrs = attrs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((attrs == null) ? 0 : attrs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProductType other = (ProductType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductType [pt_name=" + name + ", attrs=" + attrs + "]";
	}

}
