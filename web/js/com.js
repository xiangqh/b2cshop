function showcatesub2(id)
{	
	if(id!=0){
	$("#s_city").removeOption(/./);
	$("#s_town").removeOption(/./);
		var items = eval("city"+id);
		var len = items.length;
		var html = '';
		$("#s_city").addOption("0", "不限");
		var str ='';
		for(var i=0;i<len;i++){
			$("#s_city").addOption(items[i].code, items[i].name,false);
			str+=(","+items[i].code);
		}
		var f = items[0].code;
		 
		$('#s_city').change(function(){
			showcatesub3(this.value);
		//if($(this).val()==0){
		//	$("#s_town").addOption("0", "不限");
		//	$("#s_town").selectOptions("0");
		///	$("#s_town").val("0");
		//}
		});  
	}	
}
function showcatesub3(id)
{	
$.ajax({
			url: 'townlist.htm',
			type: 'GET',
			data: 'cityId='+id,
			dataType: 'json',
			timeout: 10000,
		    async:false,
			success: function(data){
			var items = eval(data.towns);
			var len = items.length;
		    var html = '<option value="0">不限</option>';
		   for(var i=0;i<len;i++){
			html=html+'<option value="'+items[i].id+'">'+items[i].name+'</option>';
		   }
		$("#town_id").html(html);
			}
		});
	/*if(id!=0){
	$("#s_town").removeOption(/./);
		var items = eval("town"+id);
		var len = items.length;
		var html = '';
		$("#s_town").addOption("0", "不限");
		for(var i=0;i<len;i++){
			$("#s_town").addOption(items[i].code, items[i].name,false);
		}  
	}	*/
}
function initcity(p_1_v,p_2_v){
	var len2 = Provinces.length;
	var html = '';
	$("#s_province").addOption("0", "不限");
	$("#s_city").addOption("0", "不限");
	
	for(var i=0;i<len2;i++)
	{$("#s_province").addOption(Provinces[i].code, Provinces[i].name,false);}
	
	if(p_1_v==0){
		$("#s_province").selectOptions("0");
		$("#s_city").selectOptions("0");
		$("#s_city").val("0");
	}else{
		$("#s_province").selectOptions(p_1_v);
		$("#s_province").val(p_1_v);
	}
	$('#s_province').change(function(){showcatesub2(this.value);
		if($(this).val()==0){
			$("#s_city").addOption("0", "不限");
			$("#s_city").selectOptions("0");
			$("#s_city").val("0");
		}
	});
	}
	function initaddlist(){
	var len2 = Provinces.length;
	var html = '';
	
	for(var i=0;i<len2;i++)
	{
	html=html+'<tr  onmouseover="this.className=\'lineon\'" onmouseout="this.className=\'line01\'"><td style="cursor:pointer" onclick="city_2('+Provinces[i].code+')">'+Provinces[i].name+'</td></tr>';
	}
	$("#provinces_id").html(html);
	}
	function city_2(provincesid){
	var items = eval("city"+provincesid);
		var len = items.length;
		var html = '';
		for(var i=0;i<len;i++){
			html=html+'<tr  onmouseover="this.className=\'lineon\'" onmouseout="this.className=\'line01\'"><td style="cursor:pointer" onclick="city_3('+items[i].code+')">'+items[i].name+'</td></tr>';
		}
		$("#city_id").html(html);
	}
	function city_3(cityid){
	$.ajax({
			url: 'townlist.htm',
			type: 'GET',
			data: 'cityId='+cityid,
			dataType: 'json',
			timeout: 10000,
		    async:false,
			success: function(data){
			var items = eval(data.towns);
			var len = items.length;
		    var html = '';
		   for(var i=0;i<len;i++){
			html=html+'<tr  onmouseover="this.className=\'lineon\'" onmouseout="this.className=\'line01\'"><td >'+items[i].name+'</td><td style="cursor:pointer" onclick="del_('+items[i].id+','+cityid+')">删除</td></tr>';
		   }
		$("#town_id").html(html);
			}
		});
	//var items = eval("city"+cityid);
		
	}
	
	function del_(town_id,cityid){
	$.ajax({
			url: 'deltown.htm',
			type: 'GET',
			data: 'town_id='+town_id+'&cityId='+cityid,
			dataType: 'json',
			timeout: 10000,
			success: function(data){
			var items = eval(data.towns);
			var len = items.length;
		    var html = '';
		   for(var i=0;i<len;i++){
			html=html+'<tr  onmouseover="this.className=\'lineon\'" onmouseout="this.className=\'line01\'"><td  >'+items[i].name+'</td><td style="cursor:pointer" onclick="del_('+items[i].id+','+cityid+')">删除</td></tr>';
		   }
		$("#town_id").html(html);
			}
		});
	}