package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.privilege.dao.IMenuDao;
import com.zz.b2cshop.privilege.dao.entity.Menu;

/**
 * @author xiangqh
 *
 */
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	@Transactional(readOnly = true)
	@Override
	public List<Menu> getMenuList() {
		return menuDao.getMenuList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Menu> getMenuListByPId(Long pId) {
		return menuDao.getMenuListByPId(pId);
	}

	@Transactional(readOnly = true)
	@Override
	public Menu getMenuById(Long id) {
		return menuDao.getMenuById(id);
	}

	@Transactional
	@Override
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);

	}

	@Transactional
	@Override
	public void delMenu(Long id) {
		menuDao.delMenu(id);

	}

	@Transactional
	@Override
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Menu> getMenuListByLevel(Integer id) {
		return menuDao.getMenuListByLevel(id);
	}

}
