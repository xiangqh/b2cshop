String.prototype.trim = function(){return this.replace(/^\s+|\s+$/g,"");}
function dialogAlert(title,msg,_okf){
	art.dialog({
							id:'alerts',
							lock:true,
							width:'200px',
							height:'60px',
							title:title,
						    content:msg,
						    yesFn:function(){
						    	if(_okf)
						    		_okf();
						    }
						});
}
function dialogConfirm(title,msg,_okf,_nof){
	art.dialog({
							id:'alertsConfirm',
							lock:true,
							width:'200px',
							height:'60px',
							title:title,
						    content:msg,
						    yesFn:function(){
								if(_okf)
						    		_okf();
						    },
						    noFn:function(){
								if(_nof)
						    		_nof();
						    }
						});
}