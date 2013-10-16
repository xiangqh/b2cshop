package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.BASTORE;
import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.entity.ProductType;

@Repository
public class AttrDaoImpl extends BaseDaoSupport<ProductType> implements IAttrDao {

	@Override
	public void addBrandAttr(ProductType brandAttr) {
		super.save(brandAttr);
	}

	@Override
	public void updateBrandAttr(ProductType brandAttr) {
		super.update(brandAttr);
	}

	@Override
	public void delBrandAttr(ProductType brandAttr) {
		super.delete(brandAttr);
	}

	@Override
	public List<ProductType> getAllBrandAttrs() {
		return super.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> getBrandAttrs(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

}
