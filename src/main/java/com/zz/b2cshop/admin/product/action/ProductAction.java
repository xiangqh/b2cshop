package com.zz.b2cshop.admin.product.action;

import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.BaseResult;

@Controller
@ActionController
public class ProductAction extends QAction {

	@RequestMapping(value="goodsList")
	public Result list() {
		return new BaseResult("/template/admin/page/product/productList.vm");
	}

}
