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
	public void addAdmin(Worker admin) {
		super.save(admin);
	}

	@Override
	public void delAdminById(Long id) {
		Worker admin = new Worker();
		admin.setId(id);
		super.delete(admin);
	}

	@Override
	public void updateAdmin(Worker admin) {
		super.update(admin);

	}

	@Override
	public Worker getAdminById(Long id) {
		return super.getById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Worker> getAdmins(Page page) {
		return super.findByCriteria(createDetachedCriteria().addOrder(Order.asc("id")), page);
	}

	@Override
	public Worker getAdminByName(String username) {
		return (Worker) super.findUniqueResultByCriteria(createDetachedCriteria().add(
				Restrictions.eq("username", username)));
	}

}
