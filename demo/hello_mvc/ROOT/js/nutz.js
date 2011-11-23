(function() {
	if (!window.nutz) {
		// define to String
		var toString = Object.prototype.toString;

		// define function
		var toJson = function(obj) {
			var type = toString.call(obj);
			// alert(type + "\n" + obj);
			/* String */
			if ("[object String]" == type)
				return '"' + obj + '"';
			/* Boolean */
			if ("[object Boolean]" == type)
				return obj ? 'true' : 'false';
			/* Number */
			if ("[object Number]" == type)
				return obj.toString();
			/* Array */
			if ("[object Array]" == type) {
				var re = '[';
				re += toJson(obj[0]);
				for ( var i = 1; i < obj.length; i++) {
					re += ',' + toJson(obj[i]);
				}
				re += ']';
				return re;
			}
			/* Date */
			if ("[object Date]" == type) {
				throw "Don't support date yet!";
			}
			/* Object */
			if ("[object Object]" == type) {
				var pairs = [];
				for ( var key in obj) {
					pairs.push( {
						n : key,
						v : obj[key]
					});
				}
				var p = pairs[0];
				var re = '{';
				re += p.n + ': ' + toJson(p.v);
				for ( var i = 1; i < pairs.length; i++) {
					p = pairs[i];
					re += ',' + p.n + ': ' + toJson(p.v);
				}
				re += '}';
				return re;
			}
			throw "Unknown object type '" + type + "'";
		};

		// Add plugin
		window.nutz = {
			/**
			 * Dump on object
			 */
			dump : function(obj) {
				var s = "{";
				for ( var key in obj) {
					var v = obj[key];
					if (typeof v != "function")
						s = s + "\n\t" + key + " : " + v;
				}
				return s + "\n}";
			},
			/**
			 * Extends window.nutz object
			 */
			extend : function(namespace, funcs) {
				var type = toString.call(namespace);
				/*
				 * like nutz.extend("abc", function(){...});
				 */
				if ("[object String]" == type) {
					this[namespace] = funcs;
				}
				/*
				 * like nutz.extend({a: function(){...}, ...}};
				 */
				else if ("[object Object]" == type) {
					for ( var name in namespace) {
						this[name] = namespace[name];
					}
				}
			},
			/**
			 * Dump JSON String
			 */
			json : function(obj, fmt) {
				return toJson(obj, fmt);
			}
		};
	}
})();