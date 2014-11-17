(function( $ ){
	
	$.fn.hintselect = function(source, options) {
		var isFunction = typeof source == "function";
		
		options = $.extend({}, $.Hintselector.defaults, options);
		
		// if the formatMatch option is not specified, then use formatItem for backwards compatibility
		options.source = source;
		return this.each(function() {
			new $.Hintselector(this, options);
		});
	}
	
	$.Hintselector = function(input, options) {
		var hiddenInput = $("<input type='hidden'/>");
		var hiddenId = null;
		//log.debug("Hintselector input id:" + $(input).attr("id"));
		if($(input).attr("id") != null) {
			hiddenId = $(input).attr("id") + "-value";
		}
		if(hiddenId != null) {
			hiddenInput.attr("id", hiddenId);
		}
		
		var hiddenName = options.name;
		if(hiddenName == null && $(input).attr("name")!= null) {
			hiddenName = $(input).attr("name") + "-value";
		}
		if(hiddenName != null) {
			hiddenInput.attr("name", hiddenName);
		}
		
		$(input).before(hiddenInput);
		$(input).bind("focus", function() {
			//log.debug("focus");
			hiddenInput.val("");
		});
		$(input).bind("blur", function() {
			//log.debug("blur");
			if(hiddenInput.val() == "") {
				$(this).val("");
			}
		});
		$(input).autocomplete({
			source: options.source,
			minLength: 2,
			select: function( event, ui ) {		
				//log.debug("select: " + ui.item.code);			
				hiddenInput.val(ui.item.code);		
				if(options.select != null){
					options.select(ui.item)
				}
			},
			delay: 1000,
			open: function() {
				$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
			},
			close: function() {
				$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
			}
		});
	}
	
	$.Hintselector.defaults = {
		highlight: function(value, term) {
			return value.replace(new RegExp("(?![^&;]+;)(?!<[^<>]*)(" + term.replace(/([\^\$\(\)\[\]\{\}\*\.\+\?\|\\])/gi, "\\$1") + ")(?![^<>]*>)(?![^&;]+;)", "gi"), "<strong>$1</strong>");
		},
		scroll: true,
		scrollHeight: 180
	};

})( jQuery );