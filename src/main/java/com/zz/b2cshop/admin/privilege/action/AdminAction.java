package com.zz.b2cshop.admin.privilege.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.common.JsonResult;
import com.zz.b2cshop.common.dao.Page;
import com.zz.b2cshop.common.util.JsonBinder;
import com.zz.b2cshop.privilege.dao.IRoleDao;
import com.zz.b2cshop.privilege.dao.entity.Admin;
import com.zz.b2cshop.privilege.dao.entity.Role;
import com.zz.b2cshop.privilege.service.IAdminService;
import com.zz.b2cshop.privilege.service.IRoleService;

@Controller
@ActionController
public class AdminAction extends QAction {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IRoleService roleService;

	@RequestMapping(value = "showAdmins")
	public Result show() {
		Page page = new Page(0, 10);
		List<Admin> admins = adminService.getAdmins(page);
		setHttpAttribute("admins", admins);

		return new BaseResult("/template/admin/page/system/showAdmins.vm");
	}

	public Result addAdminPage() {
		List<Role> roles = roleService.getAllAdminRole();
		setHttpAttribute("roles", roles);

		return new BaseResult("/template/admin/page/addAdmin.vm");
	}

	public Result addAdmin() {
		String username = getHttpParameter("username");
		String password = getHttpParameter("password");
		String email = getHttpParameter("email");
		Long role_id = getParameterLong("roleId");

		Admin admin = adminService.getAdminByName(username);
		if (admin == null) {
			return new AjaxResult(500, "用户名已注册", "");
		}
		admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setEmail(email);
		admin.setRole(new Role(role_id));
		admin.setCreate_ime(new Date());
		adminService.addAdmin(admin);

		return new AjaxResult(200,"");
	}

	public Result editAdminPage() {
		List<Role> roles = roleService.getAllAdminRole();
		setHttpAttribute("roles", roles);

		return new BaseResult("/template/admin/page/addAdmin.vm");
	}

	public Result updateAdmin(){
		Long id = getParameterLong("id");
		String username = getHttpParameter("username");
		String password = getHttpParameter("password");
		String email = getHttpParameter("email");
		Long role_id = getParameterLong("roleId");

		Admin admin = adminService.getAdminByName(username);
		if (admin == null) {
			return new AjaxResult(500, "用户名已注册", "");
		}
		admin = new Admin();
		admin.setId(id);
		admin.setPassword(password);
		admin.setEmail(email);
		admin.setRole(new Role(role_id));
		admin.setCreate_ime(new Date());
		adminService.updateAdmin(admin);

		return new AjaxResult(200,"");

	}

	public Result delAdmin() {
		Long id = getParameterLong("id");
		adminService.delAdminById(id);
		return new AjaxResult();
	}

}
