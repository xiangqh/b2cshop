/**
 * _isDialog:是否启动ArtDialog弹出提示,false为alert提示
 * _for:页面绑定信息提示的控件，如果没有指定_for属性，那么用dialog提示，否则HTML显示
 */

var _isDialog = true;
function validator(componentObject){
	var _arrs = getElements(componentObject);
	var _count = _arrs.length;
	var validator,__class,clss,_for,_start;
	for(var i=0;i<_count;i++){
		validator = null;
		_for = null;
		_start = 0;
		__class = _arrs[i].getAttribute("class");
		if(__class && __class.indexOf("_vdt:") != -1){
			//是否存在_vdt
			if((_start = __class.indexOf("_vdt:"))!= -1){
				validator = __class.substring(_start+6,__class.indexOf("}",_start));
				//是否存在_for
				if((_start = __class.indexOf("_for:{"))!= -1){
					_for = __class.substring(_start+6,__class.indexOf("}",_start));
					document.getElementById(_for).innerHTML = "";
				}
			}
		}
		if(validator){
			var validators=splitMethods(validator);
			var validatorMethod,params,rtn;
			for(var j=0;j<validators.length;j++)			{
				styles=validators[j];
				validatorMethod=findMethod(styles);
				params=findParams(styles);
				rtn=validatorCheck(_arrs[i],validatorMethod,params,_for);
				if(!rtn){
					return rtn;
				}
			}
		}
	}
	return true;
}

function getElements(componentObject){
	var _input = componentObject.getElementsByTagName("input");
	var _select = componentObject.getElementsByTagName("select");
	var _arrs = new Array();
	var num = 0;
	if(_input){
		var _inputCount = _input.length;
		for(var i=0;i<_inputCount;i++){
			_arrs[num++] = _input[i];
		}
	}
	if(_select){
		var _selectCount = _select.length;
		for(var i=0;i<_selectCount;i++){
			_arrs[num++] = _select[i];
		}
	}
	return _arrs;
}

function splitMethods(validator){
	var validators=validator.split("|");
	return validators;
}

function validatorCheck(validatorObject,validatorType,params,__for){
	validatorType = validatorType.toUpperCase();
	switch(validatorType) {
		case "CHECKNOTNULL":
		return checkNotNull(validatorObject,params[0],__for);
		break;
		case "CHECKINTEGER":
		return checkInteger(validatorObject,params[0],__for);
		break;
		case "CHECKFLOAT":
		return checkFloat(validatorObject,params[0],__for);
		break;
		case "INTRANGE":
		return checkIntegerRange(validatorObject,params[0],params[1],params[2],__for);
		break;
		case "FLOATRANGE":
		return checkFloatRange(validatorObject,params[0],params[1],params[2],__for);
		break;
		case "MINLENGTH":
		return checkMinLength(validatorObject,params[0],params[1],__for);
		break;
		case "MAXLENGTH":
		return checkMaxLength(validatorObject,params[0],params[1],__for);
		break;
		case "CHECKALLCHINESE":
		return checkAllChinese(validatorObject,params[0],__for);
		break;
		case "CHECKEMAIL":
		return checkEmail(validatorObject,params[0],__for);
		break;
	default:return false;
	}
}
//获得校验类型
function findMethod(validator)
{
	return validator.substring(0,validator.indexOf("("));
}
//获得校验参数
function findParams(validator)
{
	var param=validator.substring(validator.indexOf("(")+1,validator.lastIndexOf(")"));
	var params = [];
	if (/^matchRegExp\(/i.test(validator)) {
		var index = param.indexOf(",");
		params[0] = param.substring(0, index);
		var parameter = param.substring(index+1, param.length);
		var last = parameter.lastIndexOf(",");
		if (last == -1) {
			params[1] = parameter;
		} else {
			var flag = parameter.substring(last+1, parameter.length);
			if (!/[^img]/i.test(flag)) {
				params[1] = parameter.substring(0, last);
				params[2] = flag;
			} else {
				params[1] = parameter;
			}
		}
	} else {
		params=param.split(",");
	}
	return params;
}

/**
*去字符串空格
*@param s 传入的字符串参数
*/
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
/**
*前匹配
*/
String.prototype.startWith = function(s){
		return (new RegExp('^'+s)).test(this);
}
/**
*后匹配
*/
String.prototype.endWith = function(s){
		return (new RegExp(s+"$")).test(this);
}
function validatorAlert(desc,__for){
	if(__for){
		document.getElementById(__for).innerHTML = desc;
	}else{
		if(_isDialog){
			dialogAlert("提示",desc);
		}else{
			alert(desc);
		}
	}
	
}
/**
*函数校验此框输入的数据不为空,返回的值为真和假,true和false;
*Object目标对象,Desc中文的描述.
*/
function checkNotNull(object,desc,__for){
	 if(object.value.trim().length==0){
		 validatorAlert(desc+"不能为空！",__for);
		 object.focus();
		 return false;
	 }else{
		return true;
	 }
}
/**
*函数校验此框输入的是否为integer型的数据,返回的值为真和假,true和false;
*object目标对象,desc中文的描述.
*/
function checkInteger(object,desc,__for) {
	var _value =object.value.trim();
	var flag = true;

	if(_value.charAt(0) == "0" && _value.length > 1){
		flag = false;
	}else{
		flag = /^(\+|-)?\d+$/.test(_value);
	}
	if(!flag){
		validatorAlert(desc+"的值必须为一个整数，请修改！",__for);
		object.focus();
        return false;
	}
	return flag;
}
/**
*函数校验此框输入的是否为float型的数据,返回的值为真和假,true和false;
*object目标对象,desc中文的描述.
*/
function checkfloat(object,desc,__for) {
	var _value =object.value.trim();
	var flag = true;
	//00.000..  00打头
	if(/^(\+|-)?00+(\.\d+)?$/.test(_value)){
		flag = false;
	}else{
		if(!(/^(\+|-)?\d+\.\d+$/.test(_value))){
			validatorAlert(desc+"的值必须为一个小数，请修改！",__for);
			object.focus();
			return false;
		}
	}
	
	return flag;
}
/**
*函数校验此框输入的是否为int型的数据,同时校验是否在值范围内,返回的值为真和假,true和false;
*object目标对象,desc中文的描述.min最小值，max 最大值
*/
function checkIntegerRange(object,desc,min ,max ,__for) {
	var _value =object.value.trim();
	var flag = true;

	if(_value.charAt(0) == "0" && _value.length > 1){
		flag = false;
	}else{
		flag = /^(\+|-)?\d+$/.test(_value);
	}
	if(!flag){
		validatorAlert(desc+"的值必须为一个整数，请修改！",__for);
		object.focus();
        return false;
	}else{
		if(parseInt(_value) < min || parseInt(_value) > max){
			validatorAlert(desc+"的值必须在数值"+min+"和"+max+"之间！",__for);
			object.focus();
			return false;
		}
	}
	return flag;
}

/**
*函数校验此框输入的是否为int型的数据,同时校验是否在值范围内,返回的值为真和假,true和false;
*object目标对象,desc中文的描述.min最小值，max 最大值
*/
function checkFloatRange(object,desc,min ,max ,__for) {
	var _value =object.value.trim();
	var flag = true;
	if(/^(\+|-)?00+(\.\d+)?$/.test(_value)){
		flag = false;
	}else{
		if(!(/^(\+|-)?\d+\.\d+$/.test(_value))){
			validatorAlert(desc+"的值必须为一个小数，请修改！",__for);
			object.focus();
			return false;
		}else{
			if(parseFloat(_value) < min || parseFloat(_value) > max){
			validatorAlert(desc+"的值必须在数值"+min+"和"+max+"之间！",__for);
			object.focus();
			return false;
		}
		}
	}
	return flag;
}

/**
*函数校验此框输入的是否小于设定长度,返回的值为真和假,true和false;
*object目标对象,desc中文的描述,length最小长度
*/
function checkMinLength(object,desc,length,__for){
	var _value=object.value.trim();
	if(_value.length > 0 && _value.replace(/[^\x00-\xff]/g,'**').length < length){
		validatorAlert(desc+"的值必须大于"+length+"位长度！",__for);
		object.focus();
		return false;
	}
	return true;
}

/**
*函数校验此框输入的是否超过设定长度,返回的值为真和假,true和false;
*object目标对象,desc中文的描述,length最大长度
*/
function checkMaxLength(object,desc,length,__for){
	var _value=object.value.trim();
	//双字节为两位，只包含中文，其他双字节文字不能计算
	if(_value.length > 0 && _value.replace(/[^\x00-\xff]/g,'**').length > length){
		validatorAlert(desc+"的值必须小于"+length+"位长度！",__for);
		object.focus();
		return false;
	}
	return true;
}

/**
*函数判断输入的是否为全中文
*object 传入的表单对象,desc 描述
*/
function checkAllChinese(object,desc,__for){
	var _value=object.value.trim();
	if(!(/^[\u4e00-\u9fa5]*$/.test(_value))){
		validatorAlert(desc+"的值中存在非全中文！",__for);
        object.focus();
		return false;
	}
	return true;
}

/**
*函数校验此框输入的是否为email型的数据,返回的值为真和假,true和false;
*object目标对象,desc中文的描述.
*/
function checkEmail(object,desc,__for){
	var _value=object.value.trim();
	if(!(/^(.)+\.(.)+@(.)+\.(.)+$/.test(_value))){
		validatorAlert(desc+"的值邮箱格式不正确！",__for);
        object.focus();
		return false;
	}
	return true;
}