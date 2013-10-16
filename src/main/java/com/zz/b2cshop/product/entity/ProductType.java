package com.zz.b2cshop.product.entity;

import java.util.List;

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
public class ProductType extends PO {

	/**
	 * "品类名称"
	 */
	private String pt_name;
	/**
	 * "排序id"
	 */
	private long sort_num;

	/**
	 * 品类属性集合
	 */
	private List<Attr> attrs;


}
