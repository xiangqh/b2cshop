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
	private String pt_name;

	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
	private List<Attr> attrs;

	public String getPt_name() {
		return pt_name;
	}

	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
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
		result = prime * result + ((pt_name == null) ? 0 : pt_name.hashCode());
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
		if (pt_name == null) {
			if (other.pt_name != null)
				return false;
		} else if (!pt_name.equals(other.pt_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductType [pt_name=" + pt_name + ", attrs=" + attrs + "]";
	}

}
