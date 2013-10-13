package com.zz.b2cshop.privilege.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh
 * 
 */
@Entity
@Table(name = "b2c_menu")
public class Menu extends PO {

	private static final long serialVersionUID = 2884541819158302324L;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private Integer level;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Menu parent;

	@Column(name = "url")
	private String url;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Menu> childrens = new HashSet<Menu>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Menu> getChildrens() {
		return childrens;
	}

	public void setChildrens(Set<Menu> childrens) {
		this.childrens = childrens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Menu other = (Menu) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", level=" + level + ", parent=" + parent + ", url=" + url + ", childrens="
				+ childrens + "]";
	}

}
