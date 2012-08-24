package com.rekoe.util;

import java.util.Map;

import com.rekoe.freemarker.model.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;

/**
 * 前台工具类
 * 
 * @author liufang
 * 
 */
public class FrontUtils {
	/**
	 * 页面没有找到
	 */
	public static final String PAGE_NOT_FOUND = "tpl.pageNotFound";
	/**
	 * 操作成功页面
	 */
	public static final String SUCCESS_PAGE = "tpl.successPage";
	/**
	 * 操作失败页面
	 */
	public static final String ERROR_PAGE = "tpl.errorPage";
	/**
	 * 信息提示页面
	 */
	public static final String MESSAGE_PAGE = "tpl.messagePage";
	/**
	 * 系统资源路径
	 */
	public static final String RES_SYS = "resSys";
	/**
	 * 模板资源路径
	 */
	public static final String RES_TPL = "res";
	/**
	 * 模板资源表达式
	 */
	public static final String RES_EXP = "${res}";
	/**
	 * 部署路径
	 */
	public static final String BASE = "base";
	/**
	 * 站点
	 */
	public static final String SITE = "site";
	/**
	 * 用户
	 */
	public static final String USER = "user";
	/**
	 * 页码
	 */
	public static final String PAGE_NO = "pageNo";
	/**
	 * 总条数
	 */
	public static final String COUNT = "count";
	/**
	 * 起始条数
	 */
	public static final String FIRST = "first";

	/**
	 * 页面完整地址
	 */
	public static final String LOCATION = "location";
	/**
	 * 页面翻页地址
	 */
	public static final String HREF = "href";
	/**
	 * href前半部（相对于分页）
	 */
	public static final String HREF_FORMER = "hrefFormer";
	/**
	 * href后半部（相对于分页）
	 */
	public static final String HREF_LATTER = "hrefLatter";

	/**
	 * 传入参数，列表样式。
	 */
	public static final String PARAM_STYLE_LIST = "styleList";
	/**
	 * 传入参数，系统预定义翻页。
	 */
	public static final String PARAM_SYS_PAGE = "sysPage";
	/**
	 * 传入参数，用户自定义翻页。
	 */
	public static final String PARAM_USER_PAGE = "userPage";

	/**
	 * 返回页面
	 */
	public static final String RETURN_URL = "returnUrl";

	/**
	 * 国际化参数
	 */
	public static final String ARGS = "args";

	public static void putLocation(Map<String, Object> map, String location) {
		map.put(LOCATION, location);
	}

	/**
	 * 为前台模板设置分页相关数据
	 * 
	 * @param pageNo
	 * @param href
	 * @param urlFormer
	 * @param urlLatter
	 * @param map
	 */
	public static void frontPageData(int pageNo, String href,
			String hrefFormer, String hrefLatter, Map<String, Object> map) {
		map.put(PAGE_NO, pageNo);
		map.put(HREF, href);
		map.put(HREF_FORMER, hrefFormer);
		map.put(HREF_LATTER, hrefLatter);
	}

	/**
	 * 标签中获得页码
	 * 
	 * @param env
	 * @return
	 * @throws TemplateException
	 */
	public static int getPageNo(Environment env) throws TemplateException {
		TemplateModel pageNo = env.getGlobalVariable(PAGE_NO);
		if (pageNo instanceof TemplateNumberModel) {
			return ((TemplateNumberModel) pageNo).getAsNumber().intValue();
		} else {
			throw new TemplateModelException("'" + PAGE_NO
					+ "' not found in DataModel.");
		}
	}

	public static int getFirst(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer first = DirectiveUtils.getInt(FIRST, params);
		if (first == null || first <= 0) {
			return 0;
		} else {
			return first - 1;
		}
	}

	/**
	 * 标签参数中获得条数。
	 * 
	 * @param params
	 * @return 如果不存在，或者小于等于0，或者大于5000则返回5000；否则返回条数。
	 * @throws TemplateException
	 */
	public static int getCount(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer count = DirectiveUtils.getInt(COUNT, params);
		if (count == null || count <= 0 || count >= 5000) {
			return 5000;
		} else {
			return count;
		}
	}

}
