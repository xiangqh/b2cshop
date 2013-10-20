package com.zz.b2cshop.product.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.PODao;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Category;

public interface ICategoryDao extends PODao<Category> {
	
	public List<Category> getList(Page page);
	
	public List<Category> getChildsByPId(Long id);

}
