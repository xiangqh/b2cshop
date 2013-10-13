package com.zz.b2cshop.privilege.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Worker;

/**
 * @author xiangqh
 *
 */
public interface IWorkerDao {

	public Worker getWorkerByName(String username);

	public void addWorker(Worker Worker);

	public void delWorkerById(Long id);

	public void updateWorker(Worker Worker);

	public Worker getWorkerById(Long id);

	public List<Worker> getWorkers(Page page);
}
