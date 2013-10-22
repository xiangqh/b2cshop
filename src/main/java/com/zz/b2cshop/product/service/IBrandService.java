package com.zz.b2cshop.product.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Brand;

public interface IBrandService {

	public List<Brand> getAllBrand();

	public List<Brand> getBrands(Page page);

	public void addBrand(Brand brand);

	public void updateBrand(Brand brand);

	public void delBrand(Brand brand);

}
