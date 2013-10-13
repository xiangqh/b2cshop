package com.zz.b2cshop.privilege.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.b2cshop.common.dao.BaseDaoTestSupport;
import com.zz.b2cshop.privilege.dao.entity.Menu;

/**
 * @author xiangqh
 *
 */
public class MenuDaoTest extends BaseDaoTestSupport<Menu> {

	@Autowired
	protected IWorkerDao adminDao;
	@Autowired
	protected IRoleDao roleDao;
	@Autowired
	protected IMenuDao menuDao;

	@Test
	public void ss(){
		List<Menu> menuList = menuDao.getMenuListByPId(0l);
		for(Menu menu : menuList) {
			System.out.println(menu.getName());
		}
	}
}
