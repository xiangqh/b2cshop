package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.dao.entity.Attr;

@Repository
public class AttrDaoImpl extends BaseDaoSupport<Attr> implements IAttrDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Attr> getAttrs(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

}
