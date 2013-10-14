package com.zz.b2cshop.mall.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.mall.dao.IMallDao;
import com.zz.b2cshop.mall.dao.entity.Mall;

@Repository
public class MallDaoImpl extends BaseDaoSupport<Mall> implements IMallDao {

	@Override
	public void addMall(Mall mall) {
		super.save(mall);
	}

	@Override
	public Mall getMallById(Long id) {
		return super.getById(id);
	}

	@Override
	public Mall getMallByUrl(String url) {
		return (Mall) super.findByCriteria(createDetachedCriteria().add(Restrictions.eq("url", url)));
	}

	@Override
	public List<Mall> getMallList() {
		return super.getList();
	}

	@Override
	public void updateMall(Mall mall) {
		super.update(mall);
	}

}
