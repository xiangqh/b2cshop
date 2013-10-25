(function($) {

	$.b2c = {
        version: "1.0",
        timeFormat: "yyyy-MM-dd HH:mm:ss",
        dateFormat: "yyyy-MM-dd",
        toDateString: function(object) {
            if (object == null) {
                return "";
            }
            if (object.time != null) {
                return new Date(object.time).toString($.b2c.timeFormat);
            }
			return new Date(object).toString($.b2c.timeFormat);
        }
	}

	$.b2c.random = function() {
		return new Date().getTime() + (Math.random() + "").replace("0.", "");
	}

	$.b2c.ajax = function(ajaxURL,callback){
		$.ajax( {
			type :"post",
			url :ajaxURL,
			datatype :"json",
			error: function(){
				return;
			},
			success :function(data){
				var json = eval("(" + data + ")");
				if (json.status && json.status==200) {
					callback(data);
				}
			}
		});
	}

	$.b2c.ajaxSubmit = function(form,ajaxURL,callback){
		form.submit(function(e) {
			var para = form.serialize();
			if (!e.isDefaultPrevented()) {
				$.ajax( {
					url :ajaxURL,
					data:para,
					type:"post",
					dataType:"json",
					error: function(){
						error();
					},
					success :function(json){
						if (json.status && json.status==200) {
							callback();
						}
					}
				});
				e.preventDefault();
			}
		});
	}

})(jQuery);

(function($) {
	$.fn.ajaxUpload = function(params, callback) {
		var options = $.extend( {
			path : '',
			filename : '',
			notdatepath : 0,
			button : 'cube',
			file_size_limit : "5 MB",
			file_types : "*.jpg;*.jpeg;*.png;*.gif",
			file_types_description : "文件选择"
		// 0 要，1，不要
		}, params, {
			setting : (function() {
				if (params.setting) {
					return $.type(params.setting) == 'object' ? JSON.stringify(params.setting) : params.setting;
				}
				return "{}";
			})()
		});
		options.button_image_url = "http://127.0.0.1:9998/b2cshop/images/upload/upload_" + options.button + ".png";// ,//circle
		if (options.button == 'cube') {
			$.extend(options, {
				button_width : 74,
				button_height : 24
			});
		} else if (options.button == 'circle') {
			$.extend(options, {
				button_width : 68,
				button_height : 20
			});
		} else if (options.button == 'richeditor') {
			$.extend(options, {
				button_width : 39,
				button_height : 20
			});
		}
		return this.each(function() {
			if (!this.id) {
				this.id = "upload" + $.b2c.random();
			}
			new SWFUpload( {
				flash_url : "http://127.0.0.1:9998/b2cshop/js/swfupload.swf",
				upload_url : options.upload_url,
				post_params : {
					path : options.path,
					filename : options.filename,
					notdatepath : options.notdatepath,
					setting : options.setting
				},
				file_size_limit : options.file_size_limit,
				file_types : options.file_types,
				file_types_description : options.file_types_description,
				file_upload_limit : 0,
				file_queue_limit : 1,
				file_post_name : "file",
				button_placeholder_id : this.id,
				button_image_url : options.button_image_url,// "/xx/admin/image/xx/upload_cube.png",//circle
				button_width : options.button_width,// 68
				button_height : options.button_height,// 20

				file_dialog_complete_handler : function(numFilesSelected, numFilesQueued, numFilesInQueue) {
					try {
						this.startUpload();
					} catch (ex) {
						this.debug(ex);
					}
				},
				upload_start_handler : function(file) {
					this.setButtonDisabled(true);
					$.event.trigger("ajaxStart");
					if ($.isFunction(options.onStart)) {
						options.onStart.apply(file, [ file ]);
					}
				},
				upload_error_handler : function(file, errorCode, message) {
					this.setButtonDisabled(false);
					$.event.trigger("ajaxStop");
					if ($.isFunction(options.onError)) {
						options.onError.call(errorCode, message);
					} else {
						if (message == '404') {
							KP.error("上传失败：" + message + "," + this.settings.upload_url + " not found!");
						} else {
							KP.error("上传失败：" + message);
						}
					}
				},
				upload_success_handler : function(file, serverData, responseReceived) {
					var json = eval("(function(){return " + serverData + ";})();");
					if ($.isFunction(callback)) {
						callback.apply(this, [ json ]);
					}
				},
				upload_complete_handler : function(file) {
					this.setButtonDisabled(false);
					$.event.trigger("ajaxStop");
				}
			});
		});
	};
})(jQuery);