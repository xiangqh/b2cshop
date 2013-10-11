package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zz.b2cshop.privilege.dao.IMenuDao;
import com.zz.b2cshop.privilege.dao.entity.Menu;

/**
 * @author xiangqh
 *
 */
@Service
public class MenuServiceImpl implements IMenuService {

	private IMenuDao menuDao;

	@Override
	public List<Menu> getMenuList() {
		return menuDao.getMenuList();
	}

	@Override
	public List<Menu> getMenuListByPId(Long pId) {
		return menuDao.getMenuListByPId(pId);
	}

	@Override
	public Menu getMenuById(Long id) {
		return menuDao.getMenuById(id);
	}

	@Override
	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);

	}

	@Override
	public void delMenu(Long id) {
		menuDao.delMenu(id);

	}

	@Override
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);

	}

}
