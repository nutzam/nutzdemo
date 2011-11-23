<%@include file="/WEB-INF/jsp/head.jsp"%>
<script language="Javascript" src="${base}/js/jquery-1.3.2.js"></script>
<script language="Javascript">
	(function($) {
		$(document).ready(function() {
			alert('${msg.upload_ok}');
			if ($.browser.mozilla) {
				//alert("mozilla: " + $.browser.version);
				top.location.assign(top.location.href);
			} else {
				//alert("un-mozilla: " + $.browser.version);
				top.location.reload();
			}
		});
	})(window.jQuery);
</script>
<%@include file="/WEB-INF/jsp/tail.jsp"%>