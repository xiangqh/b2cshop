package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IAdminDao;
import com.zz.b2cshop.privilege.dao.entity.Admin;

/**
 * @author xiangqh
 *
 */
@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	@Override
	public void delAdminById(Long id) {
		adminDao.delAdminById(id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	@Override
	public Admin getAdminById(Long id) {
		return adminDao.getAdminById(id);
	}

	@Override
	public List<Admin> getAdmins(Page page) {
		return adminDao.getAdmins(page);
	}

	@Required
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
