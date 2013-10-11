/**
 *
 */
package com.zz.b2cshop.common.dao;

import java.util.List;

/**
 * @author xiangqh
 *
 */
public interface PODao<T> {

	void save(T t);

	void update(T t);

	void saveOrUpdate(T t);

	void delete(T t);

	T getById(Long id);

	List<T> queryAll();
}
