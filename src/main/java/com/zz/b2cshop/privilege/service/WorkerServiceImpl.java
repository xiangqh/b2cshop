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
	private IWorkerDao WorkerDao;

	@Transactional
	@Override
	public void addWorker(Worker Worker) {
		WorkerDao.addWorker(Worker);
	}

	@Transactional
	@Override
	public void delWorkerById(Long id) {
		WorkerDao.delWorkerById(id);
	}

	@Transactional
	@Override
	public void updateWorker(Worker Worker) {
		WorkerDao.updateWorker(Worker);
	}

	@Transactional(readOnly = true)
	@Override
	public Worker getWorkerById(Long id) {
		return WorkerDao.getWorkerById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Worker> getWorkers(Page page) {
		return WorkerDao.getWorkers(page);
	}

	@Required
	public void setWorkerDao(IWorkerDao WorkerDao) {
		this.WorkerDao = WorkerDao;
	}

	@Override
	public Worker getWorkerByName(String username) {
		return WorkerDao.getWorkerByName(username);
	}

}
