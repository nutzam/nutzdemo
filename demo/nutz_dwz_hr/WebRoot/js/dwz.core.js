/**
 * @author ZhangHuihua@msn.com
 * 
 */

var DWZ = {
	// sbar: show sidebar
	keyCode: {
		ENTER: 13, ESC: 27, END: 35, HOME: 36,
		SHIFT: 16, TAB: 9,
		LEFT: 37, RIGHT: 39, UP: 38, DOWN: 40,
		DELETE: 46, BACKSPACE:8
	},
	pageInfo: {pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"},
	statusCode: {ok:200, error:300, timeout:301},
	ui:{sbar:true},
	frag:{}, //page fragment
	_msg:{}, //alert message
	_set:{
		loginUrl:"", //session timeout
		loginTitle:"", //if loginTitle open a login dialog
		debug:false
	},
	msg:function(key, args){
		var _format = function(str,args) {
			args = args || [];
			var result = str
			for (var i = 0; i < args.length; i++){
				result = result.replace(new RegExp("\\{" + i + "\\}", "g"), args[i]);
			}
			return result;
		}
		return _format(this._msg[key], args);
	},
	debug:function(msg){
		if (this._set.debug) alert(msg);
	},
	loadLogin:function(){
		if ($.pdialog && DWZ._set.loginTitle) {
			$.pdialog.open(DWZ._set.loginUrl, "login", DWZ._set.loginTitle, {mask:true,width:520,height:260});
		} else {
			window.location = DWZ._set.loginUrl;
		}
	},

	jsonEval:function(data) {
		try{
			if ($.type(data) == 'string')
				return eval('(' + data + ')');
			else return data;
		} catch (e){
			return {};
		}
	},
	ajaxError:function(xhr, ajaxOptions, thrownError){
		if (alertMsg) {
			alertMsg.error("<div>Http status: " + xhr.status + " " + xhr.statusText + "</div>" 
				+ "<div>ajaxOptions: "+ajaxOptions + "</div>"
				+ "<div>thrownError: "+thrownError + "</div>"
				+ "<div>"+xhr.responseText+"</div>");
		} else {
			alert("Http status: " + xhr.status + " " + xhr.statusText + "\najaxOptions: " + ajaxOptions + "\nthrownError:"+thrownError + "\n" +xhr.responseText);
		}
	},
	ajaxDone:function(json){
		if (json.statusCode === undefined && json.message === undefined) { // for iframeCallback
			if (alertMsg) return alertMsg.error(json);
			else return alert(json);
		} 
		if(json.statusCode == DWZ.statusCode.error) {
			if(json.message && alertMsg) alertMsg.error(json.message);
		} else if (json.statusCode == DWZ.statusCode.timeout) {
			if(alertMsg) alertMsg.error(json.message || DWZ.msg("sessionTimout"), {okCall:DWZ.loadLogin});
			else DWZ.loadLogin();
		} else {
			if(json.message && alertMsg) alertMsg.correct(json.message);
		};
	},

	init:function(pageFrag, options){
		var op = $.extend({
				loginUrl:"login.html", loginTitle:null, callback:null, debug:false, 
				statusCode:{}
			}, options);
		this._set.loginUrl = op.loginUrl;
		this._set.loginTitle = op.loginTitle;
		this._set.debug = op.debug;
		$.extend(DWZ.statusCode, op.statusCode);
		$.extend(DWZ.pageInfo, op.pageInfo);
		
		jQuery.ajax({
			type:'GET',
			url:pageFrag,
			dataType:'xml',
			timeout: 50000,
			cache: false,
			error: function(xhr){
				alert('Error loading XML document: ' + pageFrag + "\nHttp status: " + xhr.status + " " + xhr.statusText);
			}, 
			success: function(xml){
				$(xml).find("_PAGE_").each(function(){
					var pageId = $(this).attr("id");
					if (pageId) DWZ.frag[pageId] = $(this).text();
				});
				
				$(xml).find("_MSG_").each(function(){
					var id = $(this).attr("id");
					if (id) DWZ._msg[id] = $(this).text();
				});
				
				if (jQuery.isFunction(op.callback)) op.callback();
			}
		});
	}
};


(function($){
	// DWZ set regional
	$.setRegional = function(key, value){
		if (!$.regional) $.regional = {};
		$.regional[key] = value;
	};
	
	$.fn.extend({
		/**
		 * @param {Object} op: {type:GET/POST, url:ajax请求地址, data:ajax请求参数列表, callback:回调函数 }
		 */
		ajaxUrl: function(op){
			var $this = $(this);
			if ($.fn.xheditor) {
				$("textarea.editor", $this).xheditor(false);
			}
			
			$.ajax({
				type: op.type || 'GET',
				url: op.url,
				data: op.data,
				cache: false,
				success: function(response){
					var json = DWZ.jsonEval(response);
					DWZ.debug("statusCode:"+json.statusCode);
					if (json.statusCode==DWZ.statusCode.timeout){
						alertMsg.error(json.message || DWZ.msg("sessionTimout"), {okCall:function(){
							if ($.pdialog) $.pdialog.checkTimeout();
							if (navTab) navTab.checkTimeout();
	
							DWZ.loadLogin();
						}});
					} 
					
					if (json.statusCode==DWZ.statusCode.error){
						if (json.message) alertMsg.error(json.message);
					} else {
						$this.html(response).initUI();
						if ($.isFunction(op.callback)) op.callback(response);
					}
				},
				error: DWZ.ajaxError
			});
		},
		loadUrl: function(url,data,callback){
			$(this).ajaxUrl({url:url, data:data, callback:callback});
		},
		initUI: function(){
			return this.each(function(){
				if($.isFunction(initUI)) initUI(this);
			});
		},
		/**
		 * adjust component inner reference box height
		 * @param {Object} refBox: reference box jQuery Obj
		 */
		layoutH: function($refBox){
			return this.each(function(){
				var $this = $(this);
				if (! $refBox) $refBox = $this.parents("div.layoutBox:first");
				var iRefH = $refBox.height();
				var iLayoutH = parseInt($this.attr("layoutH"));
				var iH = iRefH - iLayoutH > 50 ? iRefH - iLayoutH : 50;
				
				if ($this.isTag("table")) {
					$this.removeAttr("layoutH").wrap('<div layoutH="'+iLayoutH+'" style="overflow:auto;height:'+iH+'px"></div>');
				} else {
					$this.height(iH).css("overflow","auto");
				}
			});
		},
		hoverClass: function(className){
			var _className = className || "hover";
			return this.each(function(){
				$(this).hover(function(){
					$(this).addClass(_className);
				},function(){
					$(this).removeClass(_className);
				});
			});
		},
		focusClass: function(className){
			var _className = className || "textInputFocus";
			return this.each(function(){
				$(this).focus(function(){
					$(this).addClass(_className);
				}).blur(function(){
					$(this).removeClass(_className);
				});
			});
		},
		inputAlert: function(){
			return this.each(function(){
				
				var $this = $(this);
				
				function getAltBox(){
					return $this.parent().find("label.alt");
				}
				function altBoxCss(opacity){
					var position = $this.position();
					return {
						width:$this.width(),
						top:position.top+'px',
						left:position.left +'px',
						opacity:opacity || 1
					}
				}
				if (getAltBox().size() < 1) {
					if (!$this.attr("id")) $this.attr("id", $this.attr("name") + "_" +Math.round(Math.random()*10000));
					var $label = $('<label class="alt" for="'+$this.attr("id")+'">'+$this.attr("alt")+'</label>').appendTo($this.parent());
					
					$label.css(altBoxCss(1));
					if ($this.val()) $label.hide();
				}
				
				$this.focus(function(){
					getAltBox().css(altBoxCss(0.3));
				}).blur(function(){
					if (!$(this).val()) getAltBox().show().css("opacity",1);
				}).keydown(function(){
					getAltBox().hide();
				});
			});
		},
		isTag:function(tn) {
			if(!tn) return false;
			return $(this)[0].tagName.toLowerCase() == tn?true:false;
		},
		/**
		 * 判断当前元素是否已经绑定某个事件
		 * @param {Object} type
		 */
		isbind:function(type) {
			var _events = $(this).data("events");
			return _events && _events["refChange"];
		}
	});
	
	/**
	 * 扩展String方法
	 */
	$.extend(String.prototype, {
		isPositiveInteger:function(){
			return (new RegExp(/^[1-9]\d*$/).test(this));
		},
		isInteger:function(){
			return (new RegExp(/^\d+$/).test(this));
		},
		isNumber: function(value, element) {
			return (new RegExp(/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/).test(this));
		},
		trim:function(){
			return this.replace(/(^\s*)|(\s*$)|\r|\n/g, "");
		},
		trans:function() {
			return this.replace(/&lt;/g, '<').replace(/&gt;/g,'>').replace(/&quot;/g, '"');
		},
		replaceAll:function(os, ns) {
			return this.replace(new RegExp(os,"gm"),ns);
		},
		replaceTm:function($data) {
			if (!$data) return this;
			return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
				return $data[$1.replace(/[{}]+/g, "")];
			});
		},
		replaceTmById:function(_box) {
			var $parent = _box || $(document);
			return this.replace(RegExp("({[A-Za-z_]+[A-Za-z0-9_]*})","g"), function($1){
				var $input = $parent.find("#"+$1.replace(/[{}]+/g, ""));
				return $input.val() ? $input.val() : $1;
			});
		},
		isFinishedTm:function(){
			return !(new RegExp("{[A-Za-z_]+[A-Za-z0-9_]*}").test(this)); 
		},
		skipChar:function(ch) {
			if (!this || this.length===0) {return '';}
			if (this.charAt(0)===ch) {return this.substring(1).skipChar(ch);}
			return this;
		},
		isValidPwd:function() {
			return (new RegExp(/^([_]|[a-zA-Z0-9]){6,32}$/).test(this)); 
		},
		isValidMail:function(){
			return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(this.trim()));
		},
		isSpaces:function() {
			for(var i=0; i<this.length; i+=1) {
				var ch = this.charAt(i);
				if (ch!=' '&& ch!="\n" && ch!="\t" && ch!="\r") {return false;}
			}
			return true;
		},
		isPhone:function() {
			return (new RegExp(/(^([0-9]{3,4}[-])?\d{3,8}(-\d{1,6})?$)|(^\([0-9]{3,4}\)\d{3,8}(\(\d{1,6}\))?$)|(^\d{3,8}$)/).test(this));
		},
		isUrl:function(){
			return (new RegExp(/^[a-zA-z]+:\/\/([a-zA-Z0-9\-\.]+)([-\w .\/?%&=:]*)$/).test(this));
		},
		isExternalUrl:function(){
			return this.isUrl() && this.indexOf("://"+document.domain) == -1;
		}
	});
})(jQuery);

/** 
 * You can use this map like this:
 * var myMap = new Map();
 * myMap.put("key","value");
 * var key = myMap.get("key");
 * myMap.remove("key");
 */
function Map(){

	this.elements = new Array();
	
	this.size = function(){
		return this.elements.length;
	}
	
	this.isEmpty = function(){
		return (this.elements.length < 1);
	}
	
	this.clear = function(){
		this.elements = new Array();
	}
	
	this.put = function(_key, _value){
		this.remove(_key);
		this.elements.push({key: _key, value: _value});
	}
	
	this.remove = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					this.elements.splice(i, 1);
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	}
	
	this.get = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) { return this.elements[i].value; }
			}
		} catch (e) {
			return null;
		}
	}
	
	this.element = function(_index){
		if (_index < 0 || _index >= this.elements.length) { return null; }
		return this.elements[_index];
	}
	
	this.containsKey = function(_key){
		try {
			for (i = 0; i < this.elements.length; i++) {
				if (this.elements[i].key == _key) {
					return true;
				}
			}
		} catch (e) {
			return false;
		}
		return false;
	}
	
	this.values = function(){
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].value);
		}
		return arr;
	}
	
	this.keys = function(){
		var arr = new Array();
		for (i = 0; i < this.elements.length; i++) {
			arr.push(this.elements[i].key);
		}
		return arr;
	}
}
