package com.zz.b2cshop.mall.service;

import java.util.List;

import com.zz.b2cshop.mall.dao.entity.MallSetting;

public interface IMallSettingService {

	public MallSetting getMallSetting(Long mallId, String setting_key);

	public void addMallSetting(MallSetting mallSetting);

	public void updateMallSetting(MallSetting MmllSetting);

	public List<MallSetting> getMallSetting();

	public List<MallSetting> getMallSettingByKey(String setting_key);
}
