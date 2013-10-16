package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.entity.ProductType;

public interface IAttrDao {

	public void addBrandAttr(ProductType brandAttr);

	public void updateBrandAttr(ProductType brandAttr);

	public void delBrandAttr(ProductType brandAttr);

	public List<ProductType> getAllBrandAttrs();

	public List<ProductType> getBrandAttrs(Page page);

}
