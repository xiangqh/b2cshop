var Sccookie={ 
  //读取COOKIES,n为COOKIE名 
   Get:function(n){ 
   		var re=new RegExp(n+'=([^;]*);?','gi');
   	    var r=re.exec(document.cookie)||[];
   	    return (r.length>1?r[1]:null)
   	  }, 
   Get1:function(n){  
   		var re=new RegExp(n+'=([^;]*);?','gi');  
   		var r=re.exec(document.cookie)||[]; 
   		return unescape(r.length>1?r[1]:null) }, 
   //写入COOKIES,n为Cookie名，v为value // 8.64e7 一天 3.6e6 一小时
   Set:function(n,v,e,p,d,s){
   		var t=new Date; 
   			if(e){
   				t.setTime(t.getTime() + (e*3.6e6));
   			 }
   			document.cookie=n+'='+v+'; '+(!e?'':'; expires='+t.toUTCString())+(!p?'':'; path='+p)+(!d?'':'; domain='+d)+(!s?'':'; secure') 
   		 }, 
   Set1:function(n,v,e,p,d,s){ 
   		var t=new Date; 
   		if(e){ 
   		t.setTime(t.getTime() + (e*8.64e7));
   	 }  
   	 		document.cookie=n+'='+escape(v)+'; '+(!e?'':'; expires='+t.toUTCString())+(!p?'':'; path='+p)+(!d?'':'; domain='+d)+(!s?'':'; secure')
   	  }, 
   Del:function(n,p,d){ 
   		var t=Sccookie.Get(n); 
   		document.cookie=n+'='+(!p?'':'; path='+p)+(!d?'':'; domain='+d)+'; expires=Thu, 01-Jan-70 00:00:01 GMT'; 
   		//alert(document.cookie); 看设置完后的cookies信息
   		return t
	  }
  }; 
  
 var Common = {
   //移除数组中指定项 
   delArr:function(ar,n) { //n表示第几项，从0开始算起。 
   if(n<0) //如果n<0，则不进行任何操作。 
   return ar; 
   else 
   return ar.slice(0,n).concat(ar.slice(n+1,ar.length)); 
   }, 
    /** 添加至购物车
		*id:0,//商品id
		*name:"",//商品名称
		*image:"",//图片地址
		*price:0,//价格
		*point:0,//积分
		*num:0,//数量
		*cateid:0//分类
		*cc:0//尺寸
        */
		addCart:function(id,name,image,price,point,num,cateid,cc) {
		   var carList = Sccookie.Get("carList"); //购物车列表 
		    if(carList!=null && carList!="" && carList!="null") { 
		          if(Common.hasOne(id)) { 
				   carList += "&"+id+"|"+escape(name)+"|"+image+"|"+price+"|"+point+"|"+num+"|"+cateid+"|"+escape(cc); 
				   Sccookie.Set("carList",carList,360,"/");//更新购物车清单 
				   total = Sccookie.Get("total"); //当前车内含有商品的总数 
				   total=total+num; //总数+1 
				   Sccookie.Set("total",total,360,"/"); 
				   } 
		       
		     }else{
		       //第一次添加购物车
		        carList=id+"|"+escape(name)+"|"+image+"|"+price+"|"+point+"|"+num+"|"+cateid+"|"+escape(cc); 
                 //先清理一下
                 Sccookie.Del("carList","/");
	             Sccookie.Set("total",0,360,"/");
	             //添加购物车
                 Sccookie.Set("carList",carList,360,"/");//更新购物车清单 
                 Sccookie.Set("total",num,360,"/"); 
		     }
		},
		//检验购物车内是否已经含有该商品 
   hasOne:function(id){
   var carList = Sccookie.Get("carList"); //车内商品ID列表 
   if(carList.lastIndexOf("&") != -1){
       //更新购物车数量
     var arr=carList.split("&");
     for(i=0;i<arr.length;i++) {
	     if(arr[i].split("|")[0]==id){ 
	     var line=arr[i].split("|");
	     var tempnum=Number(line[5])+1;
	     Common.updateCartNum(id,tempnum);
	     return false;
      	}
      }
    }else if(carList!="null"&&carList!=""){
       if(carList.split("|")[0]==id){
       var line=carList.split("|");
       var tempnum=Number(line[5])+1;
       Common.updateCartNum(id,tempnum);
        return false; 
        }
    }
    return true; 
  },
    //检测结束 
   //移除某商品 
   reMoveOne:function(proid){
   if(!Common.hasOne(proid)){
   //alert(ProIDList);这是购物车的产品列表.
    var carList = Sccookie.Get("carList"); //购物车列表 
   if(carList.lastIndexOf("&") != -1){
   var arr=carList.split("&");
   for(i=0;i<arr.length;i++){
   	if(arr[i].split("|")[0]==proid){
	    var arr2=Common.delArr(arr,i);
	    var tempStr=arr2.join("&");
	    Sccookie.Set("carList",tempStr,360,"/");
	    var t=Sccookie.Get("total");
	    Sccookie.Set("total",t-1,360,"/");
	    return;
    	}
      }
    }else{
	    Sccookie.Del("carList","/");
	    Sccookie.Set("total",0,360,"/");
	    $("#cart_num").html("0");
    	}
    }
   }, //移除物品结束 
   //修改某物品数量 
   updateCartNum:function(id,num){ 
   var carList = Sccookie.Get("carList"); //车内商品ID列表 
  
   if(carList.lastIndexOf("&") != -1) { 
   var arr=carList.split("&"); 
   var sub=Common.getSubPlace(carList,id);//获取该物品在COOKIE数组中的下标位置 
   var arr2=arr[sub].split("|"); 
   arr2[5]=num; 
   var tempStr=arr2.join("|");//由数组重组字符串 
   arr[sub] = tempStr; 
   var newProList = arr.join("&");//由数组重组字符串 
   Sccookie.Set("carList",newProList,360,"/");//更新购物车清单 
   } 
   else { 
   var arr=carList.split("|");
   arr[5]=num;
   var newCartList=arr.join("|");
   Sccookie.Set("carList",newCartList,360,"/");//更新购物车清单 
   //alert(newProList); 
   } 
   }, //修改物品结束 
   //返回指定物品所在数组的下标位置 
   getSubPlace:function(list,proid){var arr=list.split("&");for(i=0;i<arr.length;i++){if(arr[i].split("|")[0]==proid){return i;}}  
   }, //返回产品已购买的数量
   getProductNum:function(list,proid){var arr=list.split("&"); for(i=0;i<arr.length;i++){if(arr[i].substr(0,arr[i].indexOf("="))==proid){var line=arr[i].split("|");return line[1]; break;}}}
   }; 
   
  var Cart_show={
  delAll:function(){
  if(!confirm("确定删除吗？")){
   return false;
   }
  Sccookie.Del("carList","/");
  Cart_show.showConfirm();
  },
  updateProducrNum:function(id,tag){
  var num=$("#id_"+id).val();
  if(tag==1){num=Number(num)+1;}
  if(tag==0){num=Number(num)-1;}
   
if(Number(num)>2000){alert("商品数量不能大于2000!");Cart_show.showConfirm();return false;}
if(Number(num)<=0){alert("商品数量不能为零!");Cart_show.showConfirm();return false;}
   //下面判断是否数量是真正的修改过
   var carList = Sccookie.Get("carList"); 
   var oldpnum;
   if(carList.lastIndexOf("&") != -1) { 
	   var arr=carList.split("&"); 
	   var sub=Common.getSubPlace(carList,id);//获取COOKIE数组中的下标位置 
	   var arr2=arr[sub].split("|");
	   oldpnum = arr2[5];
	}else { 
	   var arr=carList.split("|");
	   oldpnum = arr[5];
   } 
  
	if(oldpnum!=num){ //修改过才给出提示
		Common.updateCartNum(id,num);
		alert("修改成功！");
		Cart_show.showConfirm();
	}	
  },
  //重新购买
  readdcart:function(obj){
  var seft=$(obj);
  var pid=seft.attr("pid");
  var name=seft.attr("name");
  var image=seft.attr("image");
  var price=seft.attr("price");
  var point=seft.attr("point");
  var num=seft.attr("num");
  var cateid=seft.attr("cateid");
  var cc=seft.attr("cc");
  Common.addCart(id,name,image,price,point,num,cateid,cc);
  Cart_show.showConfirm();
  $("#dl_"+id).remove();
  },
  backDelOne:function(id){
     var carList = Sccookie.Get("carList"); //购物车列表 
     var arr=carList.split("&");
      for(i=0;i<arr.length;i++){
       // carList += "&"+id+"|"+escape(name)+"|"+image+"|"+price+"|"+point+"|"+num+"|"+cateid+"|"+escape(cc);
       var lines=arr[i].split("|");
       if(id==lines[0]){
      var delhtml='<dl id="dl_'+id+'"><dd class="bh-clear-title"><a href="showgoods.htm?gs='+lines[0]+'" target="_blank">'+unescape(lines[1])+'</a></dd>'
      +'<dd class="bh-clear-price">￥'+lines[3]+'</dd>'
      +'<dd class="bh-clear-num"><span>'+lines[5]+'</span></dd>'
      +'<dd class="bh-clear-buy"><a href="javascript:void(0);" id="gz_'+lines[0]+'" pid='+lines[0]+' name="'+unescape(lines[1])+'" image="'+lines[2]+'" price='+lines[3]+' point='+lines[4]+' num='+lines[5]+' cateid='+lines[6]+' cc="'+unescape(lines[7])+'" onclick="Cart_show.readdcart(this);">重新购买</a></dd>'
      +'<dd class="bh-clear-guanzhu"><a href="javascript:void(0);" class="att-btn-class" onclick="attentionSaveconfirm('+lines[0]+')"> 关注</a></dd>'
      +'</dl>';
      $("#delhtml").html($("#delhtml").html()+delhtml);
      }
       }
    },
    showCart:function(){
    var len=Sccookie.Get("total");  
   //查询列表
  var con_cart=Sccookie.Get("carList");
  var content="";
   //判断有没有 物品
   
   if(con_cart!=null && con_cart!=""&&con_cart!="null"){
  /**
  *购物车列表:
  */
  var html ='';
  var endhtml='<div class="total"> 共 <strong id="skuCount">5</strong> 件商品 <br/>金额总计： <strong id="totals">367.00</strong> </div><div class="btns"> <a target="_blank" href="addConfirm.htm" class="btn-pay">去结算</a> </div>';
   var totals=0;
  if(con_cart.lastIndexOf("&")!=-1){
  var con_carts=con_cart.split("&");
  var n=0;
  var classn="new";
  for(var i=con_carts.length-1;i>=0;i--){
   var lines=con_carts[i].split("|");
  totals=totals+(lines[3]*lines[5]);
    n++;
  if(n==1){html=html+'<h3>刚加入购物车的商品</h3>';classn="new";$("#goProduct").attr("href","showgoods.htm?gs="+lines[0])}
  if(n==2){html=html+'<h3>您购物车中的其它商品</h3>';classn="old";}
   html=html+'<dl class="'+classn+'"><dt class="p-img"> <a href="showgoods.htm?gs='+lines[0]+'"  target="_blank"> <img style="width:50px;height:50px;" src="'+lines[2]+'" alt=""/> </a> </dt><dd class="p-info"><div class="p-name"> <a href="showgoods.htm?gs='+lines[0]+'" _blank="" target=""> <span style="color: red;"/> '+unescape(lines[1])+' </a> </div><div class="p-price"> <span style="font-weight: bold; color: red;">'+lines[3]+'</span> <em>×'+lines[5]+'</em> </div></dd></dl>';
  }
  $("#cart_content").html(html+endhtml);
  $("#skuCount").html(len);
  $("#totals").html(totals.toFixed(2));
  }else{
  //有一个产品
   var lines=con_cart.split("|");
  totals=totals+(lines[3]*lines[5])
  $("#goProduct").attr("href","showgoods.htm?gs="+lines[0]);
  html=html+'<h3>刚加入购物车的商品</h3>';classn="new";
   html=html+'<dl class="'+classn+'"><dt class="p-img"> <a href="showgoods.htm?gs='+lines[0]+'" _blank="" target=""> <img style="width:50px;height:50px;" src="'+lines[2]+'" alt=""/> </a> </dt><dd class="p-info"><div class="p-name"> <a href="showgoods.htm?gs='+lines[0]+'" _blank="" target=""> <span style="color: red;"/> '+unescape(lines[1])+' </a> </div><div class="p-price"> <span style="font-weight: bold; color: red;">'+lines[3]+'</span> <em>×'+lines[5]+'</em> </div></dd></dl>';
  $("#cart_content").html(html+endhtml);
   $("#skuCount").html(len);
   $("#totals").html(totals.toFixed(2));
  }
  }else{
  $("#cart_content").html("<li>没有产品!!</li>");
 //没有产品
   }
  },
   showConfirm:function(){
   
    var len=Sccookie.Get("total");  
   //查询列表
  var con_cart=Sccookie.Get("carList");
  var content="";
   //判断有没有 物品
   
   if(con_cart!=null && con_cart!=""&&con_cart!="null"){
  /**
  *购物车列表:
  */
  var html ='';
  var endhtml='<div class="total"> 共 <strong id="skuCount">5</strong> 件商品 <br/>金额总计： <strong id="totals">00.00</strong> </div><div class="btns"> <a href="http://cart.360buy.com/cart/cart.html?backurl=http://www.360buy.com/product/617834.html" class="btn-pay">去结算</a> </div>';
 var totals=0;
  if(con_cart.lastIndexOf("&")!=-1){
  var con_carts=con_cart.split("&");
  var n=0;
  
  for(var i=con_carts.length-1;i>=0;i--){
   var lines=con_carts[i].split("|");
  totals=totals+(lines[3]*lines[5]);
    n++;
  if(n==1){$("#goProduct").attr("href","showgoods.htm?gs="+lines[0]);}
   html=html+'<div style="border: 0pt none;" class="item item_selected"><div class="item_form clearfix">'
                +'<input type="hidden" name="ids" value="'+lines[0]+'">'
                  +'<input type="hidden" name="attr" value="'+unescape(lines[7])+'">'
              +'<div class="cell p-number">'+lines[0]+'</div><div class="cell p-goodsimg">'
              +'<div class="p-img"><a target="_blank" href=""><img height="50" width="50" src="'+lines[2]+'"/></a></div></div>'
              +'<div class="cell bh-ptitle">'
              +'<div class="p-name"><a target="_blank"  href="'+lines[0]+'">'+unescape(lines[1])+'</a></div>'
              +'</div>'
              +'<div class="cell p-price"><span class="price">￥'+lines[3]+'</span></div>'
              +'<div class="cell p-promotion">'+lines[4]+'</div>'
              +'<div class="cell p-quantity">'
              +'<div data-bind="" class="quantity-form"> <a class="decrement" href="javascript:void(0);" onclick="Cart_show.updateProducrNum('+lines[0]+',0)">-</a>'
              +'<input type="text" name="counts" onkeyup="toNum(this)" class="quantity-text" id="id_'+lines[0]+'" value="'+lines[5]+'" onblur="Cart_show.updateProducrNum('+lines[0]+',2)" />'
              +' <a class="increment" href="javascript:void(0);" onclick="Cart_show.updateProducrNum('+lines[0]+',1)">+</a> </div>'
              +'</div>'
               +'<div class="cell p-remove"><a href="javascript:void(0);" onclick="Cart_show.delCartPid('+lines[0]+')"  class="cart-remove">删除</a></div>'
                +'</div>'
                 +'</div>';
  }
  $("#product-list").html(html);
  $("#totalp").html(totals.toFixed(2));
  $("#totals_").val(totals.toFixed(2));
  
  }else{
  //有一个产品
   var lines=con_cart.split("|");
  totals=totals+(lines[3]*lines[5])
  $("#goProduct").attr("href","showgoods.htm?gs="+lines[0]);
   html=html+'<div style="border: 0pt none;" class="item item_selected"><div class="item_form clearfix">'
   +'<input type="hidden" name="ids" value="'+lines[0]+'">'
                  +'<input type="hidden" name="attr" value="'+unescape(lines[7])+'">'
              +'<div class="cell p-number">'+lines[0]+'</div><div class="cell p-goodsimg">'
              +'<div class="p-img"><a target="_blank" href=""><img height="50" width="50" src="'+lines[2]+'"/></a></div></div>'
              +'<div class="cell bh-ptitle">'
              +'<div class="p-name"><a target="_blank"  href="'+lines[0]+'">'+unescape(lines[1])+'</a></div>'
              +'</div>'
              +'<div class="cell p-price"><span class="price">￥'+lines[3]+'</span></div>'
              +'<div class="cell p-promotion">'+lines[4]+'</div>'
              +'<div class="cell p-quantity">'
              +'<div data-bind="" class="quantity-form"> <a class="decrement" href="javascript:void(0);" onclick="Cart_show.updateProducrNum('+lines[0]+',0)">-</a>'
              +'<input type="text" name="counts" class="quantity-text" id="id_'+lines[0]+'" value="'+lines[5]+'" onblur="Cart_show.updateProducrNum('+lines[0]+',2)" />'
              +' <a class="increment" onkeyup="toNum(this)" href="javascript:void(0);" onclick="Cart_show.updateProducrNum('+lines[0]+',1)">+</a> </div>'
              +'</div>'
               +'<div class="cell p-remove"><a href="javascript:void(0);" onclick="Cart_show.delCartPid('+lines[0]+')" class="cart-remove">删除</a></div>'
                +'</div>'
                 +'</div>';
  $("#product-list").html(html);
   $("#totalp").html(totals.toFixed(2));
   $("#totals_").val(totals.toFixed(2));
  }
  }else{
  $("#cart_content").html("<li>没有产品!!</li>");
 //没有产品
   }
  },
  delCartPid:function(id){
  if(!confirm("确定删除吗？")){
   return false;
   }
Cart_show.backDelOne(id);
Common.reMoveOne(id);
Cart_show.showConfirm();
}
  };
  function toNum(obj){var s;s=obj.value;s=s.replace(/[^0-9]/g,"");obj.value=s?s:"";}
  
