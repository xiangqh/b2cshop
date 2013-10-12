package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	@Transactional
	@Override
	public void delAdminById(Long id) {
		adminDao.delAdminById(id);
	}

	@Transactional
	@Override
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin getAdminById(Long id) {
		return adminDao.getAdminById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Admin> getAdmins(Page page) {
		return adminDao.getAdmins(page);
	}

	@Required
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin getAdminByName(String username) {
		return adminDao.getAdminByName(username);
	}

}
