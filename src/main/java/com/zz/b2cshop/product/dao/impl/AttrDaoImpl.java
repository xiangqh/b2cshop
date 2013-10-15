package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.BASTORE;
import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.entity.Attr;

@Repository
public class AttrDaoImpl extends BaseDaoSupport<Attr> implements IAttrDao {

	@Override
	public void addBrandAttr(Attr brandAttr) {
		super.save(brandAttr);
	}

	@Override
	public void updateBrandAttr(Attr brandAttr) {
		super.update(brandAttr);
	}

	@Override
	public void delBrandAttr(Attr brandAttr) {
		super.delete(brandAttr);
	}

	@Override
	public List<Attr> getAllBrandAttrs() {
		return super.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> getBrandAttrs(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

}
