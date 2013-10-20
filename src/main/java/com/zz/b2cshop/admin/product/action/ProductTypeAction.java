package com.zz.b2cshop.admin.product.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.BaseResult;
import com.zz.b2cshop.product.dao.entity.Attr;
import com.zz.b2cshop.product.dao.entity.ProductType;
import com.zz.b2cshop.product.service.IAttrService;
import com.zz.b2cshop.product.service.IProductTypeService;

@Controller
@ActionController
public class ProductTypeAction extends QAction {

	@Autowired
	private IProductTypeService productTypeService;

	@Autowired
	private IAttrService attrService;

	@RequestMapping(value = "ptList")
	public Result list() {

		List<ProductType> list = productTypeService.getAllPts();
		setHttpAttribute("list", list);

		return new BaseResult("/template/admin/page/product/ptList.vm");
	}

	@RequestMapping(value = "editPt")
	public Result editAttrPage() {
		Long id = getParameterLong("id");
		ProductType pt = productTypeService.getPtById(id);
		setHttpAttribute("pt", pt);
		return new BaseResult("/template/admin/page/product/editPtPage.vm");
	}

	@RequestMapping("savaPt")
	public Result saveAttr() {
		String name = getHttpParameter("name");
		String[] attr_id = getHttpParameters("attr_id");
		String[] attr_name = getHttpParameters("attr_name");
		String[] attr_val = getHttpParameters("attr_val");
		String[] attr_type = getHttpParameters("attr_type");

		ProductType pt = new ProductType();
		pt.setPt_name(name);
		Long id = getParameterLong("id");
		if (id != null) {
			pt.setId(id);
			productTypeService.updateProductType(pt);
		} else {
			productTypeService.addProductType(pt);
		}
		System.out.println("_____   " + pt.getId());

		List<Attr> attrs = new ArrayList<Attr>();
		for (int i = 0; i < attr_name.length; i++) {
			Attr attr = new Attr(attr_name[i], Integer.valueOf(attr_type[i]), attr_val[i]);
			if (StringUtils.isNotBlank(attr_id[i])) {
				attr.setId(Long.valueOf(attr_id[i]));
			}
			attr.setProductType(pt);
			attrs.add(attr);
		}
		attrService.saveAll(attrs);
		return new AjaxResult();
	}

}
