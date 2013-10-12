package com.zz.b2cshop.common.vm.directive;

import org.zz.qstruts2.views.velocity.directive.ModuleDirective;
import com.zz.b2cshop.common.SpringContextHolder;

/**
 * @author xiangqh
 *
 */
public class MyModuleDirective extends ModuleDirective {

	private static final String MODULE_NAME = "qModuleLoader";

	@Override
	public String getName() {
		return MODULE_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public Object getAction(String moduleName) {
		StringBuffer buffer = new StringBuffer("com.zz.b2cshop.");
		String[] values = moduleName.split("\\.");
		buffer.append(values[1]);
		buffer.append(".action.");
		buffer.append(values[2].substring(0, 1).toUpperCase());
		buffer.append(values[2].substring(1));
		buffer.append("Action");
		return SpringContextHolder.getBean(buffer.toString());
	}

	@Override
	public String getMethodName(String moduleName) {
		return moduleName.substring(moduleName.lastIndexOf(".") + 1);
	}

}
