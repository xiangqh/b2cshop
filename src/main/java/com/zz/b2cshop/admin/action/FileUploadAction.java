package com.zz.b2cshop.admin.action;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;
import org.zz.qstruts2.upload.UploadBean;

import com.google.common.collect.Maps;
import com.opensymphony.xwork2.Result;
import com.zz.b2cshop.common.AjaxResult;
import com.zz.b2cshop.common.JsonResult;
import com.zz.b2cshop.common.util.FileUtils;
import com.zz.b2cshop.common.util.JsonBinder;
import com.zz.b2cshop.common.util.PropertyUtil;

@Controller
@ActionController
public class FileUploadAction extends QAction {

	@RequestMapping(value = "imageUpload")
	public Result uploadImage() {

		String path = getHttpParameter("path");
		String folder = PropertyUtil.readValue("/addrconfig.properties", path);

		List<UploadBean> uploadBeans = getUpLoadFiles();
		if (uploadBeans.size() > 0) {
			File file = uploadBeans.get(0).getFiles()[0];
			String newFileName = new StringBuilder(40).append(UUID.randomUUID().toString().replaceAll("-", ""))
					.append(".").append(FileUtils.getFileSuffix(uploadBeans.get(0).getFileNames()[0])).toString();

			String root = ServletActionContext.getServletContext().getRealPath("//").replaceAll("\\\\", "\\/");
			try {
				FileUtils.saveFile(file, root + folder + newFileName);
				Map<String, String> message = Maps.newHashMap();

				if ("goods.image.path".equalsIgnoreCase(path)) {
					Map<String, String> result = Maps.newHashMap();
					result.put("err", "");
					result.put("msg", PropertyUtil.readValue("/addrconfig.properties", "imageDomain") + folder
							+ newFileName);
					return new JsonResult(JsonBinder.buildNonNullBinder().toJson(result));
				}
				message.put("path", folder + newFileName);
				return new AjaxResult(200, message);
			} catch (Exception e) {
				return new AjaxResult(500);
			}
		}

		return new AjaxResult();
	}

}
