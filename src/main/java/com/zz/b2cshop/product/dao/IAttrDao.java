package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.entity.Attr;

public interface IAttrDao {

	public void addBrandAttr(Attr brandAttr);

	public void updateBrandAttr(Attr brandAttr);

	public void delBrandAttr(Attr brandAttr);

	public List<Attr> getAllBrandAttrs();

	public List<Attr> getBrandAttrs(Page page);

}
