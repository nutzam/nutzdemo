<script type="text/javascript">
$().ready( function() {
	var $pager = $("#pager");
	$pager.pager({
		pagenumber: ${obj.pager.pageNumber},
		pagecount: ${obj.pager.pageCount},
		buttonClickCallback: $.gotoPage
	});
})
</script>
<span id="pager"></span>
<input type="hidden" name="pageNumber" id="pageNumber" value="${obj.pager.pageNumber}" />