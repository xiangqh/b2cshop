String.prototype._trim = function(){return this.replace(/^\s+|\s+$/g,"");}
jQuery(
	function(){
		var _all = jQuery("#star-span > img");
		var _score = jQuery("#scorecmm");
		var _scoreCom = jQuery("#_p_score");
		var _imgdoma = jQuery("#imgdoma-hidden").val();
		_all.each(function(i){
			jQuery(this).mouseover(function(){
				var _id = jQuery(this).attr("id");
				var _num = parseInt(_id.substring(0,1));
				for(var j=1;j<=_num;j++){
					jQuery("#"+j+"-img-start").attr("src",_imgdoma+"star-l.png");
				}
				for(var j=_num+1;j<=5;j++){
					jQuery("#"+j+"-img-start").attr("src",_imgdoma+"star-h.png");
				}
				_score.html(_num);
				_scoreCom.val(_num);
			});
		})
	}
)
jQuery(function(){
		jQuery("#002900P").click(function(){
			var __titleNum= getLength(jQuery("#_p_title").val().trim());
			if(__titleNum < 4 || __titleNum > 100){
				jQuery("#titleerror").attr("style","color:red");
				return;
			}else{
				jQuery("#titleerror").attr("style","");
			}
			var __advNum= getLength(jQuery("#_p_adv_").val().trim());
			if(__advNum < 4 || __advNum > 200){
				jQuery("#proserror").attr("style","color:red");
				return;
			}else{
				jQuery("#proserror").attr("style","");
			}
			var __defNum= getLength(jQuery("#_p_def_").val().trim());
			if(__defNum < 4 || __defNum > 200){
				jQuery("#conserror").attr("style","color:red");
				return;
			}else{
				jQuery("#conserror").attr("style","");
			}
			jQuery("#2209f").submit();
		});
	}
)

jQuery(function(){
	jQuery("#bh_btn_0x").click(function(){
		var _conLen = getLength(jQuery("#cmmreply").val().trim());
		if(_conLen < 5 || _conLen > 200){
			jQuery("#cmmreply_lbl").attr("style","color:red");
			return;
		}else{
			jQuery("#cmmreply_lbl").attr("style","");
		}
		jQuery("#2209f").submit();
	});
})

