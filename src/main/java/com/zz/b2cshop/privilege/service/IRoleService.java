package com.zz.b2cshop.privilege.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Role;

/**
 * @author xiangqh
 *
 */
public interface IRoleService {

	public void addRole(Role role);

	public void delRoleById(Long id);

	public void updateRole(Role role);

	public Role getRoleById(Long id);

	public List<Role> getRoles(Page page);

	public List<Role> getAllRole();
}
