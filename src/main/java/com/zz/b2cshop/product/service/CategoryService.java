package com.zz.b2cshop.product.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.product.dao.ICategoryDao;
import com.zz.b2cshop.product.dao.entity.Category;

@Service
public class CategoryService implements ICategorySerice {

	@Autowired
	private ICategoryDao categoryDao;

	@Transactional
	@Override
	public void addCategory(Category category) {
		categoryDao.save(category);
	}

	@Transactional
	@Override
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Transactional
	@Override
	public void delCategory(Category category) {
		categoryDao.delete(category);
	}

	@Transactional(readOnly = true)
	@Override
	public Category getCategoryById(Long id) {
		Category category = categoryDao.getById(id);
		Hibernate.initialize(category.getChilds());
		Hibernate.initialize(category.getPt());
		return category;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> getAllCategory() {
		return categoryDao.queryAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> getCategorysByPId(Long id) {
		List<Category> list = categoryDao.getChildsByPId(id);
		initializeList(list);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> getLevelFCatetegory() {
		List<Category> list = categoryDao.getLevelFCatetegory();
		initializeList(list);
		return list;
	}

	private void initializeList(List<Category> list) {
		for (Category category : list) {
			Hibernate.initialize(category.getChilds());
			Hibernate.initialize(category.getPt());
			if (CollectionUtils.isNotEmpty(category.getChilds())) {
				for (Category child : category.getChilds()) {
					Hibernate.initialize(child.getParent());
					Hibernate.initialize(child.getChilds());
					Hibernate.initialize(child.getPt());
				}
			}
		}
	}

}
