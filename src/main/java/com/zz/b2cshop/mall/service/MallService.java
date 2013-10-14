package com.zz.b2cshop.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.mall.dao.IMallDao;
import com.zz.b2cshop.mall.dao.entity.Mall;

@Service
public class MallService implements IMallService {

	@Autowired
	private IMallDao mallDao;

	@Transactional
	@Override
	public void addMall(Mall mall) {
		mallDao.addMall(mall);
	}

	@Transactional(readOnly = true)
	@Override
	public Mall getMallById(Long id) {
		return mallDao.getMallById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Mall getMallByUrl(String url) {
		return mallDao.getMallByUrl(url);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Mall> getMallList() {
		return mallDao.getMallList();
	}

	@Transactional
	@Override
	public void updateMall(Mall mall) {
		mallDao.updateMall(mall);
	}

}
