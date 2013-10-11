var Sc_check={ 
    getAddress:function(selId,tag){
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'getcheckAddress.htm',
			type: 'GET',
			data: {selId:selId,tag:tag},
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	
	},
	editAddress:function(tag){
	var selId=$("#selId").val();
	 $.ajax({
			url: 'editAddress.htm',
			type: 'GET',
			data: {selId:selId,tag:tag},
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	
	},
	showAddress:function(){
	 $("#show_address").show();
	  $("#eidt_address").hide();
	},
	delAddress:function(selId,tag,id){
		
	 $.ajax({
			url: 'delAddress.htm',
			type: 'GET',
			data: {selId:selId,tag:tag,id:id},
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	
	},
	saveokAddress:function(){
	var  formurl="saveokAddress.htm";
	 $.ajax({
			url: formurl,
			type: 'GET',
			data:$('#addressForm').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	},
	saveaddress:function(){
	var  formurl="saveAddress.htm";
	var addressval=$("#user_name").val();
	var ttag=0;
	$(".addvals").each(function(){
		var seft=$(this);
		var nameval=seft.attr("val");
		if(nameval==addressval){
		  alert("收货人已经存在!!");
		  ttag=1;
		  return false; 
		 }
		});
		if(ttag==1){
		 return false; 
		}
	 $.ajax({
			url: formurl,
			type: 'GET',
			data:$('#addressForm').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	},
		submitaddress:function(selId,tag,id){
		 var saveorupdate=$("#saveorup").val();
		 var formurl="";
		 if(saveorupdate==0){
		  formurl="updateAddress.htm";
		 }
		 if(saveorupdate==1){
		  formurl="saveAddress.htm";
		 }
	 $.ajax({
			url: formurl,
			type: 'GET',
			data:$('#addressForm').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-collect-people").html(data);
		      }
		});
	
	},
	 newAddress:function(){
	    $("#saveorup").val(1);
		 $("#user_name").val("");
		 $("#addressall").html("");
		  $("#telphone").html("");
		$("#mobile").val("");
	    $("#email").val("");
	   $("#zip").val("");
	   $("#address").val("");

	},
	getPayList:function(paytype,shiptype){
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'getPayList.htm',
			type: 'GET',
			data: {paytype:paytype,shiptype:shiptype},
			dataType: 'html',
			success: function(data){
            $("#bh-paytype").html(data);
		      }
		});
	
	},
	showPay:function(selId,tag){
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'showPay.htm',
			type: 'GET',
			data: {selId:selId,tag:tag},
			dataType: 'html',
			success: function(data){
            $("#bh-paytype").html(data);
            loadcheck();
		      }
		});
	
	},
	savePay:function(){
	 $.ajax({
			url: "saveFPay.htm",
			type: 'post',
			data:$('#form_pay').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-paytype").html(data);
            loadcheck();
		      }
		});
	},
	closePay:function(){
	 $("#pay_show").show();
	  $("#pay_edit").hide();
	},
	getInvoiceList:function(id,inittag){
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'getInvoiceList.htm',
			type: 'GET',
			data: {id:id,inittag:inittag},
			dataType: 'html',
			success: function(data){
            $("#bh-fapiao").html(data);
		      }
		});
	
	}
	,getOneInvoice:function(id,inittag,ptype){
	//查询一个发票信息
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'getOneInvoice.htm',
			type: 'GET',
			data: {id:id,inittag:inittag},
			dataType: 'html',
			success: function(data){
            $("#bh-fapiao").html(data);
		      }
		});
	
	}
	,
	classInvoice:function(){
	 $("#invoice_show").show();
	  $("#invoice_edit").hide();
	},
	/**
	* id:要删除的id ,selid 是当前选中的id
	*/
	delInvoice:function(id,selid){
	//查询一个发票信息
    //var selId=$("#selId").val();
	 $.ajax({
			url: 'delInvoice.htm',
			type: 'GET',
			data: {id:id,selid:selid},
			dataType: 'html',
			success: function(data){
            $("#bh-fapiao").html(data);
		      }
		});
	
	}
	,
		saveInvoice:function(selId,tag,id){
		var person=0;//个人
		var com=0;//公司
		var content=$("#com_id").val();
		
		if($("#invoice_type_p").attr('checked')==true){
		person=1;
		}
		if($("#invoice_type_c").attr('checked')==true){
		com=1;
		}
		var ttag=0;
		
		$(".values").each(function(){
		var seft=$(this);
		var title=seft.attr("val");
		if(person==1&&title=='个人'){
		alert("已经存在!!");
		ttag=1;
		return false; 
		 }
		 if(com==1&&content==title){
		 alert("单位名称已经存在!!");
		 ttag=1;
		return false; 
		 }
		});
		if(ttag==1){
		 return false; 
		}
	 $.ajax({
			url: "saveInvoice.htm",
			type: 'post',
			data:$('#invoice_from').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-fapiao").html(data);
		      }
		});
	
	},
	/**确定保存*/
	saveInvoiceok:function(selId,tag,id){
	 $.ajax({
			url: "saveInvoiceok.htm",
			type: 'post',
			data:$('#invoice_from').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-fapiao").html(data);
		      }
		});
	
	}
	,
	/***
	*type:1普通 2:增值
	* type:1个人 2:单位
	*/
	invoice_dc:function(type,ptype){
	 if(type==1){
	  //普通
	  $(".pt_invoice").show();
	  $(".zz_invoice").hide();
	  $("#com_id").val("个人");
	  if(ptype==1){
	  $("#com_id").hide();
	  }
	  if(ptype==2){
	  $("#com_id").show();
	  }
	 }else{
	 $("#com_id").val("");
	  $(".pt_invoice").hide();
	  $(".zz_invoice").show();
	 }
	
	}
	,
	addOrder:function(selId,tag,id){
	
     var orderform=$("#orderform");
     var invoicepar=$('#invoice_from').serialize();
     var addresspar=$('#addressForm').serialize();
     var form_pay=$('#form_pay').serialize();
     orderform.attr("action", "addOrder.htm?"+addresspar+"&"+invoicepar+"&"+form_pay);
     orderform.attr("method", "post");
     orderform.submit();
     
	
	
	}
	
	
}