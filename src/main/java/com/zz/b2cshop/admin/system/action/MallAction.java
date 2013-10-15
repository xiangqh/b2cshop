package com.zz.b2cshop.admin.system.action;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.common.util.JsonBinder;
import com.zz.b2cshop.mall.dao.entity.Mall;
import com.zz.b2cshop.mall.dao.entity.MallSetting;
import com.zz.b2cshop.mall.model.GoodsOptionBean;
import com.zz.b2cshop.mall.model.ImageBean;
import com.zz.b2cshop.mall.model.ImageSettingBean;
import com.zz.b2cshop.mall.model.MailBean;
import com.zz.b2cshop.mall.model.PaySetBean;
import com.zz.b2cshop.mall.model.ShipBean;
import com.zz.b2cshop.mall.service.IMallService;
import com.zz.b2cshop.mall.service.IMallSettingService;

@ActionController
@Controller
public class MallAction extends QAction {

	@Autowired
	private IMallService mallService;

	@Autowired
	private IMallSettingService mallSettingService;

	@RequestMapping(value = "showMallInfo")
	public Result showMallInfo() {
		Mall mall = mallService.getMallById(1l);
		setHttpAttribute("mall", mall);
		return new BaseResult("/template/admin/page/system/mallInfo.vm");
	}

	@RequestMapping(value = "saveMallInfo")
	public Result saveMallInfo() {
		Mall mall = getMall();
		if (mall.getId() != null) {
			mallService.updateMall(mall);
		} else {
			mallService.addMall(mall);
		}

		return new AjaxResult();
	}

	@RequestMapping(value = "showImageSetting")
	public Result showImageSetting() {
		MallSetting mallSetting = mallSettingService.getMallSetting(1l, "image_setting");
		String json = mallSetting.getSetting_value();
		ImageSettingBean settingBean = JsonBinder.buildNonNullBinder().fromJson(json, ImageSettingBean.class);
		setHttpAttribute("imageSet", settingBean);
		setHttpAttribute("mallSetting", mallSetting);
		return new BaseResult("/template/admin/page/system/imageSetting.vm");
	}

	@RequestMapping(value = "saveImageSetting")
	public Result saveImageSetting() {
		Long id = getParameterLong("id");
		ImageSettingBean imageSetting = getImageSetting();
		MallSetting setting = new MallSetting();
		setting.setId(id);
		setting.setMall_id(1l);
		setting.setSetting_key("image_setting");
		setting.setSetting_value(JsonBinder.buildNonNullBinder().toJson(imageSetting));
		mallSettingService.updateMallSetting(setting);

		return new AjaxResult();
	}

	@RequestMapping(value = "showMailSetting")
	public Result showMailSetting() {
		MallSetting mallSetting = mallSettingService.getMallSetting(1l, "mail_setting");
		String json = mallSetting.getSetting_value();
		MailBean settingBean = JsonBinder.buildNonNullBinder().fromJson(json, MailBean.class);
		setHttpAttribute("mailSet", settingBean);
		setHttpAttribute("mallSetting", mallSetting);
		return new BaseResult("/template/admin/page/system/mailSetting.vm");
	}

	@RequestMapping(value = "saveMailSetting")
	public Result saveMailSetting() {
		Long id = getParameterLong("id");
		MailBean mailSetting = getMailSetting();
		MallSetting setting = new MallSetting();
		setting.setId(id);
		setting.setMall_id(1l);
		setting.setSetting_key("mail_setting");
		setting.setSetting_value(JsonBinder.buildNonNullBinder().toJson(mailSetting));
		mallSettingService.updateMallSetting(setting);

		return new AjaxResult();
	}

	@RequestMapping(value = "showGoodsSetting")
	public Result showGoodsSetting() {
		MallSetting mallSetting = mallSettingService.getMallSetting(1l, "goods_setting");
		String json = mallSetting.getSetting_value();
		GoodsOptionBean settingBean = JsonBinder.buildNonNullBinder().fromJson(json, GoodsOptionBean.class);
		setHttpAttribute("goodsSet", settingBean);
		setHttpAttribute("mallSetting", mallSetting);
		return new BaseResult("/template/admin/page/system/goodsSetting.vm");
	}

	@RequestMapping(value = "saveGoodsSetting")
	public Result saveGoodsSetting() {
		Long id = getParameterLong("id");
		GoodsOptionBean goodsSetting = getGoodsSetting();
		MallSetting setting = new MallSetting();
		setting.setId(id);
		setting.setMall_id(1l);
		setting.setSetting_key("goods_setting");
		setting.setSetting_value(JsonBinder.buildNonNullBinder().toJson(goodsSetting));
		mallSettingService.updateMallSetting(setting);

		return new AjaxResult();
	}

	@RequestMapping(value = "showPaySetting")
	public Result showPaySetting() {
		MallSetting mallSetting = mallSettingService.getMallSetting(1l, "pay_setting");
		String json = mallSetting.getSetting_value();
		PaySetBean settingBean = JsonBinder.buildNonNullBinder().fromJson(json, PaySetBean.class);
		setHttpAttribute("paySet", settingBean);
		setHttpAttribute("mallSetting", mallSetting);
		return new BaseResult("/template/admin/page/system/paySetting.vm");
	}

	@RequestMapping(value = "savePaySetting")
	public Result savePaySetting() {
		Long id = getParameterLong("id");
		PaySetBean paySetting = getPaySetting();
		MallSetting setting = new MallSetting();
		setting.setId(id);
		setting.setMall_id(1l);
		setting.setSetting_key("pay_setting");
		setting.setSetting_value(JsonBinder.buildNonNullBinder().toJson(paySetting));
		mallSettingService.updateMallSetting(setting);

		return new AjaxResult();
	}

	@RequestMapping(value = "showShipSetting")
	public Result showShipSetting() {
		MallSetting mallSetting = mallSettingService.getMallSetting(1l, "pay_setting");
		String json = mallSetting.getSetting_value();
		ShipBean settingBean = JsonBinder.buildNonNullBinder().fromJson(json, ShipBean.class);
		setHttpAttribute("shipSet", settingBean);
		setHttpAttribute("mallSetting", mallSetting);
		return new BaseResult("/template/admin/page/system/shipSetting.vm");
	}

	@RequestMapping(value = "saveShipSetting")
	public Result saveShipSetting() {
		Long id = getParameterLong("id");
		ShipBean shipBean = getShipBean();
		MallSetting setting = new MallSetting();
		setting.setId(id);
		setting.setMall_id(1l);
		setting.setSetting_key("ship_setting");
		setting.setSetting_value(JsonBinder.buildNonNullBinder().toJson(shipBean));
		mallSettingService.updateMallSetting(setting);

		return new AjaxResult();
	}

	private ShipBean getShipBean() {
		BigDecimal fastPost = getParameterPrice("fastPost");
		BigDecimal slowPost = getParameterPrice("slowPost");
		BigDecimal ems = getParameterPrice("ems");
		return new ShipBean(fastPost, slowPost, ems);
	}

	private PaySetBean getPaySetting() {
		PaySetBean bean = new PaySetBean();
		bean.setDelivery(getHttpParameter("cash"));
		bean.setArr_delivery(getHttpParameters("cashPay"));
		bean.setBank_transfer(getHttpParameter("bank"));
		bean.setArr_bank(getHttpParameters("bankPay"));
		bean.setOnline_payment(getHttpParameter("online"));
		bean.setArr_online(getHttpParameters("onlinePay"));
		bean.setRemittance(getHttpParameter("post"));
		bean.setArr_remit(getHttpParameters("postPay"));
		return bean;
	}

	private GoodsOptionBean getGoodsSetting() {
		int can_shelves = getParameterInt("can_shelves");
		int shelves_on = getParameterInt("shelves_on");
		int stock0_buy = getParameterInt("stock0_buy");
		return new GoodsOptionBean(can_shelves, shelves_on, stock0_buy);
	}

	private ImageSettingBean getImageSetting() {
		int img_1_w = getParameterInt("img_1_w");
		int img_1_h = getParameterInt("img_1_h");
		int img_2_w = getParameterInt("img_2_w");
		int img_2_h = getParameterInt("img_2_h");
		int img_3_w = getParameterInt("img_3_w");
		int img_3_h = getParameterInt("img_3_h");
		int img_4_w = getParameterInt("img_4_w");
		int img_4_h = getParameterInt("img_4_h");
		int img_5_w = getParameterInt("img_5_w");
		int img_5_h = getParameterInt("img_5_h");

		ImageSettingBean imageSettingBean = new ImageSettingBean();
		imageSettingBean.setImg1(new ImageBean(img_1_w, img_1_h));
		imageSettingBean.setImg2(new ImageBean(img_2_w, img_2_h));
		imageSettingBean.setImg3(new ImageBean(img_3_w, img_3_h));
		imageSettingBean.setImg4(new ImageBean(img_4_w, img_4_h));
		imageSettingBean.setImg5(new ImageBean(img_5_w, img_5_h));
		return imageSettingBean;
	}

	private MailBean getMailSetting() {
		String smtpServer = getHttpParameter("smtpServer");
		String email = getHttpParameter("email");
		String pwd = getHttpParameter("pwd");
		int isCheck = getParameterInt("isCheck");

		MailBean bean = new MailBean();
		bean.setEmail(email);
		bean.setIsCheck(isCheck);
		bean.setPwd(pwd);
		bean.setSmtpServer(smtpServer);
		return bean;
	}

	private Mall getMall() {
		Long id = getParameterLong("id");
		String name = getHttpParameter("name");
		String url = getHttpParameter("url");
		String master = getHttpParameter("master");
		String qq = getHttpParameter("qq");
		String email = getHttpParameter("email");
		String mobile = getHttpParameter("mobile");
		String phone = getHttpParameter("phone");
		String address = getHttpParameter("address");
		String goods_no_pre = getHttpParameter("goods_no_pre");
		String index_seo_keywords = getHttpParameter("index_seo_keywords");
		String index_seo_description = getHttpParameter("index_seo_description");

		Mall mall = new Mall();
		mall.setId(id);
		mall.setName(name);
		mall.setUrl(url);
		mall.setMaster(master);
		mall.setQq(qq);
		mall.setEmail(email);
		mall.setMobile(mobile);
		mall.setPhone(phone);
		mall.setAddress(address);
		mall.setGoods_no_pre(goods_no_pre);
		mall.setIndex_seo_keywords(index_seo_keywords);
		mall.setIndex_seo_description(index_seo_description);

		return mall;
	}

}
