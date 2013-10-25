package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IBrandDao;
import com.zz.b2cshop.product.dao.entity.Brand;

@Repository
public class BrandDaoImpl extends BaseDaoSupport<Brand> implements IBrandDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> getBrands(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> getBrandByName(String brandName) {
		return super.findByCriteria(createDetachedCriteria().add(Restrictions.ilike("name", brandName)));
	}

}
