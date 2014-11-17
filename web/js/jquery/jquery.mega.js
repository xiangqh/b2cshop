(function( $ ) {
	
	$.mega = function(note, options, callback) { return $.fn.mega(note, options, callback); };
	
	$.fn.mega = function(note, options, callback) {
		var config = {    
			 sensitivity: 2, // number = sensitivity threshold (must be 1 or higher)    
			 interval: 100, // number = milliseconds for onMouseOver polling interval    
			 over: $.fn.mega.megaHoverOver, // function = onMouseOver callback (REQUIRED)    
			 timeout: 500, // number = milliseconds delay before onMouseOut    
			 out: $.fn.mega.megaHoverOut // function = onMouseOut callback (REQUIRED)    
		};
		$("ul#topnav li .sub").css({'opacity':'0'});
		$("ul#topnav li").hoverIntent(config); 
	}
	
	$.fn.mega.megaHoverOver = function(){
		$(this).find(".sub").stop().fadeTo('fast', 1).show();
			
		//Calculate width of all ul's
		(function($) { 
			jQuery.fn.calcSubWidth = function() {
				rowWidth = 0;
				//Calculate row
				$(this).find("ul").each(function() {					
					rowWidth += $(this).width(); 
				});	
			};
		})(jQuery); 
		
		if ( $(this).find(".row").length > 0 ) { //If row exists...
			var biggestRow = 0;	
			//Calculate each row
			$(this).find(".row").each(function() {							   
				$(this).calcSubWidth();
				//Find biggest row
				if(rowWidth > biggestRow) {
					biggestRow = rowWidth;
				}
			});
			//Set width
			$(this).find(".sub").css({'width' :biggestRow});
			$(this).find(".row:last").css({'margin':'0'});
			
		} else { //If row does not exist...
			
			$(this).calcSubWidth();
			//Set Width
			$(this).find(".sub").css({'width' : rowWidth});
			
		}
	}
	
	$.fn.mega.megaHoverOut = function(){ 
	  $(this).find(".sub").stop().fadeTo('fast', 0, function() {
		  $(this).hide(); 
	  });
	}
	
	
	
})( jQuery );