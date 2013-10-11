package com.zz.b2cshop.admin.privilege.action;

import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.BaseResult;

@Controller
@ActionController
public class AdminAction extends QAction {

	@RequestMapping(value = "showAdmins")
	public Result show() {

		return new BaseResult("/template/admin/page/system/showAdmins.vm");
	}

}
