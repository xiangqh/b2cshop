package com.zz.b2cshop.mall.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

@Entity
@Table(name = "b2c_mall")
public class Mall extends PO {

	private static final long serialVersionUID = -2831114028240251941L;
	
	@Column
	private String name;// 商店名称
	@Column
	private String url;// 商城地址
	@Column
	private String logo;// 商店logo
	@Column
	private String master;// 商店联系人
	@Column
	private String qq;//
	@Column
	private String email;//
	@Column
	private String mobile;//
	@Column
	private String phone;//
	@Column
	private String address;// 商店地址
	@Column
	private String goods_no_pre;// 商品货号前缀，只取前两位
	@Column
	private String index_seo_keywords;// 首页keywords
	@Column
	private String index_seo_description;// 首页description

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGoods_no_pre() {
		return goods_no_pre;
	}

	public void setGoods_no_pre(String goods_no_pre) {
		this.goods_no_pre = goods_no_pre;
	}

	public String getIndex_seo_keywords() {
		return index_seo_keywords;
	}

	public void setIndex_seo_keywords(String index_seo_keywords) {
		this.index_seo_keywords = index_seo_keywords;
	}

	public String getIndex_seo_description() {
		return index_seo_description;
	}

	public void setIndex_seo_description(String index_seo_description) {
		this.index_seo_description = index_seo_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((goods_no_pre == null) ? 0 : goods_no_pre.hashCode());
		result = prime * result + ((index_seo_description == null) ? 0 : index_seo_description.hashCode());
		result = prime * result + ((index_seo_keywords == null) ? 0 : index_seo_keywords.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
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
		Mall other = (Mall) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (goods_no_pre == null) {
			if (other.goods_no_pre != null)
				return false;
		} else if (!goods_no_pre.equals(other.goods_no_pre))
			return false;
		if (index_seo_description == null) {
			if (other.index_seo_description != null)
				return false;
		} else if (!index_seo_description.equals(other.index_seo_description))
			return false;
		if (index_seo_keywords == null) {
			if (other.index_seo_keywords != null)
				return false;
		} else if (!index_seo_keywords.equals(other.index_seo_keywords))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
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
		return "Mall [name=" + name + ", url=" + url + ", logo=" + logo + ", master=" + master + ", qq=" + qq
				+ ", email=" + email + ", mobile=" + mobile + ", phone=" + phone + ", address=" + address
				+ ", goods_no_pre=" + goods_no_pre + ", index_seo_keywords=" + index_seo_keywords
				+ ", index_seo_description=" + index_seo_description + "]";
	}
}
