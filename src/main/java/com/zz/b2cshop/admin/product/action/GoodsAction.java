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
import com.zz.b2cshop.product.dao.entity.Category;
import com.zz.b2cshop.product.dao.entity.Goods;
import com.zz.b2cshop.product.dao.entity.ProductType;
import com.zz.b2cshop.product.service.IBrandService;
import com.zz.b2cshop.product.service.ICategorySerice;
import com.zz.b2cshop.product.service.IGoodsService;
import com.zz.b2cshop.product.service.IProductTypeService;

@Controller
@ActionController
public class GoodsAction extends QAction {

	@Autowired
	private ICategorySerice categorySerice;
	@Autowired
	private IBrandService brandService;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IProductTypeService productTypeService;

	@RequestMapping(value = "goodsList")
	public Result list() {
		List<Goods> list = goodsService.getAllGoods();
		setHttpAttribute("list", list);
		return new BaseResult("/template/admin/page/product/productList.vm");
	}

	@RequestMapping(value = "editGoodBaseInfoPage")
	public Result addBaseInfoPage() {

		List<Category> cate_list = categorySerice.getLevelFCatetegory();
		List<Brand> brand_list = brandService.getAllBrand();

		setHttpAttribute("cates", cate_list);
		setHttpAttribute("brands", brand_list);
		return new BaseResult("/template/admin/page/product/addGoodBaseInfo.vm");
	}

	@RequestMapping(value = "saveBaseInfo")
	public Result saveGoodsBaseInfo() {
		String name = getHttpParameter("name");
		String sn = getHttpParameter("sn");
		Long category_id = getParameterLong("category_id");
		Long brand_id = getParameterLong("brand_id");
		String desc = getHttpParameter("dec");
		Long pt_id = getParameterLong("pt_id");
		int stock = getParameterInt("stock");

		Goods goods = new Goods();
		goods.setName(name);
		goods.setSn(sn);
		goods.setDescription(desc);
		goods.setCategory(new Category(category_id));
		goods.setBrand(new Brand(brand_id));

		Long id = getParameterLong("id");
		if (id == null) {
			goodsService.saveGoods(goods);
		} else {
			goods.setId(id);
			goodsService.updateGoods(goods);
		}

		return new AjaxResult();
	}
	
	@RequestMapping(value="editGoodsAttrs")
	public Result editGoodsAttrsPage(){
		Long id = getParameterLong("id");
		Goods goods = goodsService.getGoodsById(id);
		setHttpAttribute("goods", goods);
		return new BaseResult("/template/admin/page/product/editGoodsAttrs.vm");
	}

	@RequestMapping(value = "saveGoodsAttrs")
	public Result saveGoodsAttrs() {

		return new BaseResult("/template/admin/page/product/editGoodsAttrs.vm");

	}

}
