package com.zz.b2cshop.product.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.ProductType;

public interface IProductTypeService {
	
	public ProductType getPtById(Long id);

	public void addProductType(ProductType pt);

	public void updateProductType(ProductType pt);

	public void delProductType(ProductType pt);

	public List<ProductType> getAllPts();

	public List<ProductType> getPts(Page page);
}
