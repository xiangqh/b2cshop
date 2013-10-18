package com.zz.b2cshop.product.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Attr;
import com.zz.b2cshop.product.dao.entity.ProductType;

public interface IAttrService {
	
	public void saveAll(List<Attr> list);

	public void addPtAttr(Attr attr);

	public void updatePtAttr(Attr attr);

	public void delPtAttr(Attr attr);

	public List<Attr> getAllAttrs();

	public List<Attr> getAttrs(Page page);
}
