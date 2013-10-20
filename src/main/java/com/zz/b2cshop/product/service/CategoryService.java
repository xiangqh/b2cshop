package com.zz.b2cshop.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.b2cshop.product.dao.ICategoryDao;
import com.zz.b2cshop.product.dao.entity.Category;

@Service
public class CategoryService implements ICategorySerice {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public void addCategory(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delCategory(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryDao.getById(id);
	}

}
