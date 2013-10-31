package com.zz.b2cshop.product.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.product.dao.entity.Goods;

public interface IGoodsService {

	public void saveGoods(Goods goods);

	public void updateGoods(Goods goods);

	public void delGoods(Goods goods);

	public Goods getGoodsById(Long id);

	public List<Goods> getAllGoods();

	public List<Goods> searchGoods(Page page);

}
