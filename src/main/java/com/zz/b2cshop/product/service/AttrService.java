package com.zz.b2cshop.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IAttrDao;
import com.zz.b2cshop.product.dao.entity.Attr;

@Service
public class AttrService implements IAttrService {

	@Autowired
	private IAttrDao attrDao;

	@Transactional
	@Override
	public void addPtAttr(Attr attr) {
		attrDao.save(attr);
	}

	@Transactional
	@Override
	public void updatePtAttr(Attr attr) {
		attrDao.update(attr);
	}

	@Transactional
	@Override
	public void delPtAttr(Attr attr) {
		attrDao.delete(attr);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Attr> getAllAttrs() {
		return attrDao.queryAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Attr> getAttrs(Page page) {
		return attrDao.getAttrs(page);
	}

	@Override
	public void saveAll(List<Attr> list) {
		attrDao.saveAll(list);
	}

}
