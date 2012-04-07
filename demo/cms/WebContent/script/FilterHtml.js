function FilterHTML(){
}
/**
 * 过滤HTML标签
 * @param {Object} str
 * @return {TypeName} 
 */
FilterHTML.prototype.delHTMLTag=function(str){
	
	var script = /^<script[^>]*?>[\s\S]*?<\/script>$/;
	var style = /^<style[^>]*?>[\s\S]*?<\/style>$/;
	var html = /^<[^>]+>$/;
	var space = /^(\r?\n(\s*\r?\n)+)$/;
	var white = /^&nbsp;$/;
	
	var strreplace = str.replace(script,"");
	
	strreplace = strreplace.replace(strreplace,"");
	
	strreplace = strreplace.replace(html,"");
	
	strreplace = strreplace.replace(space,"");
	
	strreplace = strreplace.replace(white,"");
	
	return strreplace;
}
/**
 * 过滤掉HTML标签后截取字符串
 * @param {Object} str
 */
FilterHTML.prototype.substring=function(str,begin,end){
	
	var string = this.delHTMLTag(str);
	
	string = string.substring(begin,end);
	
	return string;
}