package com.zz.b2cshop.product.service;

import com.zz.b2cshop.product.dao.entity.Category;

public interface ICategorySerice {
	
	public Category getCategoryById(Long id);
	
	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void delCategory(Category category);

}
