package com.zz.b2cshop.admin.privilege.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.google.common.base.Joiner;
import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.privilege.dao.entity.Menu;
import com.zz.b2cshop.privilege.dao.entity.Role;
import com.zz.b2cshop.privilege.dao.entity.Worker;
import com.zz.b2cshop.privilege.service.IMenuService;
import com.zz.b2cshop.privilege.service.IRoleService;
import com.zz.b2cshop.privilege.service.IWorkerService;

@Controller
@ActionController
public class PrivilegeAction extends QAction {

	@Autowired
	private IWorkerService workerService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IMenuService menuService;

	@RequestMapping(value = "showWorkers")
	public Result show() {
		Page page = new Page(1, 10);
		List<Worker> workers = workerService.getWorkers(page);
		setHttpAttribute("workers", workers);

		List<Role> roles = roleService.getAllRole();
		setHttpAttribute("roles", roles);

		return new BaseResult("/template/admin/page/system/showWorkers.vm");
	}

	@RequestMapping(value = "editWorkerPage")
	public Result editWorkerPage() {
		List<Role> roles = roleService.getAllRole();
		setHttpAttribute("roles", roles);
		Long id = getParameterLong("id");
		if (id != null) {
			Worker worker = workerService.getWorkerById(id);
			setHttpAttribute("worker", worker);
		}

		return new BaseResult("/template/admin/page/system/addWorker.vm");
	}

	@RequestMapping(value = "saveWorker")
	public Result saveWorker() {
		String username = getHttpParameter("username");
		String password = getHttpParameter("password");
		String email = getHttpParameter("email");
		Long role_id = getParameterLong("role_id");

		Worker worker = new Worker();
		worker.setUsername(username);
		worker.setPassword(password);
		worker.setEmail(email);
		worker.setRole(new Role(role_id));
		worker.setCreate_ime(new Date());

		Long id = getParameterLong("id");
		if (id == null) {
			Worker other = workerService.getWorkerByName(username);
			if (other != null) {
				return new AjaxResult(500, "用户名已注册", "");
			}
			workerService.addWorker(worker);
		} else {
			worker.setId(id);
			workerService.updateWorker(worker);
		}
		return new AjaxResult();
	}

	@RequestMapping(value="delWorker")
	public Result delWorker() {
		Long id = getParameterLong("id");
		workerService.delWorkerById(id);
		return new AjaxResult();
	}

	@RequestMapping(value = "editRolePage")
	public Result editRolePage() {
		Long id = getParameterLong("id");
		if (id != null) {
			Role role = roleService.getRoleById(id);
			setHttpAttribute("role", role);
		}
		List<Menu> menus = menuService.getMenuListByLevel(1);
		setHttpAttribute("menus", menus);
		return new BaseResult("/template/admin/page/system/editRole.vm");
	}

	@RequestMapping(value = "saveRole")
	public Result saveRole() {
		String name = getHttpParameter("name");
		String[] rights = getHttpParameters("rights");
		Role role = new Role();
		role.setName(name);
		role.setRights(Joiner.on(",").join(rights));

		Long id = getParameterLong("id");
		if (id != null) {
			role.setId(id);
			roleService.updateRole(role);
		} else {
			roleService.addRole(role);
		}
		return new AjaxResult();
	}

}
