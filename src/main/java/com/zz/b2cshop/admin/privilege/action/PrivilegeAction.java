package com.zz.b2cshop.admin.privilege.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

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
	private IWorkerService WorkerService;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;

	@RequestMapping(value = "showWorkers")
	public Result show() {
		Page page = new Page(0, 10);
		List<Worker> Workers = WorkerService.getWorkers(page);
		setHttpAttribute("Workers", Workers);

		return new BaseResult("/template/admin/page/system/showWorkers.vm");
	}

	@RequestMapping(value="addWorkerPage")
	public Result addWorkerPage() {
		List<Role> roles = roleService.getAllRole();
		setHttpAttribute("roles", roles);

		return new BaseResult("/template/Worker/page/addWorker.vm");
	}

	public Result addWorker() {
		String username = getHttpParameter("username");
		String password = getHttpParameter("password");
		String email = getHttpParameter("email");
		Long role_id = getParameterLong("roleId");

		Worker Worker = WorkerService.getWorkerByName(username);
		if (Worker == null) {
			return new AjaxResult(500, "用户名已注册", "");
		}
		Worker = new Worker();
		Worker.setUsername(username);
		Worker.setPassword(password);
		Worker.setEmail(email);
		Worker.setRole(new Role(role_id));
		Worker.setCreate_ime(new Date());
		WorkerService.addWorker(Worker);

		return new AjaxResult(200,"");
	}

	public Result editWorkerPage() {
		List<Role> roles = roleService.getAllRole();
		setHttpAttribute("roles", roles);

		return new BaseResult("/template/Worker/page/addWorker.vm");
	}

	public Result updateWorker(){
		Long id = getParameterLong("id");
		String username = getHttpParameter("username");
		String password = getHttpParameter("password");
		String email = getHttpParameter("email");
		Long role_id = getParameterLong("roleId");

		Worker Worker = WorkerService.getWorkerByName(username);
		if (Worker == null) {
			return new AjaxResult(500, "用户名已注册", "");
		}
		Worker = new Worker();
		Worker.setId(id);
		Worker.setPassword(password);
		Worker.setEmail(email);
		Worker.setRole(new Role(role_id));
		Worker.setCreate_ime(new Date());
		WorkerService.updateWorker(Worker);

		return new AjaxResult(200,"");

	}

	public Result delWorker() {
		Long id = getParameterLong("id");
		WorkerService.delWorkerById(id);
		return new AjaxResult();
	}
	
	@RequestMapping(value="addRolePage")
	public Result addRolePage(){
		List<Menu> menus = menuService.getMenuListByLevel(1);
		/*for(Menu menu : menus) {
			List<Menu> childrens =  menuService.getMenuListByPId(menu.getId());
			menu.setChildrens(childrens);
		}*/
		setHttpAttribute("menus", menus);
		return new BaseResult("/template/admin/page/system/addRole.vm");
	}

}
