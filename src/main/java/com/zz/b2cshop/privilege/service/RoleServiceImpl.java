package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IRoleDao;
import com.zz.b2cshop.privilege.dao.entity.Role;

/**
 * @author xiangqh
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Transactional
	@Override
	public void addAdminRole(Role role) {
		roleDao.addAdminRole(role);
	}

	@Transactional
	@Override
	public void delAdminRoleById(Long id) {
		roleDao.delAdminRoleById(id);
	}

	@Transactional
	@Override
	public void updateAdminRole(Role role) {
		roleDao.updateAdminRole(role);
	}

	@Transactional(readOnly = true)
	@Override
	public Role getAdminRoleById(Long id) {
		return roleDao.getAdminRoleById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Role> getAdminRoles(Page page) {
		return roleDao.getAdminRoles(page);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Role> getAllAdminRole() {
		return roleDao.getAllAdminRole();
	}

	@Required
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
