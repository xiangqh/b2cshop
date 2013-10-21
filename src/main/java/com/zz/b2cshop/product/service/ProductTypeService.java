package com.zz.b2cshop.product.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IProductTypeDao;
import com.zz.b2cshop.product.dao.entity.ProductType;

@Service
public class ProductTypeService implements IProductTypeService {

	@Autowired
	private IProductTypeDao productTypeDao;

	@Transactional
	@Override
	public void addProductType(ProductType pt) {
		productTypeDao.save(pt);

	}

	@Transactional
	@Override
	public void updateProductType(ProductType pt) {
		productTypeDao.update(pt);
	}

	@Transactional
	@Override
	public void delProductType(ProductType pt) {
		productTypeDao.delete(pt);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductType> getAllPts() {
		List<ProductType> list = productTypeDao.queryAll();
		for (ProductType pt : list) {
			Hibernate.initialize(pt.getAttrs());
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductType> getPts(Page page) {
		return productTypeDao.getPts(page);
	}

	@Transactional(readOnly = true)
	@Override
	public ProductType getPtById(Long id) {
		ProductType pt = productTypeDao.getById(id);
		Hibernate.initialize(pt.getAttrs());
		return pt;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductType> getAllPtsNoAttr() {
		return productTypeDao.queryAll();
	}

}
