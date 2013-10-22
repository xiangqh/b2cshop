package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.PODao;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Brand;

public interface IBrandDao extends PODao<Brand> {

	public List<Brand> getBrands(Page page);

}
