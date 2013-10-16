package com.zz.b2cshop.product.entity;

import com.zz.b2cshop.common.PO;


/**
 * @author xiangqh
 *  品类属性表
 *  b2c_attr
 */
public class Attr extends PO{

	/**
	 * @design.function column="attr_name" column_desc="属性名 例如：颜色/尺寸"
	 */
	private String attr_name;
	/**
	 * @design.function column="alias_name" column_desc="属性别名，即后台属性的显示名称"
	 */
	private String alias_name;
	/**
	 * @design.function column="attr_type" column_desc="属性类别"
	 */
	private int attr_type;
	/**
	 * @design.function column="sort_num" column_desc="排序号,用于后台筛选属性的排序显示，并不存在属性表里,存储在了品类属性关系表内"
	 *
	 */
	private int sort_num;
	/**
	 * @design.function column="sort_num" column_desc="排序号,用于后台筛选属性的是否必必选属性，并不存在属性表里,存储在了品类属性关系表内"
	 *
	 */
	private int is_required;

	private String attr_val;

}
