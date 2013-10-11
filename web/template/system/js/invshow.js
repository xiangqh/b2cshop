jQuery(
	function(){
		var _all = jQuery("div[name='size_attr']");
		_all.each(function(i){
		jQuery(this).click(function(){
			_all.each(function(i){
				jQuery(this).removeClass("selected");
			});
			if(!(this.getAttribute("class") && this.getAttribute("class") == "selected")){
				jQuery(this).addClass("selected");
				var _vv = jQuery(this).attr("value");
				jQuery("#changes_vv").html(_vv);
				jQuery("#__page06").val(_vv);
			}
		});
		})
	}
)

jQuery(
	function(){
		jQuery(".bh-addcart").click(function(){
			
			/*alert("id:"+jQuery("#__page01").val());
			alert("name:"+jQuery("#__page02").val());
			alert("image:"+jQuery("#__page03").val());
			alert("price:"+jQuery("#__page04").val());
			alert("point:"+100);
			alert("num:"+jQuery("#pamount").val());
			alert("cateid:"+jQuery("#__page05").val());
			alert("cc:"+jQuery("#__page06").val());*/
			var _v1 = jQuery("#__page01").val();
			var _v2 = jQuery("#__page02").val();
			var _v3 = jQuery("#__page03").val();
			var _v4 = jQuery("#__page04").val();
			var _v5 = 100;
			var _v6 = jQuery("#pamount").val();
			var _v7 = jQuery("#__page05").val();
			var _v8 = jQuery("#__page06").val();
			Common.addCart(_v1,_v2,_v3,_v4,_v5,_v6,_v7,_v8);
			//最近浏览的商品
			Browse.intoBrowsePro(_v1,_v2,_v4,_v3);
			location.href="addCart.htm";
		})
	}
)

jQuery(
	function(){
		jQuery("#att-btn-").click(attentionSave);
		
	}
)

function attentionSave(){
	var _u = getdcu();
			if(_u == null){
				LoginReg.isloginReg(attentionSave);
			}else{
				var _v1 = jQuery("#__page01").val();
				var _v2 = jQuery("#__page02").val();
				var _v3 = jQuery("#__page03").val();
				var _v4 = jQuery("#__page04").val();
				var _ct = jQuery("#__page05").val();
				var _gc = jQuery("#__page06").val();
				jQuery.ajax({
					url: 'saveAtt.htm',
					type: 'POST',
					data: {uid:_u,gs:_v1,gm:_v2,pc:_v4,img:_v3,ct:_ct,gc:_gc},
					dataType: 'text',
					success: function(data){if("SUCCESS"==data){alert("商品成功加入到收藏夹！")}}
				});
			}
}
function attentionSaveconfirm(id){
	var _u = getdcu();
			if(_u == null){
				LoginReg.isloginReg(attentionSaveconfirm);
			}else{
			var seft=$("#gz_"+id);
  var _v1=seft.attr("pid");
  var _v2=seft.attr("name");
  var _v3=seft.attr("image");
  var _v4=seft.attr("price");
  var point=seft.attr("point");
  var _ct=seft.attr("cateid");
  var _gc=seft.attr("cc");
				jQuery.ajax({
					url: 'saveAtt.htm',
					type: 'POST',
					data: {uid:_u,gs:_v1,gm:_v2,pc:_v4,img:_v3,ct:_ct,gc:_gc},
					dataType: 'text',
					success: function(data){if("SUCCESS"==data){alert("商品成功加入到收藏夹！")}}
				});
			}
}
jQuery(
	function(){
		var _payn = jQuery("#pamount");
		_payn.blur(function(){
			checkPayNumber(_payn.val());
		});
	}
)
jQuery(
	function(){
		var _payn = jQuery("#pamount");
		jQuery("#a_reduce").click(function(){
			if(parseInt(_payn.val()) > 1){
				_payn.val(parseInt(_payn.val()) - 1);
			}
		});
	}
)
jQuery(
	function(){
		var _payn = jQuery("#pamount");
		jQuery("#a_add").click(function(){
			if(parseInt(_payn.val()) <10000){
				_payn.val(parseInt(_payn.val()) + 1);
			}
		});
	}
)
/*jQuery(function(){
	var _catedivs = jQuery("div[name='_catediv']");
	_catedivs.each(function(i){
		jQuery(this).mouseover(function(){
			_catedivs.each(function(o){this.setAttribute("class","bh-tab-two bh-overf")});
			if(this.getAttribute("class").indexOf("bh-on") == -1){
				this.setAttribute("class","bh-tab-two bh-on bh-overf");
			}
		})
	})
})*/
jQuery("#_catelis0").mouseover(function(){
	if(!(this.getAttribute("class") && "bh-on"==this.getAttribute("class"))){
		jQuery(this).addClass("bh-on");
		jQuery("#bh-tejia").attr("class","bh-tab-two bh-on bh-overf");
		jQuery("#_catelis1").removeClass("bh-on");
		jQuery("#bh-hot").attr("class","bh-tab-two bh-overf");
	}
})
jQuery("#_catelis1").mouseover(function(){
	if(!(this.getAttribute("class") && "bh-on"==this.getAttribute("class"))){
		jQuery(this).addClass("bh-on");
		jQuery("#bh-hot").attr("class","bh-tab-two bh-on bh-overf");
		jQuery("#_catelis0").removeClass("bh-on");
		jQuery("#bh-tejia").attr("class","bh-tab-two bh-overf");
	}
})

jQuery("#_bh-cate_left").click(function(){
	var _divChildrens = jQuery("div[class='bh-tab-two bh-on bh-overf']").children();
	var _size = _divChildrens.size();
	if(_size > 4){
		var _firstVis = _divChildrens.filter(":visible").eq(0);
		var _firstVisNum = parseInt(_firstVis.attr("number"));
		if(_firstVisNum > 1){
			_firstVis.prev().show();
			_firstVis.next().next().next().hide();
		}
	}
})

jQuery("#_bh-cate_rig").click(function(){
	var _divChildrens = jQuery("div[class='bh-tab-two bh-on bh-overf']").children();
	var _size = _divChildrens.size();
	if(_size > 4){
		var _firstVis = _divChildrens.filter(":visible").eq(0);
		var _firstVisNum = parseInt(_firstVis.attr("number"));
		if(_firstVisNum + 3 < _size){
			_firstVis.hide();
			_firstVis.next().next().next().next().show();
		}
		
	}
})


function _imgRight(){
	var _lis = jQuery("#_img_list-h").children();
	var _size = _lis.size();
	var _firstVis = _lis.filter(":visible").eq(0);
	var _firstVisNum = parseInt(_firstVis.attr("number"));
	if(_firstVisNum + 4 < _size){
		_firstVis.hide();
		_firstVis.next().next().next().next().next().show();
	}
}

function _imgLeft(){
	var _lis = jQuery("#_img_list-h").children();
	var _firstVis = _lis.filter(":visible").eq(0);
	var _firstVisNum = parseInt(_firstVis.attr("number"));
	if(_firstVisNum > 1){
		_firstVis.prev().show();
		_firstVis.next().next().next().next().hide();
	}
}


jQuery("#_detail ul li").each(function(i){
	jQuery(this).click(function(){
		var _this = jQuery(this);
		if(!(this.getAttribute("class") && "curr" == this.getAttribute("class"))){
			var _ckDetail = jQuery("#_detail ul .curr");
			_this.addClass("curr");
			jQuery("#"+_this.attr("indiv")).attr("class","mc fore tabcon");
			_ckDetail.removeClass("curr");
			jQuery("#"+_ckDetail.attr("indiv")).attr("class","mc tabcon hide");
		}
	});
})

jQuery("#comment ul li").each(function(i){
	jQuery(this).click(function(){
		var _this = jQuery(this);
		if(!(this.getAttribute("class") && "curr" == this.getAttribute("class"))){
			var _ckCmm = jQuery("#comment ul .curr");
			_this.addClass("curr");
			jQuery("#"+_this.attr("indiv")).attr("style","display:'';");
			_ckCmm.removeClass("curr");
			jQuery("#"+_ckCmm.attr("indiv")).attr("style","display:none;");
		}
	});
})

function checkPayNumber(v){
	if(!(/^[1-9]\d{0,3}$/.test(v))){
		alert("购买数量必须为[1-9999]之间的整数!");
		return false;
	}
	return true;
}

function getPageData(gsid,_pn,_rn){
	jQuery.ajax({
			url: 'getcommentbydtl.htm',
			type: 'GET',
			data: {gs:gsid,pn:_pn,rn:_rn},
			dataType: 'html',
			success: function(data){jQuery("#_comment_page_").html(data);}
	});
}
function getAdviPageData(gsid,_pn,_rn){
	jQuery.ajax({
			url: 'advispart.htm',
			type: 'GET',
			data: {gs:gsid,pn:_pn,rn:_rn},
			dataType: 'html',
			success: function(data){jQuery("#pdshow-zixun").html(data);}
	});
}
function advreg(){
	var userid=Sccookie.Get("userid");
	if(userid==""||userid==null){
		LoginReg.isloginReg(advclick);
	}else{
		advclick();
	}
}

function advclick(){
	var _adv = jQuery("#advi-dd-");
	var bh = jQuery(document).height();
    var bw = jQuery(document).width();
    var ww = $(window).width();
    var wh = $(window).height();
    var ds = $(document).scrollTop();
    var objLeft = (ww - _adv.width())/2 ;
	var objTop = (wh - _adv.height())/2 + ds;
	jQuery("#x-fulldiv").width(bw).height(bh).show();
	_adv.css("left",objLeft+"px").css("top",objTop+"px").show();
}
function advclose(){jQuery("#x-fulldiv").hide();jQuery("#advi-dd-").hide();}

function adviSubClick(){
	//货品ID
	var _g = jQuery("#__page01").val();
	var _u = getdcu();
	if(_u == null){
		return;
	}
	//类型
	var _t = jQuery("#a-types").val();
	//内容
	var _c = jQuery("#adv-content").val();
	var __cnum= getLength(_c.trim());
	if(__cnum > 150 || __cnum < 4){
		jQuery("#bh-pd-span-").addClass("bh-yellow");
		return;
	}else{
		jQuery("#bh-pd-span-").removeClass("bh-yellow");
	}
	var authcode=jQuery("#authcode").val();
	if(getLength(authcode) > 0){
		jQuery("#x-bh-yellow").html("*");
		jQuery.ajax({
				url: 'isRand.htm',
				type: 'GET',
				data: {authcode:authcode},
				dataType: 'json',
				success: function(data){
					if(data.tag != 0){
						jQuery.ajax({
							url: 'addadvispart.htm',
							type: 'POST',
							data: {gs:_g,u00x:_u,cnt:_c,type:_t},
							dataType: 'text',
							success: function(data){
								if(data == 'SUCCESS'){
									getAdviPageData(_g,1,2);
								}
								advclose();
							}
						});
					}else{
						jQuery("#x-bh-yellow").html("验证码错误*");
					}
				}
		});
	}else{
		jQuery("#x-bh-yellow").html("请输入验证码*");
	}
}

var _c_p = null;
function tocomment(p){
	if(p){
		_c_p = p;
	}
	var _u = getdcu();
	if(_u == null){
		LoginReg.isloginReg(tocomment);
	}else{
		if(_c_p){
			location.href=_c_p;
		}
	}
}


function getdcu(){
	var re=new RegExp('userid=([^;]*);?','gi');
	var r= re.exec(document.cookie)||[];
	return (r.length>1?r[1]:null);
}

