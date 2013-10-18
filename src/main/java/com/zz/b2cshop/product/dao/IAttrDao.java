package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.PODao;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Attr;

public interface IAttrDao extends PODao<Attr>{

	public List<Attr> getAttrs(Page page);

}
