package com.zz.b2cshop.privilege.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.IWorkerDao;
import com.zz.b2cshop.privilege.dao.entity.Worker;

/**
 * @author xiangqh
 *
 */
@Repository
public class WorkerDaoImpl extends BaseDaoSupport<Worker> implements IWorkerDao {

	@Override
	public void addWorker(Worker Worker) {
		super.save(Worker);
	}

	@Override
	public void delWorkerById(Long id) {
		Worker Worker = new Worker();
		Worker.setId(id);
		super.delete(Worker);
	}

	@Override
	public void updateWorker(Worker Worker) {
		super.update(Worker);

	}

	@Override
	public Worker getWorkerById(Long id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> getWorkers(Page page) {
		return super.findByCriteria(createDetachedCriteria().addOrder(Order.asc("id")), page);
	}

	@Override
	public Worker getWorkerByName(String username) {
		return (Worker) super.findUniqueResultByCriteria(createDetachedCriteria().add(
				Restrictions.eq("username", username)));
	}

}
