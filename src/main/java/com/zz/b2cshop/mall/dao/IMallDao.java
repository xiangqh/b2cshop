package com.zz.b2cshop.mall.dao;

import java.util.List;

import com.zz.b2cshop.mall.dao.entity.Mall;

public interface IMallDao {

	public void addMall(Mall mall);

	public Mall getMallById(Long id);

	public Mall getMallByUrl(String url);

	public List<Mall> getMallList();

	public void updateMall(Mall mall);

}
