package com.zz.b2cshop.product.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.IGoodsDao;
import com.zz.b2cshop.product.dao.entity.Goods;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;

	@Transactional
	@Override
	public void saveGoods(Goods goods) {
		goodsDao.save(goods);
	}

	@Transactional
	@Override
	public void updateGoods(Goods goods) {
		goodsDao.update(goods);
	}

	@Transactional
	@Override
	public void delGoods(Goods goods) {
		goodsDao.delete(goods);
	}

	@Transactional(readOnly = true)
	@Override
	public Goods getGoodsById(Long id) {
		Goods goods = goodsDao.getById(id);
		Hibernate.initialize(goods.getCategory());
		return goods;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Goods> getAllGoods() {
		List<Goods> list = goodsDao.queryAll();
		for (Goods goods : list) {
			Hibernate.initialize(goods.getBrand());
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Goods> searchGoods(Page page) {
		return null;
	}

}
