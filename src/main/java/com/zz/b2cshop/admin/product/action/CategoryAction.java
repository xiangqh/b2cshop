package com.zz.b2cshop.admin.product.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.product.dao.entity.Category;
import com.zz.b2cshop.product.service.ICategorySerice;

@Controller
@ActionController
public class CategoryAction extends QAction {
	
	@Autowired
	private ICategorySerice categorySerice;

	@RequestMapping(value="categoryList")
	public Result list(){
		return new BaseResult("/template/admin/page/product/categoryList.vm");
	}
	
	@RequestMapping(value="editCategoryPage")
	public Result editCategoryPage(){
		
		Long id = getParameterLong("id");
		if(id!= null) {
			Category category = categorySerice.getCategoryById(id);
			setHttpAttribute("category", category);
		}
		
		return new BaseResult("/template/admin/page/product/editCategoryPage.vm");
		
	}
}
