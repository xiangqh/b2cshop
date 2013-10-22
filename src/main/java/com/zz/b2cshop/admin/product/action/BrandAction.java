package com.zz.b2cshop.admin.product.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

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
		List<Brand> list = brandService.getAllBrand();
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
		
		Brand brand = new Brand();
		brand.setName(name);
		brand.setDescription(desc);
		brand.setPosition(position);
		
		String filePath = getHttpParameter("filePath");
		return new AjaxResult();
	}

}
