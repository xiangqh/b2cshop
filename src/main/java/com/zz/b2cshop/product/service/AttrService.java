package com.zz.b2cshop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.entity.Attr;

@Service
public class AttrService implements IAttrService {

	@Autowired
	private IAttrDao attrDao;

	@Override
	public void addBrandAttr(Attr brandAttr) {
		attrDao.addBrandAttr(brandAttr);
	}

	@Override
	public void updateBrandAttr(Attr brandAttr) {
		attrDao.updateBrandAttr(brandAttr);
	}

	@Override
	public void delBrandAttr(Attr brandAttr) {
		attrDao.delBrandAttr(brandAttr);
	}

	@Override
	public List<Attr> getAllBrandAttrs() {
		return attrDao.getAllBrandAttrs();
	}

	@Override
	public List<Attr> getBrandAttrs(Page page) {
		return attrDao.getBrandAttrs(page);
	}

}
