package com.rekoe.freemarker.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import freemarker.core.Environment;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@IocBean(name = "pagination_")
public class PaginationDirective implements TemplateDirectiveModel {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Pager pager = (Pager) DirectiveUtils.getObject("pager", params);
		LinkedHashMap localLinkedHashMap = new LinkedHashMap();
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		String pagerUrl = "/art/list?pager.pageNumber=";
		String firstPageUrl = pagerUrl + "1";
		int pageCount = pager.getPageCount();
		int pagerNumber = pager.getPageNumber();
		for (int i = 1; i <= 5; i++) {
			localLinkedHashMap.put(String.valueOf(i), pagerUrl + i);
		}
		String nextPageUrl = "";
		if (pageCount > pagerNumber) {
			nextPageUrl = pagerUrl + (pagerNumber + 1);
		}
		String lastPageUrl = pagerUrl + pageCount;
		// paramWrap.put(DirectiveUtils.PAGER, DEFAULT_WRAPPER.wrap(pager));
		paramWrap.put("pageCount", new SimpleNumber(pageCount));
		paramWrap.put("pageNumber", new SimpleNumber(pagerNumber));
		paramWrap.put("firstPageUrl", new SimpleScalar(firstPageUrl));
		paramWrap.put("prePageUrl", new SimpleScalar(nextPageUrl));
		paramWrap.put("nextPageUrl", new SimpleScalar(nextPageUrl));
		paramWrap.put("lastPageUrl", new SimpleScalar(lastPageUrl));
		paramWrap.put("pageItem", new SimpleHash(localLinkedHashMap));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		body.render(env.getOut());
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
}
