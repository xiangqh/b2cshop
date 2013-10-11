package com.zz.b2cshop.privilege.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IRoleDao;
import com.zz.b2cshop.privilege.dao.entity.Role;

/**
 * @author xiangqh
 *
 */
@Repository
public class RoleDaoImpl extends BaseDaoSupport<Role> implements IRoleDao {

	@Override
	public void addAdminRole(Role role) {
		super.save(role);
	}

	@Override
	public void delAdminRoleById(Long id) {
		super.delete(new Role(id));
	}

	@Override
	public void updateAdminRole(Role role) {
		super.update(role);
	}

	@Override
	public Role getAdminRoleById(Long id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAdminRoles(Page page) {
		return super.findByCriteria(createDetachedCriteria().addOrder(Order.asc("id")), page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllAdminRole() {
		return super.findByCriteria(createDetachedCriteria());
	}

}
