package com.zz.b2cshop.product.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import sun.nio.cs.ext.Big5;

import com.zz.b2cshop.common.PO;

@Entity
@Table(name = "b2c_goods")
public class Goods extends PO {

	/**
	 * 货号
	 */
	private String gd_sn;
	/**
	 * 商品名称
	 */
	private String gd_name;
	private Long category_id;
	private Long brand_id;
	private Integer gd_stock; //商品库存
	private String gd_promote_word; //
	private String gd_img; 
	private String list_imgs;//列表页缩略图 大图
	private String small_imgs;//详细页缩略图 小图
	private String gd_content;//
	private String keywords;
	private String description;
	private String tag_ids; 
	private String spec_array;//序列化存储规格,key值为规则ID，value为此商品具有的规格值
	
	private Integer point;
	private BigDecimal sell_price; //销售价格
	private BigDecimal market_price; //市场价格
	private BigDecimal cost_price; //成本价
	
	private Date up_time; //上架时间
	private Date down_time; //下架时间
	private Date create_time;//创建时间
	private Date update_time;//修改时间
	/**
	 * 分类ID
	 */
	
	/**
	 * 品牌ID
	 */
	
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 商品所选属性项 JSON
	 */
	private String cdity_attr;
	/**
	 * 搜索属性
	 */
	private String serach_attr;
	/**
	 * 商品描叙
	 */
	private String cdity_desc;
	/**
	 * 是否收取邮费
	 */
	private int freightTag = 1;
	/**
	 * 邮费提示
	 */
	private String freightTip;
	/**
	 * SEO关键词语
	 */
	private String seoWord;
	private String ctName;

	private int attrId;
	private String attrSpecial;
	private String attrNormal;
	private String attrPageCboxs;
	private String attrSearchBox;
	private String priceAttr;
	private String pricePageAttr;
	private String categoryIds;

	private int displayTag;
	private String unit;
}
