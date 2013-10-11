function useful(obj,mm){
	var _t = obj.getAttribute("title");
	var _tt = parseInt(_t);
	jQuery.ajax({
			url: 'useful.htm',
			type: 'GET',
			data: {md:mm},
			dataType: 'text',
			success: function(data){if("TRUE" == data){obj.setAttribute("title",++_tt,0);obj.innerHTML="有用("+_tt+")";}}
	});
}
function useless(obj,mm){
	var _t = obj.getAttribute("title");
	var _tt = parseInt(_t);
	jQuery.ajax({
			url: 'useless.htm',
			type: 'GET',
			data: {md:mm},
			dataType: 'text',
			success: function(data){if("TRUE" == data){obj.setAttribute("title",++_tt,0);obj.innerHTML="无用("+_tt+")";}}
	});
}