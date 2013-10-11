package com.zz.b2cshop.privilege.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IAdminDao;
import com.zz.b2cshop.privilege.dao.entity.Admin;

/**
 * @author xiangqh
 *
 */
@Repository
public class AdminDaoImpl extends BaseDaoSupport<Admin> implements IAdminDao {

	@Override
	public void addAdmin(Admin admin) {
		super.save(admin);
	}

	@Override
	public void delAdminById(Long id) {
		super.delete(new Admin(id));
	}

	@Override
	public void updateAdmin(Admin admin) {
		super.update(admin);

	}

	@Override
	public Admin getAdminById(Long id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAdmins(Page page) {
		return super.findByCriteria(createDetachedCriteria().addOrder(Order.asc("id")), page);
	}

}
