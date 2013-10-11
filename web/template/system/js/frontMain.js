jQuery(function(){
	jQuery("#bh-pd-menudiv .bh-cate-1").each(function(i){
		jQuery(this).mouseover(function(){
			jQuery(this).addClass("bh-on");
		}),
		jQuery(this).mouseout(function(){
			jQuery(this).removeClass("bh-on");
		})
	})
})

function scMouseover(obj,id){
	if(!(obj.getAttribute("class"))){
		var _idstr = jQuery("#_bh_tab_ul_ .bh-on").attr("id");
		jQuery("#_bh_tab_ul_ .bh-on").removeClass("bh-on");
		obj.setAttribute("class","bh-on");
		var _id = _idstr.substring(_idstr.lastIndexOf("_")+1,_idstr.length);
		jQuery("#bh_cxsp_"+_id).removeClass("bh-on");
		jQuery("#bh_cxsp_"+id).addClass("bh-on");
	}
}

function scMouseover01(obj,id){
	var _isLast = (obj.getAttribute("class") && "bh-last"==obj.getAttribute("class"));
	if(!(obj.getAttribute("class")) || _isLast){
		var _idstr = jQuery("#_bh_tab_ul_01 .bh-on").attr("id");
		jQuery("#_bh_tab_ul_01 .bh-on").removeClass("bh-on");
		if(_isLast)
			obj.setAttribute("class","bh-on bh-last");
		else
			obj.setAttribute("class","bh-on");
		var _id = _idstr.substring(_idstr.lastIndexOf("_")+1,_idstr.length);
		jQuery("#bh_tjsp_01_"+_id).removeClass("bh-on");
		jQuery("#bh_tjsp_01_"+id).addClass("bh-on");
	}
}
function scMouseover02(obj,tid,id){
	var _isLast = (obj.getAttribute("class") && "bh-last"==obj.getAttribute("class"));
	if(!(obj.getAttribute("class")) || _isLast){
		var _idstr = jQuery("#"+tid+" .bh-on").attr("id");
		jQuery("#"+tid+" .bh-on").removeClass("bh-on");
		if(_isLast)
			obj.setAttribute("class","bh-on bh-last");
		else
			obj.setAttribute("class","bh-on");
		var _id = _idstr.substring(_idstr.lastIndexOf("_")+1,_idstr.length);
		jQuery("#"+tid+"_"+_id).removeClass("bh-on");
		jQuery("#"+tid+"_"+id).addClass("bh-on");
	}
}

function _selected(o,n){
	if(n == 0){
		jQuery(o).addClass("bh-on");
		jQuery(o).next().removeClass("bh-on");
		jQuery(o).next().next().removeClass("bh-on");
		jQuery("#sell_top_0").show();
		jQuery("#sell_top_1").hide();
		jQuery("#sell_top_2").hide();
	}else if(n == 1){
		jQuery(o).addClass("bh-on");
		jQuery(o).next().removeClass("bh-on");
		jQuery(o).prev().removeClass("bh-on");
		jQuery("#sell_top_0").hide();
		jQuery("#sell_top_1").show();
		jQuery("#sell_top_2").hide();
	}else if(n == 2){
		jQuery(o).addClass("bh-on");
		jQuery(o).prev().removeClass("bh-on");
		jQuery(o).prev().prev().removeClass("bh-on");
		jQuery("#sell_top_0").hide();
		jQuery("#sell_top_1").hide();
		jQuery("#sell_top_2").show();
	}
}
