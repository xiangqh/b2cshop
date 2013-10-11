package com.zz.b2cshop.common;

import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.InternalContextAdapter;

/**
 * @author xiangqh
 *
 */
public interface ModuleAction {

	void head(InternalContextAdapter ctxAdapter, Map<String, String> params, VelocityContext context);

	void foot(InternalContextAdapter ctxAdapter, Map<String, String> params, VelocityContext context);

}
