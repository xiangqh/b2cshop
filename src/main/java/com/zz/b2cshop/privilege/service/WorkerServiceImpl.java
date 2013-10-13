package com.zz.b2cshop.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IWorkerDao;
import com.zz.b2cshop.privilege.dao.entity.Worker;

/**
 * @author xiangqh
 *
 */
@Service
public class WorkerServiceImpl implements IWorkerService {

	@Autowired
	private IWorkerDao adminDao;

	@Transactional
	@Override
	public void addAdmin(Worker admin) {
		adminDao.addAdmin(admin);
	}

	@Transactional
	@Override
	public void delAdminById(Long id) {
		adminDao.delAdminById(id);
	}

	@Transactional
	@Override
	public void updateAdmin(Worker admin) {
		adminDao.updateAdmin(admin);
	}

	@Transactional(readOnly = true)
	@Override
	public Worker getAdminById(Long id) {
		return adminDao.getAdminById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Worker> getAdmins(Page page) {
		return adminDao.getAdmins(page);
	}

	@Required
	public void setAdminDao(IWorkerDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Worker getAdminByName(String username) {
		return adminDao.getAdminByName(username);
	}

}
