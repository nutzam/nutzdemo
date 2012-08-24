package com.rekoe.freemarker.model;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.rekoe.entry.Article;
import com.rekoe.service.ArticleService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 执行时间标签
 * 
 */
@IocBean(name = "art")
public class ArticleDirective implements TemplateDirectiveModel {
	@Inject
	private ArticleService articleService;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String sort = DirectiveUtils.getString("sort", params);
		int count = DirectiveUtils.getInt("count", params);
		List<Article> list = articleService.dao().query(Article.class,
				Cnd.where("article_category_id", "=", sort).limit(count));
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(DirectiveUtils.OUT_LIST, DEFAULT_WRAPPER.wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		body.render(env.getOut());
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
}
