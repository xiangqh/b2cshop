package com.zz.b2cshop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IBrandDao;
import com.zz.b2cshop.product.dao.entity.Brand;

@Service
public class BrandService implements IBrandService {

	@Autowired
	private IBrandDao brandDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Brand> getAllBrand() {
		return brandDao.queryAll();
	}

	@Override
	public List<Brand> getBrands(Page page) {
		return brandDao.getBrands(page);
	}

	@Override
	public void addBrand(Brand brand) {
		brandDao.save(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		brandDao.update(brand);
	}

	@Override
	public void delBrand(Brand brand) {
		brandDao.delete(brand);
	}

}
