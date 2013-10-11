package com.zz.b2cshop.privilege.service;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Admin;

/**
 * @author xiangqh
 *
 */
public interface IAdminService {

	public void addAdmin(Admin admin);

	public void delAdminById(Long id);

	public void updateAdmin(Admin admin);

	public Admin getAdminById(Long id);

	public List<Admin> getAdmins(Page page);
}
