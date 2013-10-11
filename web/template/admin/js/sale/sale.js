
$(function () {
	$("#reverse").click(function () {//反选
            //判断全选有没有选中
		if ($("#reverse").attr("checked")) {
			$(".lccheck").each(function () {
				$(this).attr("checked", true);
				$(this).attr("disabled", "disabled");
			});
		} else {
			$(".lccheck").each(function () {
				$(this).removeAttr("disabled");
				$(this).attr("checked", false);
			});
		}
	});
});
function chang_v(id) {
	for (var i = 1; i <= 4; i++) {
		if (id == i) {
			$("#tr_show_1").show();
			$("#show_" + id).show();
		} else {
			$("#show_" + i).hide();
		}
	}
	if (id == 4) {
		$("#tr_show_1").hide();
	}
}
function add_pgoods(id,name,hname,price,scprice){
    //判断是不是已添加活动了 if(){}
      
  var html_='<tr id="tr_'+id+'" class=""><td>'+id+'</td><td>'+name+'</td><td>'+hname+'</td><td>'+price+'/'+scprice+'</td><td><input type="text"   name="to_values"><input type="hidden"   name="ids" value="'+id+'"></td><td> <a onclick="removeTr('+id+')">删除</a>	</td></tr>'
  var htmltr=$("#trAll").html();
  $("#trAll").html(htmltr+html_)
}
function removeTr(id){
$("#tr_"+id).remove();
}

function updateJf(id){
  var to_value=$("#value_"+id).val();
$.ajax({
			url: 'updateJfStatus.htm',
			type: 'GET',
			data: 'id='+id+"&to_value="+to_value,
			dataType: 'json',
			success: function(data){
			if(data.tag==1){
			$("#up_"+id).html("<font color='red'>更新成功</font>");
			}
			}
		});
}
function delTr(id){
$.ajax({
			url: 'delJf.htm',
			type: 'GET',
			data: 'id='+id,
			dataType: 'json',
			success: function(data){
			if(data.tag==1){
			$("#tr_re_"+id).remove();
			}
			}
		});
}
