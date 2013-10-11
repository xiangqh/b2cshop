package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IRoleDao;
import com.zz.b2cshop.privilege.dao.entity.Role;

/**
 * @author xiangqh
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	private IRoleDao roleDao;

	@Override
	public void addAdminRole(Role role) {
		roleDao.addAdminRole(role);
	}

	@Override
	public void delAdminRoleById(Long id) {
		roleDao.delAdminRoleById(id);
	}

	@Override
	public void updateAdminRole(Role role) {
		roleDao.updateAdminRole(role);
	}

	@Override
	public Role getAdminRoleById(Long id) {
		return roleDao.getAdminRoleById(id);
	}

	@Override
	public List<Role> getAdminRoles(Page page) {
		return roleDao.getAdminRoles(page);
	}

	@Override
	public List<Role> getAllAdminRole() {
		return roleDao.getAllAdminRole();
	}

	@Required
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
