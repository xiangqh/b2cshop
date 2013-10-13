package com.zz.b2cshop.privilege.dao;

import java.util.List;

import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Worker;

/**
 * @author xiangqh
 *
 */
public interface IWorkerDao {

	public Worker getAdminByName(String username);

	public void addAdmin(Worker admin);

	public void delAdminById(Long id);

	public void updateAdmin(Worker admin);

	public Worker getAdminById(Long id);

	public List<Worker> getAdmins(Page page);
}
