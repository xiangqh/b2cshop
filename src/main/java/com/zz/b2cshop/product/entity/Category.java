package com.zz.b2cshop.product.entity;

import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh
 *
 */
public class Category extends PO {

	/**
	 * "分类名称"
	 */
	private String cate_name;
	/**
	 * "分类父id"
	 */
	private Long parent_id;

	/**
	 * "左号，方便查询"
	 */
	private long left_num;

	/**
	 * " 右号，方便查询"
	 */
	private long right_num;
	/**
	 * "分类展示排序"
	 */
	private long sort_num;

	/**
	 * " 发布状态"
	 */
	private int publish_status;

	/**
	 * " 外键，商品品类 主键 整型，自增长"
	 */
	private Long pt_id;

	/**
	 * " 是否删除"
	 */
	private int is_del;

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
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

	public Integer getPublish_status() {
		return publish_status;
	}

	public void setPublish_status(Integer publish_status) {
		this.publish_status = publish_status;
	}

	public Long getPt_id() {
		return pt_id;
	}

	public void setPt_id(Long pt_id) {
		this.pt_id = pt_id;
	}

	public int getIs_del() {
		return is_del;
	}

	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}



}
