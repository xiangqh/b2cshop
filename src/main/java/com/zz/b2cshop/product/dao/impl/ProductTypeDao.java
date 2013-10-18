package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IProductTypeDao;
import com.zz.b2cshop.product.dao.entity.ProductType;

@Repository
public class ProductTypeDao extends BaseDaoSupport<ProductType> implements IProductTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> getPts(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

}
