package com.zz.b2cshop.privilege.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.privilege.dao.IMenuDao;
import com.zz.b2cshop.privilege.dao.entity.Menu;

/**
 * @author xiangqh
 * 
 */
@Repository
public class MenuDaoImpl extends BaseDaoSupport<Menu> implements IMenuDao {

	@Override
	public void addMenu(Menu menu) {
		super.save(menu);
	}

	@Override
	public void delMenu(Long id) {
		super.delete(null);
	}

	@Override
	public void updateMenu(Menu menu) {
		super.update(menu);
	}

	@Override
	public List<Menu> getMenuList() {
		return super.getList();
	}

	@Override
	public List<Menu> getMenuListByPId(Long pId) {
		return super.getList(createDetachedCriteria().add(Restrictions.eq("parent.id", pId)).addOrder(Order.asc("id")));
	}

	@Override
	public Menu getMenuById(Long id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuListByLevel(Integer id) {
		return super.findByCriteria(createDetachedCriteria().add(Restrictions.eq("level", id)));
	}

}
