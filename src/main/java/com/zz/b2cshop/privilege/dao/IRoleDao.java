package com.zz.b2cshop.privilege.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Role;

/**
 * @author xiangqh
 *
 */
public interface IRoleDao {

	public void addAdminRole(Role role);

	public void delAdminRoleById(Long id);

	public void updateAdminRole(Role role);

	public Role getAdminRoleById(Long id);

	public List<Role> getAdminRoles(Page page);

	public List<Role> getAllAdminRole();
}
