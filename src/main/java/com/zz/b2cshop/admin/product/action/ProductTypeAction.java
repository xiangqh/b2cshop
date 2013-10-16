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
import com.zz.b2cshop.product.entity.ProductType;
import com.zz.b2cshop.product.service.IAttrService;

@Controller
@ActionController
public class ProductTypeAction extends QAction {

	@Autowired
	private IAttrService attrService;

	@RequestMapping(value="showAttrs")
	public Result list() {
		List<ProductType> list = attrService.getAllBrandAttrs();
		setHttpAttribute("list", list);
		return new BaseResult("/template/admin/product/attrList.vm");
	}
	
	public Result editAttrPage(){
		return new BaseResult("/template/admin/product/editAttrPage.vm");
	} 
	
	public Result saveAttr(){
		return new AjaxResult();
	}

}
