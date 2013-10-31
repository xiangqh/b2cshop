package com.zz.b2cshop.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.ICategoryDao;
import com.zz.b2cshop.product.dao.entity.Category;

@Repository
public class CategoryDaoImpl extends BaseDaoSupport<Category> implements ICategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getList(Page page) {
		return super.findByCriteria(createDetachedCriteria(), page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getChildsByPId(Long id) {
		return super.findByCriteria(createDetachedCriteria().add(Restrictions.eq("parent.id", id)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getLevelFCatetegory() {
		return super.findByCriteria(createDetachedCriteria().add(Restrictions.isNull("parent")));
	}

}
