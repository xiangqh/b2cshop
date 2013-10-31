package com.zz.b2cshop.product.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zz.b2cshop.common.PO;

@Entity
@Table(name = "b2c_goods")
public class Goods extends PO {

	private static final long serialVersionUID = -6890378992657145994L;

	@Column
	private String name;
	@Column
	private String sn;
	@Column
	private String bra_code;
	@Column
	private String promote_word;
	@Column
	private String description;
	@Column
	private boolean status;
	@Column
	private Date market_time;
	@Column
	private BigDecimal market_price;
	@Column
	private BigDecimal price;
	@Column
	private int point;
	@Column
	private String img_value;
	@Column
	private int stock;
	@Column
	private Date create_time;
	@Column
	private Date update_time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getBra_code() {
		return bra_code;
	}

	public void setBra_code(String bra_code) {
		this.bra_code = bra_code;
	}

	public String getPromote_word() {
		return promote_word;
	}

	public void setPromote_word(String promote_word) {
		this.promote_word = promote_word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getMarket_time() {
		return market_time;
	}

	public void setMarket_time(Date market_time) {
		this.market_time = market_time;
	}

	public BigDecimal getMarket_price() {
		return market_price;
	}

	public void setMarket_price(BigDecimal market_price) {
		this.market_price = market_price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getImg_value() {
		return img_value;
	}

	public void setImg_value(String img_value) {
		this.img_value = img_value;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bra_code == null) ? 0 : bra_code.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((img_value == null) ? 0 : img_value.hashCode());
		result = prime * result + ((market_price == null) ? 0 : market_price.hashCode());
		result = prime * result + ((market_time == null) ? 0 : market_time.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + point;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((promote_word == null) ? 0 : promote_word.hashCode());
		result = prime * result + ((sn == null) ? 0 : sn.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + stock;
		result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
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
		Goods other = (Goods) obj;
		if (bra_code == null) {
			if (other.bra_code != null)
				return false;
		} else if (!bra_code.equals(other.bra_code))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (img_value == null) {
			if (other.img_value != null)
				return false;
		} else if (!img_value.equals(other.img_value))
			return false;
		if (market_price == null) {
			if (other.market_price != null)
				return false;
		} else if (!market_price.equals(other.market_price))
			return false;
		if (market_time == null) {
			if (other.market_time != null)
				return false;
		} else if (!market_time.equals(other.market_time))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (point != other.point)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (promote_word == null) {
			if (other.promote_word != null)
				return false;
		} else if (!promote_word.equals(other.promote_word))
			return false;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		if (status != other.status)
			return false;
		if (stock != other.stock)
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", sn=" + sn + ", bra_code=" + bra_code + ", promote_word=" + promote_word
				+ ", description=" + description + ", status=" + status + ", market_time=" + market_time
				+ ", market_price=" + market_price + ", price=" + price + ", point=" + point + ", img_value="
				+ img_value + ", stock=" + stock + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", category=" + category + ", brand=" + brand + "]";
	}

}
