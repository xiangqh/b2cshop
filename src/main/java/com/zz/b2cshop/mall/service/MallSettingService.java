package com.zz.b2cshop.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.b2cshop.mall.dao.IMallSettingDao;
import com.zz.b2cshop.mall.dao.entity.MallSetting;

@Service
public class MallSettingService implements IMallSettingService {

	@Autowired
	private IMallSettingDao mallSettingDao;
	
	@Transactional
	@Override
	public void addMallSetting(MallSetting mallSetting) {
		mallSettingDao.addMallSetting(mallSetting);
	}

	@Transactional
	@Override
	public void updateMallSetting(MallSetting MmllSetting) {
		mallSettingDao.updateMallSetting(MmllSetting);
	}

	@Transactional(readOnly = true)
	@Override
	public List<MallSetting> getMallSetting() {
		return mallSettingDao.getMallSetting();
	}

	@Transactional(readOnly=true)
	@Override
	public List<MallSetting> getMallSettingByKey(String setting_key) {
		return mallSettingDao.getMallSettingByKey(setting_key);
	}

}
