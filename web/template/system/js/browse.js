var Browse = { 
 
   intoBrowsePro:function(proidB,pronameB,price,image) {
   if(proidB != "" && pronameB != "") { 
   var BrowseList = cookie.Get("browseList"); //车内商品ID列表 
   if(BrowseList!=null && BrowseList!="" && BrowseList!="null") 
   { 
   if(Browse.hasOneBrowse(proidB)) 
   { 
   BrowseList += "&"+proidB+"|"+escape(pronameB)+"|"+price+"|"+image;
   var lenb=cookie.Get("Totalbrowse");
   if(lenb==6){
   var arrbs=BrowseList.split("&");
   arrbs=arrbs.slice(1,7);
   var temparr=arrbs.join("&");
   Sccookie.Set("browseList",temparr,10,"/");
   Sccookie.Set("Totalbrowse",6,10,"/"); 
   }else{
   Sccookie.Set("browseList",BrowseList,10,"/");
   var total = cookie.Get("Totalbrowse"); //当前车内含有商品的总数 
   total++; //总数+1 
   Sccookie.Set("Totalbrowse",total,10,"/"); 
   }
   } 
   else 
   { 
   //alert("购物车中已含有此商品"); 
   } 
   } 
   else { 
   BrowseList=proidB+"|"+escape(pronameB)+"|"+price+"|"+image;
   Sccookie.Set("browseList",BrowseList,10,"/");//更新购物车清单 
   } 
   //alert(BrowseList); 
   } 
   }, //添加物品结束 
   //重置购物车内个数 
   //检验购物车内是否已经含有该商品 
   hasOneBrowse:function(pid){ 
   BrowseList = Sccookie.Get("browseList"); //车内商品ID列表 
   if(BrowseList.lastIndexOf("&") != -1){
    var arr=BrowseList.split("&");
     for(i=0;i<arr.length;i++) { 
     if(arr[i].split("|")[0]==pid)
     { 
     return false;
      }
      }
      } else if(BrowseList!="null"&&BrowseList!="") 
       {  
       if(BrowseList.split("|")[0]==pid){
        return false; 
        }
       }
        return true; 
       }, //检测结束 
       delAll:function(){
	  if(!confirm("确定删除吗？")){
	   return false;
	   }
	  Sccookie.Del("browseList","/");
	  Browse.showBrowse();
  },
       showBrowse:function(){
        var con_browse=Sccookie.Get("browseList");
        var html ='';
         if(con_browse!=null && con_browse!=""&&con_browse!="null"){
           if(con_browse.lastIndexOf("&")!=-1){
            var con_browse_s=con_browse.split("&");
            for(var i=con_browse_s.length-1;i>=0;i--){
            var lines=con_browse_s[i].split("|");
             html=html+'<div class="bh-m-window3 bh-textCt" style="border:0;"><ul>';
            html=html+'<li class="bh-img"><a target="_blank" href=showgoods.htm?gs='+lines[0]+'><img src="'+lines[3]+'" width="100" height="100" /></a></li>';
            html=html+' <li><a target="_blank" href=showgoods.htm?gs="'+lines[0]+'" class="bh-p-title">'+unescape(lines[1])+'</a></li>';
             html=html+'<li class="bh-textCt"><span class="bh-red">￥'+lines[2]+'</span></li>';
             html=html+'</ul></div>';
           }
         document.getElementById("browse").innerHTML=html;
        }else{
            //有一个产品
             var lines=con_browse.split("|");
             //var lines=con_browse_s[0];
             html=html+'<div class="bh-m-window3 bh-textCt" style="border:0;"><ul>';
           html=html+'<li class="bh-img"><a target="_blank" href=showgoods.htm?gs='+lines[0]+'><img src="'+lines[3]+'" width="100" height="100" /></a></li>';
            html=html+' <li><a target="_blank" href=showgoods.htm?gs="'+lines[0]+'" class="bh-p-title">'+unescape(lines[1])+'</a></li>';
             html=html+'<li class="bh-textCt"><span class="bh-red">￥'+lines[2]+'</span></li>';
             html=html+'</ul></div>';
           document.getElementById("browse").innerHTML=html;
         }
         
         }else{
         document.getElementById("browse").innerHTML="没有最近浏览过新产品!!";
         }
       }
   }; 