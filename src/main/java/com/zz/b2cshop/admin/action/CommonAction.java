package com.zz.b2cshop.admin.action;

import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.InternalContextAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.zz.b2cshop.common.ModuleAction;
import com.zz.b2cshop.privilege.dao.entity.Menu;
import com.zz.b2cshop.privilege.service.IMenuService;

/**
 * @author xiangqh
 *
 */
@Component
public class CommonAction implements ModuleAction {

	@Autowired
	private IMenuService menuService;

	@Override
	public void head(InternalContextAdapter ctxAdapter, Map<String, String> params, VelocityContext context) {
		System.out.println("head---------");
		Long level = Long.valueOf(params.get("level1").toString());
		Long level2 = Long.valueOf(params.get("level2").toString());
		Menu menu = menuService.getMenuById(0l);

	//	context.put("menuList", menuList);
	}

	@Override
	public void foot(InternalContextAdapter ctxAdapter, Map<String, String> params, VelocityContext context) {

	}

	@Required
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

}
