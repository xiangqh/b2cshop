var LoginReg={ 
  isloginReg:function(){
  
  $.ajax({
			url: "loginorreg.htm",
			type: 'post',
			data:{},
			dataType: 'html',
			success: function(data){
            $("#kkkkk").html(data);
		      }
		});
  },
 login:function(){
 
    $.ajax({
			url: "mlogin.htm",
			type: 'post',
			data:$('#form_login').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-paytype").html(data);
		      }
		});
	
	},
	reg:function(){
 
    $.ajax({
			url: "mlogin.htm",
			type: 'post',
			data:$('#form_reg').serialize(),
			dataType: 'html',
			success: function(data){
            $("#bh-paytype").html(data);
            loadcheck();
		      }
		});
	
	}

}