jQuery(function(){
	jQuery("#searchCatesDiv div").each(function(i){
		jQuery(this).click(function(){
			var _t = jQuery(this);
			if(_t.attr("class").indexOf("current") == -1){
				_t.addClass("current");
			}else{
				_t.removeClass("current");
			}
		})
	})
})