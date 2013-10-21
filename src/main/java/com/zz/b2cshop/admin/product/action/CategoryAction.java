package com.zz.b2cshop.admin.product.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.product.dao.entity.Category;
import com.zz.b2cshop.product.dao.entity.ProductType;
import com.zz.b2cshop.product.service.ICategorySerice;
import com.zz.b2cshop.product.service.IProductTypeService;

@Controller
@ActionController
public class CategoryAction extends QAction {

	@Autowired
	private ICategorySerice categorySerice;
	
	@Autowired
	private IProductTypeService productTypeService;

	@RequestMapping(value = "categoryList")
	public Result list() {
		List<Category> list = categorySerice.getLevelFCatetegory();
		setHttpAttribute("list", list);
		return new BaseResult("/template/admin/page/product/categoryList.vm");
	}

	@RequestMapping(value = "editCategoryPage")
	public Result editCategoryPage() {

		Long id = getParameterLong("id");
		if (id != null) {
			Category category = categorySerice.getCategoryById(id);
			setHttpAttribute("category", category);
		}
		List<Category> list = categorySerice.getLevelFCatetegory();
		List<Category> all = new ArrayList<Category>();
		for(Category each : list) {
			all.add(each);
			for(Category childS : each.getChilds()) {
				all.add(childS);
				for(Category childT : childS.getChilds()) {
					all.add(childT);
				}
			}
		}
		setHttpAttribute("list", all);
		
		List<ProductType> pt_list = productTypeService.getAllPtsNoAttr();
		setHttpAttribute("pt_list", pt_list);

		return new BaseResult("/template/admin/page/product/editCategoryPage.vm");
	}

	@RequestMapping(value="saveCategory")
	public Result saveCategory() {
		String name = getHttpParameter("name");
		Long parent_id = getParameterLong("parent_id");
		Long pt_id = getParameterLong("pt_id");
		Boolean publish_status = getParameterInt("publish_status") == 0 ? Boolean.FALSE : Boolean.TRUE;

		Category category = new Category();
		category.setName(name);
		category.setPublish_status(publish_status);
		if (parent_id != 0) {
			category.setParent(new Category(parent_id));
		}
		if (pt_id != 0) {
			category.setPt(new ProductType(pt_id));
		}
		Long id = getParameterLong("id");
		if (id == null) {
			categorySerice.addCategory(category);
		} else {
			category.setId(id);
			categorySerice.updateCategory(category);
		}

		return new AjaxResult();
	}
}
