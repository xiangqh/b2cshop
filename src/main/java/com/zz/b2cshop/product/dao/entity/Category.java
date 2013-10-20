package com.zz.b2cshop.product.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh
 * 
 */
@Entity
@Table(name = "b2c_category")
public class Category extends PO {

	private static final long serialVersionUID = -7852720600536621665L;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parent;

	@Column
	private Long left_num;

	@Column
	private Long right_num;

	@Column
	private Long sort_num;

	@Column
	@Type(type = "yes_no")
	private Boolean publish_status;

	@ManyToOne
	@JoinColumn(name = "pt_id")
	private ProductType pt;

	@Column
	@Type(type = "yes_no")
	private Boolean is_del;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Long getLeft_num() {
		return left_num;
	}

	public void setLeft_num(Long left_num) {
		this.left_num = left_num;
	}

	public Long getRight_num() {
		return right_num;
	}

	public void setRight_num(Long right_num) {
		this.right_num = right_num;
	}

	public Long getSort_num() {
		return sort_num;
	}

	public void setSort_num(Long sort_num) {
		this.sort_num = sort_num;
	}

	public Boolean getPublish_status() {
		return publish_status;
	}

	public void setPublish_status(Boolean publish_status) {
		this.publish_status = publish_status;
	}

	public ProductType getPt() {
		return pt;
	}

	public void setPt(ProductType pt) {
		this.pt = pt;
	}

	public Boolean getIs_del() {
		return is_del;
	}

	public void setIs_del(Boolean is_del) {
		this.is_del = is_del;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((is_del == null) ? 0 : is_del.hashCode());
		result = prime * result + ((left_num == null) ? 0 : left_num.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((pt == null) ? 0 : pt.hashCode());
		result = prime * result + ((publish_status == null) ? 0 : publish_status.hashCode());
		result = prime * result + ((right_num == null) ? 0 : right_num.hashCode());
		result = prime * result + ((sort_num == null) ? 0 : sort_num.hashCode());
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
		Category other = (Category) obj;
		if (is_del == null) {
			if (other.is_del != null)
				return false;
		} else if (!is_del.equals(other.is_del))
			return false;
		if (left_num == null) {
			if (other.left_num != null)
				return false;
		} else if (!left_num.equals(other.left_num))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (pt == null) {
			if (other.pt != null)
				return false;
		} else if (!pt.equals(other.pt))
			return false;
		if (publish_status == null) {
			if (other.publish_status != null)
				return false;
		} else if (!publish_status.equals(other.publish_status))
			return false;
		if (right_num == null) {
			if (other.right_num != null)
				return false;
		} else if (!right_num.equals(other.right_num))
			return false;
		if (sort_num == null) {
			if (other.sort_num != null)
				return false;
		} else if (!sort_num.equals(other.sort_num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", parent=" + parent + ", left_num=" + left_num + ", right_num=" + right_num
				+ ", sort_num=" + sort_num + ", publish_status=" + publish_status + ", pt=" + pt + ", is_del=" + is_del
				+ "]";
	}

}
