var SC_login={
         islog:0,
         isemail:0,
         isrand:0,
         isrepwd:0,
         islogin:function(){
		 
		  var userName =$.cookie("userName");
		if(userName!=null && userName!="" ){
			//登录成功
			document.getElementById("loginhtml").innerHTML ='<span class="kp-user-haslogin">您好，'+unescape(userName)+'<span class="kp-user-nick"></span> <a href="${scpath}/memberIndex.htm">[会员中心]</a> <a target="_self" href="${scpath}/outlogin.htm">退出登录</a></span>';
		 //$("#loginhtml").html('<span class="kp-user-haslogin">您好，'+userName+'<span class="kp-user-nick"></span> <a href="">[会员中心]</a> <a href="outlogin.htm" target="_self">退出登录</a></span> ');
		 }
               
	       //是否记住用户名
	       var isremember =$.cookie("isremember");
	       var login_count =$.cookie("login_count");
	       var autologin=$.cookie("autologin");
	       if(isremember==1){
	         //选中复选框
		 $("#isremember").attr("checked","checked");
		 $("#login_count").val(login_count);

	       }
               if(autologin==1){
	         //选中复选框
		 $("autologin").attr("checked","checked");
		
	       }
	      },checkEmail:function(type){
	      	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	      	if(!reg.test($("#email").val()))
		    {
		    	SC_login.isemail==1;
		        $("#email_error").html("<font color='red'>邮箱格式不对</font>");
		    }else{
		    	SC_login.isemail==0;
		    	$("#email_error").html("");
		    }
	      },ispwd3:function(type){
	      		$("#pwd").val($("#pwd3").val());
	      }
	      ,isRepwd:function(type){
	       	/**
		        * 检查密码是否重复
		       */
		       var pwd2 = $("#pwd2").val();
		       var pwd = $("#pwd").val();
		       if(pwd!=pwd2&&pwd2!=""&&pwd2!=""){
		       		SC_login.repwd =1;
		       		$("#pwd2").val("");
		       		$("#pwd2_error").html("<font color='red'>两次密码输入不一致</font>");
		       		
		       } else{
		       		SC_login.repwd =0;
		       		$("#pwd2_error").html("");
		       }     
	       },istypePwd:function(type){
	       		if($("#viewpwd").attr("checked")==true){
			       	$("#pwd3").val($("#pwd").val());
			        $("#pwd").hide();
			        $("#pwd3").show();
	       		}else{
			        $("#pwd3").hide();
			        $("#pwd").show();	       		
	       		}
	       },
	       iscountOrEmail:function(type){
	       /**
	        * type 1:登录 2:注册
		* count 用户帐号
		* email 用户邮箱
	       */
	       var login_count=$("#login_count").val(); var email=$("#email").val();$("#login_count_succeed").html("");$("#email_succeed").html("");
	       $.ajax({
			url: 'iscountOrEmail.htm',
			type: 'GET',
			data: {type:type,login_count:login_count,email:email},
			dataType: 'json',
			success: function(data){
			  //登录
			  if(type==1){
			   if(data.tag==0){$("#login_count_error").html("<font color='red'>用户名不存在</font>"); return false;}
			  
			 }
			 if(type==2){
			   if(data.tag==1){$("#login_count_error").html("<font color='red'>用户名已存在</font>"); return false;}
			    if(data.tag==2){$("#email_error").html("<font color='red'>email已存在</font>");return false;}
			 }


		      }
		});
	       }
	       ,checkAll:function(type){
	       		$("input.notnull").each(function(){	
	       		 	if($(this).val()==null||$(this).val()==""){
	       		 		SC_login.islog =1;  
	       		 		var error =	$(this).attr("id")+"_error";
	       		 		if($("#"+error).text()==""||$("#"+error).text().length==0){
		       		 		$(this).addClass("highlight2");		
		       				$("#"+error).removeClass("focus");
		       				$("#"+error).addClass("error");
	       		 			$("#"+error).html("不可以为空");  
	       		 		}		 			 		
	       		 	}
				});
	       		
	       		
	       		$("input.length").each(function(){
	       			var max = $(this).attr("max");	
	       			var val = $(this).val();
	       			var min = $(this).attr("min");	
	       		 	if(max!=""&&val!=""&&val.length>max){
	       		 		SC_login.islog =1;  
	       		 		var error =	$(this).attr("id")+"_error";
	       		 		$("#"+error).html("<font color='red'>长度不能大于"+max+"</font>");       		 			 		
	       		 	}
	       		 	if(min!=""&&val!=""&&val.length<min){
	       		 		SC_login.isrepwd =1;  
	       		 		var error =	$(this).attr("id")+"_error";
	       		 		$("#"+error).html("<font color='red'>长度不能小于"+min+"</font>");       		 			 		
	       		 	}
				});
				$("input.number").each(function(){
	       			var val = $(this).val();
	       			var reg =  /^[0-9]*$/;
			      	if(!reg.test(val))
				    {
				    	SC_login.islog =1;  
	       		 		var error =	$(this).attr("id")+"_error";
	       		 		$("#"+error).html("<font color='red'>只能使用整数</font>");   
				    }
				});
	       },checkAddress:function(type){
	    	   $("select#s_city").each(function(){
	       			if($(this).val()==0){
	       		 		SC_login.islog =1;     
      		 			$("#s_city_error").html("城市不可以为空");  	 			 		
	       		 	}else{
	       		 		$("#s_city_error").html("");       
	       		 	}
				});
	       		$("select#s_province").each(function(){
	       			if($(this).val()==0){
	       		 		SC_login.islog =1;     
      		 			$("#s_province_error").html("省份,");  	 			 		
	       		 	}else{
	       		 		$("#s_province_error").html("");       
	       		 	}
				});
	       },
	       isregcountOrEmail:function(type){
	       /**
	        * type 1:登录 2:注册
		* count 用户帐号
		* email 用户邮箱
	       */
	       var login_count=$("#login_count").val(); 
	       var email=$("#email").val();
	       $.ajax({
			url: 'isregcountOrEmail.htm',
			type: 'GET',
			data: {login_count:login_count,email:email},
			dataType: 'json',
			success: function(data){
			   if(data.tag==1){$("#login_count_error").html("<font color='red'>用户名已存在</font>");SC_login.islog=1; return false;}
			   if(data.tag==2){$("#email_error").html("<font color='red'>email已存在</font>"); SC_login.isemail=1; return false;}
		      }
		});
	       },
	      refresh:function()
               {
         	document.getElementById("authImage").src='authImage?now='+new Date();
              },
		isRand:function(){
				  var authcode=$("#authcode").val();
		 	 $.ajax({
			url: 'isRand.htm',
			type: 'GET',
			data: {authcode:authcode},
			dataType: 'json',
			success: function(data){
			  if(data.tag==0){
			   $("#authcode_error").html("<font color='red'>验证码输入错误!</font>");SC_login.rand=1; return false;
			   }

		      }
			  });
	    },
	    checkpreg:function(){
			//检查输入是否为空
			SC_login.checkAll();
			if(SC_login.islog==0){
				$("#formpersonal").submit();        	
            }else{
	 			return;
	 		}
	  },checkereg:function(){
			//检查输入是否为空
			SC_login.checkAll();
			SC_login.checkAddress();
			if(SC_login.islog==0){
				$("#formcompany").submit();        	
            }else{
	 			return;
	 		}
	  }
 }
 var LoginReg={ 
  isloginReg:function(callback){
  
  $.ajax({
			url: "loginorreg.htm",
			type: 'post',
			data:{},
			dataType: 'html',
			success: function(data){
            	$("body").append(data);
            	var _logpage = jQuery("#-inner-div-");
				var bh = jQuery(document).height();
			    var bw = jQuery(document).width();
			    var ww = $(window).width();
			    var wh = $(window).height();
			    var ds = $(document).scrollTop();
			    var objLeft = (ww - _logpage.width())/2 ;
				var objTop = (wh - _logpage.height())/2 + ds;
				jQuery("#-out-div-").width(bw).height(bh).show();
				_logpage.css("left",objLeft+"px").css("top",objTop+"px").show();
            	$("#loginsubmit").click(function(){LoginReg.login(callback)});
            	$("#registsubmitframe").click(function(){LoginReg.reg(callback)});
		    }
		});
  },
 login:function(callback){
 
    $.ajax({
			url: "islogin.htm",
			type: 'post',
			data:$('#form_login1').serialize(),
			dataType: 'json',
			success: function(data){
              if(data.tag==0){
              	alert("登录失败!!");
              }
              if(data.tag==1){
              	  jQuery("#-inner-div-").hide();
              	  jQuery("#-out-div-").hide();
	              if(callback){callback();}//回调函数
	              }
		      }
		});
	
	},
	reg:function(callback){
   var login_count=$("#login_countreg").val(); 
	       var email=$("#email").val();
	       $("#login_countreg_error").html("");
	       $("#email_error").html("");
	       if(email==''){
		alert("邮箱不能为空!!!");
		return false;
		}
	       if(login_count==''){
		alert("登录名不能为空!!!");
		return false;
		}
	       $.ajax({
			url: 'isregcountOrEmail.htm',
			type: 'GET',
			data: {login_count:login_count,email:email},
			dataType: 'json',
			success: function(data){
			   if(data.tag==1){$("#login_count_error").html("<font color='red'>用户名已存在</font>");return false;}
			   if(data.tag==2){$("#email_error").html("<font color='red'>email已存在</font>");return false;}
		      }
		});
		var pwdreg=$("#pwdreg").val();
		var pwdreg2=$("#pwdreg2").val();
		if(pwdreg!=pwdreg2){
		alert("两次密码输入不一样!!!");
		return false;
		}
		var authcode=$("#authcode").val();
		 	 $.ajax({
			url: 'isRand.htm',
			type: 'GET',
			data: {authcode:authcode},
			dataType: 'json',
			success: function(data){
			  if(data.tag==0){
			   $("#authcode_error").html("<font color='red'>验证码输入错误!</font>"); return false;
			   }

		      }
			  });
		
		
    $.ajax({
			url: "isregmember.htm",
			type: 'post',
			data:$('#form_login2').serialize(),
			dataType: 'json',
			success: function(data){
            if(data.tag==0){
              alert("注册失败!!");
              }
              if(data.tag==1){
              if(callback){callback();}//回调函数
              }
		      }
		});
	
	}

}