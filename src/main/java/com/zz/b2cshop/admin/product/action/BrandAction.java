package com.zz.b2cshop.admin.product.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.google.common.collect.Lists;
import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.product.dao.entity.Brand;
import com.zz.b2cshop.product.service.IBrandService;

@Controller
@ActionController
public class BrandAction extends QAction {

	@Autowired
	private IBrandService brandService;

	@RequestMapping(value = "brandList")
	public Result list() {

		String search_name = getHttpParameter("search_name");

		List<Brand> list = Lists.newArrayList();
		if (StringUtils.isBlank(search_name)) {
			list = brandService.getAllBrand();
		} else {
			list = brandService.searchBrands(search_name);
		}

		setHttpAttribute("list", list);
		return new BaseResult("/template/admin/page/product/brandList.vm");
	}

	@RequestMapping(value = "editBrandPage")
	public Result editBrand() {
		return new BaseResult("/template/admin/page/product/editBrandPage.vm");
	}

	@RequestMapping(value = "saveBrand")
	public Result saveBrand() {
		String name = getHttpParameter("name");
		String position = getHttpParameter("position");
		String desc = getHttpParameter("desc");
		String logo = getHttpParameter("logo");

		Brand brand = new Brand();
		brand.setName(name);
		brand.setDescription(desc);
		brand.setPosition(position);
		brand.setLogo(logo);

		Long id = getParameterLong("id");
		if (id != null) {
			brand.setId(id);
			brandService.updateBrand(brand);
		} else {
			brandService.addBrand(brand);
		}

		return new AjaxResult();
	}

}
