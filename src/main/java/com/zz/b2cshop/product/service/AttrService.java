package com.zz.b2cshop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.entity.ProductType;

@Service
public class AttrService implements IAttrService {

	@Autowired
	private IAttrDao attrDao;

	@Override
	public void addBrandAttr(ProductType brandAttr) {
		attrDao.addBrandAttr(brandAttr);
	}

	@Override
	public void updateBrandAttr(ProductType brandAttr) {
		attrDao.updateBrandAttr(brandAttr);
	}

	@Override
	public void delBrandAttr(ProductType brandAttr) {
		attrDao.delBrandAttr(brandAttr);
	}

	@Override
	public List<ProductType> getAllBrandAttrs() {
		return attrDao.getAllBrandAttrs();
	}

	@Override
	public List<ProductType> getBrandAttrs(Page page) {
		return attrDao.getBrandAttrs(page);
	}

}
