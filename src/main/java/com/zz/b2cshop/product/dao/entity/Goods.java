package com.zz.b2cshop.product.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import sun.nio.cs.ext.Big5;

import com.zz.b2cshop.common.PO;

@Entity
@Table(name = "b2c_goods")
public class Goods extends PO {

	private String name;
	private String sn;
	private String bra_code;
	private String promote_word;
	private boolean status;
	private Date market_time;
	private BigDecimal market_price;
	private BigDecimal price;
	private int point;
	private String img_value;
	private int stock;
	private Date create_time;
	private Date update_time;
	private Category category;
	private Brand brand;
	
	private String list_imgs;// 列表页缩略图 大图
	private String small_imgs;// 详细页缩略图 小图
	private String gd_content;//
	private String keywords;
	private String description;
	private String tag_ids;
	private String spec_array;// 序列化存储规格,key值为规则ID，value为此商品具有的规格值

	private Date up_time; // 上架时间
	private Date down_time; // 下架时间
	
}
