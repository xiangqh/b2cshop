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
	
	//
	
	$.b2c.ajaxUpload = function(form,ajaxURL,path,callback){
		form.submit(function(e) {
			var para = form.serialize();
			if (!e.isDefaultPrevented()) {
				$.ajax( {
					url :ajaxURL,
					data:para,
					type:"post",
					contentType:"multipart/form-data; charset=UTF-8",
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