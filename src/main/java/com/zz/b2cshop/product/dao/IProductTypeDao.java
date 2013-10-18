package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.PODao;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.ProductType;

public interface IProductTypeDao extends PODao<ProductType>{

	public List<ProductType> getPts(Page page);

}
