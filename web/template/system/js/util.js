String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
function checkNotNull(val){
	return val.trim().length > 0;
}
function getLength(val){
	return val.replace(/[^\x00-\xff]/g,'**').length;
}
