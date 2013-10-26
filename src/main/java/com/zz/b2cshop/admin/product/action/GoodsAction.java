package com.zz.b2cshop.admin.product.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.product.dao.entity.Brand;
import com.zz.b2cshop.product.dao.entity.Category;
import com.zz.b2cshop.product.service.IBrandService;
import com.zz.b2cshop.product.service.ICategorySerice;

@Controller
@ActionController
public class GoodsAction extends QAction {

	@Autowired
	private ICategorySerice categorySerice;

	@Autowired
	private IBrandService brandService;

	@RequestMapping(value = "goodsList")
	public Result list() {
		return new BaseResult("/template/admin/page/product/productList.vm");
	}

	@RequestMapping(value="editGoodBaseInfoPage")
	public Result addBaseInfoPage() {

		List<Category> cate_list = categorySerice.getLevelFCatetegory();
		List<Brand> brand_list = brandService.getAllBrand();

		setHttpAttribute("cates", cate_list);
		setHttpAttribute("brands", brand_list);
		return new BaseResult("/template/admin/page/product/addGoodBaseInfo.vm");
	}

}
