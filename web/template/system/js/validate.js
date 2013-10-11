$(document).ready(function(){
	$("#login_count").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#login_count_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("这里请填入登陆的用户名，用户名最长30个字符"); 
	});
	$("#login_count").blur(function(){
		$(this).removeClass("highlight1");
		if($(this).val()==""||$(this).val().length==0){
			$("#login_count_error").removeClass("focus");
			$("#login_count_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>30){			
			$(this).addClass("highlight2");		
			$("#login_count_error").removeClass("focus");
			$("#login_count_error").addClass("error");
			$("#login_count_error").html("长度不能大于30"); 
			SC_login.islog == 1;
		}else{
			var login_count=$(this).val();
			$.ajax({
				url: 'iscount.htm',
				type: 'GET',
				data: {login_count:login_count},
				dataType: 'json',
				success: function(data){
					//验证用户名
				   if(data.tag==0){
					   $("#login_count_error").removeClass("focus");
					   $("#login_count_error").html("该用户名可以使用"); 	
					   SC_login.islog == 0;
				   }else{
					   $("#login_count").addClass("highlight2");	
					   $("#login_count_error").removeClass("focus");
					   $("#login_count_error").addClass("error");
					   $("#login_count_error").html("该用户名被占用"); 
					   SC_login.islog == 1;
				   }
				}
			});
		}
	});
	$("#pwd").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#pwd_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("6-20位字符，可使用字符和数字的组合"); 
	});
	$("#pwd").blur(function(){
		$(this).removeClass("highlight1");
		$("#pwd_error").removeClass("focus");
		$("#pwd3").val($("#pwd").val());
		if($(this).val()==""||$(this).val().length==0){
			$("#pwd_error").removeClass("focus");
			$("#pwd_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>20){	
			$(this).addClass("highlight2");		
			$("#pwd_error").addClass("error");
			$("#pwd_error").html("长度不能大于20"); 
			SC_login.islog == 1;
		}else if($(this).val().length<6){
			$(this).addClass("highlight2");
			$("#pwd_error").addClass("error");
			$("#pwd_error").html("长度不能小于6"); 
			SC_login.islog == 1;
		}else{
			$("#pwd_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#pwd2").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#pwd2_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("再次输入密码"); 
	});
	$("#pwd2").blur(function(){
		$(this).removeClass("highlight1");
		$("#pwd2_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#pwd2_error").removeClass("focus");
			$("#pwd2_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val()!=$("#pwd").val()){	
			$(this).addClass("highlight2");			
			$("#pwd2_error").addClass("error");
			$("#pwd2_error").html("两次输入密码不一致"); 
			SC_login.islog == 1;
		}else {
			$("#pwd2_error").removeClass("focus");
			$("#pwd2_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#pwd3").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#pwd_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("6-20位字符，可使用字符和数字的组合"); 
	});
	$("#pwd3").blur(function(){
		$(this).removeClass("highlight1");
		$("#pwd_error").removeClass("focus");
		$("#pwd").val($("#pwd3").val());
		if($(this).val()==""||$(this).val().length==0){
			$("#pwd_error").removeClass("focus");
			$("#pwd_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>20){	
			$(this).addClass("highlight2");
			$("#pwd_error").addClass("error");
			$("#pwd_error").html("长度不能大于20"); 
			SC_login.islog == 1;
		}else if($(this).val().length<6){
			$(this).addClass("highlight2");		
			$("#pwd_error").addClass("error");
			$("#pwd_error").html("长度不能小于6"); 
			SC_login.islog == 1;
		}else{
			$("#pwd_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#email").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#email_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请输入邮箱"); 
	});
	$("#email").blur(function(){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		$(this).removeClass("highlight1");
		if($(this).val()==""||$(this).val().length==0){
			$("#email_error").removeClass("focus");
			$("#email_error").html(""); 
			SC_login.islog == 0;
		}else if(!reg.test($("#email").val()))
	    {
      		$(this).addClass("highlight2");
      		$("#email_error").removeClass("focus");
			$("#email_error").addClass("error");
			$("#email_error").html("邮箱格式不对"); 
			SC_login.islog == 1;
	    }else{
	    	var email=$(this).val();
			$.ajax({
				url: 'isEmail.htm',
				type: 'GET',
				data: {email:email},
				dataType: 'json',
				success: function(data){
					//验证邮箱
				   if(data.tag==0){
					   $("#email_error").removeClass("focus");
					   $("#email_error").html("该邮箱可以使用"); 
					   SC_login.islog == 0;
				   }else{
					   $("#email").addClass("highlight2");
					   $("#email_error").removeClass("focus");
					   $("#email_error").addClass("error");
					   $("#email_error").html("该邮箱被占用"); 
					   SC_login.islog == 1;
				   }
				}
			});
	    }
	});
	$("#user_name").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#user_name_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("2-20位字符，可由中文或英文组成"); 
	});
	$("#user_name").blur(function(){
		$(this).removeClass("highlight1");
		$("#user_name_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#user_name_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>20){	
			$(this).addClass("highlight2");		
			$("#user_name_error").addClass("error");
			$("#user_name_error").html("长度不能大于20"); 
			SC_login.islog == 1;
		}else if($(this).val().length<2){
			$(this).addClass("highlight2");
			$("#user_name_error").addClass("error");
			$("#user_name_error").html("长度不能小于2"); 
			SC_login.islog == 1;
		}else{
			$("#user_name_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#telephone").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#telephone_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请填写联系人常用的电话，以便我们联系，如：0527-88105500"); 
	});
	$("#telephone").blur(function(){
		$(this).removeClass("highlight1");
		var reg = /^[0-9]*\-[0-9]*$/;
		$("#telephone_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#telephone_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val()!=""&&!reg.test($(this).val())){	
			$(this).addClass("highlight2");		
			$("#telephone_error").addClass("error");
			$("#telephone_error").html("电话格式不对"); 
			SC_login.islog == 1;
		}else{
			$("#telephone_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#mobile").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#mobile_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请填写联系人常用的手机号码"); 
	});
	$("#mobile").blur(function(){
		$(this).removeClass("highlight1");
		var reg =  /^[0-9]*$/;
		$("#mobile_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#mobile_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val()!=""&&!reg.test($(this).val())){	
			$(this).addClass("highlight2");		
			$("#mobile_error").addClass("error");
			$("#mobile_error").html("手机号码只能用数字"); 
			SC_login.islog == 1;
		}else if($(this).val().length!=0&&$(this).val().length!=11){
			$(this).addClass("highlight2");	
			$("#mobile_error").addClass("error");
			$("#mobile_error").html("手机号码位11位"); 
			SC_login.islog == 1;
		}else{
			$("#mobile_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#tjid").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#tjid_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("如您注册并完成订单，推荐人有机会获得积分"); 
	});
	$("#tjid").blur(function(){
		$(this).removeClass("highlight1");
		var reg =  /^[0-9]*$/;
		$("#tjid_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#tjid_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val()!=""&&!reg.test($(this).val())){	
			$(this).addClass("highlight2");		
			$("#tjid_error").addClass("error");
			$("#tjid_error").html("推荐人id只能用数字"); 
			SC_login.islog == 1;
		}else{
			$("#tjid_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#detail_address").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#detail_address_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请详细填写公司经营地址&nbsp;如：北京海淀区苏州街20号银峰大厦B座3层"); 
	});
	$("#detail_address").blur(function(){
		$(this).removeClass("highlight1");
		$("#detail_address_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#detail_address_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>300){	
			$(this).addClass("highlight2");		
			$("#detail_address_error").addClass("error");
			$("#detail_address_error").html("长度不能超出300"); 
			SC_login.islog == 1;
		}else{
			$("#detail_address_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#authcode").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#authcode_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请输入图片中的字符，不区分大小写"); 
	});
	$("#authcode").blur(function(){
		$(this).removeClass("highlight1");
		$("#authcode_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#authcode_error").html(""); 
		}else{
			var authcode=$("#authcode").val();
		 	$.ajax({
				url: 'isRand.htm',
				type: 'GET',
				data: {authcode:authcode},
				dataType: 'json',
				success: function(data){
					if(data.tag==0){
						$("#authcode").addClass("highlight2");		
						$("#authcode_error").addClass("error");
						$("#authcode_error").html("验证码输入错误!");
						SC_login.islog == 1;
					}else{
						$("#authcode_error").html("验证码正确!");
						SC_login.islog == 0;
					}
				}
			});
		}
	});
	$("#ename").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#ename_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("50字符以内请详细填写公司名称"); 
	});
	$("#ename").blur(function(){
		$(this).removeClass("highlight1");
		$("#ename_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#ename_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>50){	
			$(this).addClass("highlight2");		
			$("#ename_error").addClass("error");
			$("#ename_error").html("长度不能超出50"); 
			SC_login.islog == 1;
		}else{
			$("#ename_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#http").focus(function(){
		$(this).removeClass("highlight2");
		$(this).addClass("highlight1");
		var name = $(this).attr("id")+"_error";
		$("#http_error").removeClass("error");
		$("#"+name).addClass("focus");
		$("#"+name).html("请详细填写公司网址"); 
	});
	$("#http").blur(function(){
		$(this).removeClass("highlight1");
		$("#http_error").removeClass("focus");
		if($(this).val()==""||$(this).val().length==0){
			$("#http_error").html(""); 
			SC_login.islog == 0;
		}else if($(this).val().length>300){	
			$(this).addClass("highlight2");		
			$("#http_error").addClass("error");
			$("#http_error").html("长度不能超出300"); 
			SC_login.islog == 1;
		}else{
			$("#http_error").html(""); 
			SC_login.islog == 0;
		}
	});
	$("#s_province").change(function(){
		$("#s_province_error").html("");
	});
	$("#s_city").change(function(){
		$("#s_city_error").html("");
	});
});
function istypePwd(){
	if($("#viewpwd").attr("checked")==true){
        $("#pwd").hide();
        $("#pwd3").show();
	}else{
        $("#pwd3").hide();
        $("#pwd").show();	       		
	}
}
function refresh()
{
	document.getElementById("authImage").src='authImage?now='+new Date();
}
