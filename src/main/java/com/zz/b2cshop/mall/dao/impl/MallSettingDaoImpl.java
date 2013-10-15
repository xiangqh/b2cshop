package com.zz.b2cshop.mall.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zz.b2cshop.common.dao.BaseDaoSupport;
import com.zz.b2cshop.mall.dao.IMallSettingDao;
import com.zz.b2cshop.mall.dao.entity.MallSetting;

@Repository
public class MallSettingDaoImpl extends BaseDaoSupport<MallSetting> implements IMallSettingDao {

	@Override
	public void addMallSetting(MallSetting mallSetting) {
		super.save(mallSetting);
	}

	@Override
	public void updateMallSetting(MallSetting MmllSetting) {
		super.update(MmllSetting);
	}

	@Override
	public List<MallSetting> getMallSetting() {
		return super.getList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MallSetting> getMallSettingByKey(String setting_key) {
		return super.findByCriteria(createDetachedCriteria().add(Restrictions.eq("setting_key", setting_key)));
	}

	@Override
	public MallSetting getMallSetting(Long mall_id, String setting_key) {
		return (MallSetting) super.findUniqueResultByCriteria(createDetachedCriteria().add(Restrictions.eq("mall_id", mall_id)).add(
				Restrictions.eq("setting_key", setting_key)));
	}
}
