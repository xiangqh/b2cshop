package com.zz.b2cshop.privilege.dao;

import java.util.List;

import com.zz.b2cshop.privilege.dao.entity.Menu;

/**
 * @author xiangqh
 *
 */
public interface IMenuDao {

	public void addMenu(Menu menu);

	public void delMenu(Long id);

	public void updateMenu(Menu menu);

	public List<Menu> getMenuList();

	public List<Menu> getMenuListByPId(Long pId);

	public Menu getMenuById(Long id);
}
