package com.zz.b2cshop.admin.system.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.mall.dao.entity.Mall;
import com.zz.b2cshop.mall.service.IMallService;

@ActionController
@Controller
public class MallAction extends QAction {

	@Autowired
	private IMallService mallService;

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
