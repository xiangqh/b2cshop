package com.zz.b2cshop.common.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author xiangqh
 *
 */
public class Generator extends AnnotationBeanNameGenerator {

	@Override
	protected String buildDefaultBeanName(BeanDefinition definition) {
		System.out.println("---------------------"+definition.getBeanClassName());
		return definition.getBeanClassName();
	}
}
