package com.zz.b2cshop.common.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.common.IEntity;
import com.zz.b2cshop.common.PO;

/**
 * @author xiangqh
 *
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:D:/workspace/b2cshop/web/WEB-INF/config/application.hibernate.xml",
		"file:D:/workspace/b2cshop/web/WEB-INF/config/application.xml" })
@TransactionConfiguration(defaultRollback = true)
public abstract class BaseDaoTestSupport<T extends PO> {


}
