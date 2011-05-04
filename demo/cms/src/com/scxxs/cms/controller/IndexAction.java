package com.scxxs.cms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.castor.Castors;
import org.nutz.dao.Cnd;
import org.nutz.dao.util.cri.SqlExpression;
import org.nutz.dao.util.cri.SqlExpressionGroup;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.Article;
import com.scxxs.cms.model.Group;
import com.scxxs.cms.model.IndexPic;
import com.scxxs.cms.model.Link;
import com.scxxs.cms.model.NavModel;

@IocBean
@InjectName
public class IndexAction extends BaseAction {
	/**
	 * 查询首页数据
	 * 
	 * @param ioc
	 * @param req
	 * @return
	 */
	@At("/")
	@Fail("jsp:error.404")
	public View index(HttpServletRequest req) {

		// 新闻
		buildData("newses", 103, 11, req);
		// 通知
		//buildData("notices", 104, 6, req, ioc);
		// 查询报告
		buildData("reports", 105, 6, req);

		// 查询首页切换图片
		List<IndexPic> pics = basicDao.searchByPage(IndexPic.class, 1, 4,
				"sortNumber");
		req.setAttribute("pics", pics);

		// 查询学术小组信息
		List<Group> groups = basicDao.search(Group.class, "sortNumber");
		req.setAttribute("groups", groups);
		
		List<Link> link1 = basicDao.search(Link.class, Cnd.where("type", "=", 1));
		List<Link> link2 = basicDao.search(Link.class, Cnd.where("type", "=", 2));
		List<Link> link3 = basicDao.search(Link.class, Cnd.where("type", "=", 3));
		
		req.setAttribute("link1", link1);
		req.setAttribute("link2", link2);
		req.setAttribute("link3", link3);
		
		return new JspView("upload.index");
	}

	/**
	 * 查询首页需要的数据放到HttpServletRequest里面
	 * 
	 * @param key
	 *            存放的key
	 * @param pid
	 *            最近的父级ID
	 * @param dataSize
	 *            查询的数据量大小
	 * @param req
	 *            HttpServletRequest
	 * @param ioc
	 *            NutzIoc容器
	 */
	@SuppressWarnings("unchecked")
	private void buildData(String key, int pid, int dataSize,
			HttpServletRequest req) {

//		SqlExpression e1 = Cnd.where("top", "=", 1);
//		SqlExpression e2 = Cnd.where("show", "=", 1);
//		SqlExpression e3 = Cnd.where("shenhe", "=", 1);

		SqlExpressionGroup group = Cnd.where("top", "=", 1).where().and("show", "=", 1).and("shenhe", "=", 1);
		List<NavModel> modules = null;
		if (pid == 103) {
			Object o = req.getSession().getAttribute("modules");
			if (o == null) {
				modules = basicDao
						.search(NavModel.class, Cnd.where("pid", "=", pid));
				req.getSession().setAttribute("modules", modules);
			} else {
				modules = (List<NavModel>) o;
			}
		} else {
			// 查询新闻子模块
			modules = basicDao.search(NavModel.class, Cnd.where("pid", "=", pid));
		}

		List<Article> datas = null;
		if (modules != null && modules.size() > 0) {

			List<Integer> ids = getIds(modules);

			Cnd e = Cnd.where("navmodel_id", "in",
					Castors.me().castTo(ids, int[].class));

			datas = basicDao.searchByRelation(Article.class, "t_article_nav",
					"article_id", e, Cnd.exps(group), "article_createDate DESC , article_color", 1,
					dataSize);

		} else {
			datas = basicDao.searchByRelation(Article.class, "t_article_nav",
					"article_id", Cnd.where("navmodel_id", "=", pid), group,
					"article_createDate DESC , article_color", 1, dataSize);
		}

		req.setAttribute(key, datas);

	}

	/**
	 * 生成XML文件
	 * 
	 * @param req
	 * @param resp
	 * @param ioc
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@At("/index/xml")
	public void xml(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//		Expression e1 = Cnd.where("top", "=", 1);
//		Expression e2 = Cnd.where("show", "=", 1);
//		Expression e3 = Cnd.where("shenhe", "=", 1);
//		Expression e4 = Cnd.where("hasPic", "=", 1);

		SqlExpressionGroup group = Cnd.where("top", "=", 1).where().and("show", "=", 1).and("shenhe", "=", 1).and("hasPic", "=", 1);

		List<NavModel> modules = null;

		Object o = req.getSession().getAttribute("modules");

		if (o == null) {
			modules = basicDao.search(NavModel.class, Cnd.where("pid", "=", 103));
			req.getSession().setAttribute("modules", modules);
		} else {
			modules = (List<NavModel>) o;
		}

		List<Integer> ids = getIds(modules);

		SqlExpression e = Cnd.exp("navmodel_id", "in",
				Castors.me().castTo(ids, int[].class));

		List<Article> articles = basicDao.searchByRelation(Article.class,
				"t_article_nav", "article_id", Cnd.where(e), group,
				"createDate", 1, 4);

		StringBuilder sb = new StringBuilder(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		sb.append("<data>\r\n");
		sb.append("\t<config>\r\n");
		sb.append("\t\t<roundCorner>0</roundCorner>\r\n");
		sb.append("\t\t<autoPlayTime>5</autoPlayTime>\r\n");
		sb.append("\t\t<isHeightQuality>false</isHeightQuality>\r\n");
		sb.append("\t\t<blendMode>normal</blendMode>\r\n");
		sb.append("\t\t<transDuration>1</transDuration>\r\n");
		sb.append("\t\t<windowOpen>_self</windowOpen>\r\n");
		sb.append("\t\t<btnSetMargin>auto 5 5 auto</btnSetMargin>\r\n");
		sb.append("\t\t<btnDistance>20</btnDistance>\r\n");
		sb.append("\t\t<titleBgColor>0xffcc00</titleBgColor>\r\n");
		sb.append("\t\t<titleTextColor>0x000000</titleTextColor>\r\n");
		sb.append("\t\t<titleBgAlpha>.75</titleBgAlpha>\r\n");
		sb.append("\t\t<titleMoveDuration>1</titleMoveDuration>\r\n");
		sb.append("\t\t<btnAlpha>.7</btnAlpha>\r\n");
		sb.append("\t\t<btnTextColor>0x000000</btnTextColor>\r\n");
		sb.append("\t\t<btnDefaultColor>0xffffff</btnDefaultColor>\r\n");
		sb.append("\t\t<btnHoverColor>0x2374c2</btnHoverColor>\r\n");
		sb.append("\t\t<btnFocusColor>0xffcc00</btnFocusColor>\r\n");
		sb.append("\t\t<changImageMode>click</changImageMode>\r\n");
		sb.append("\t\t<isShowBtn>true</isShowBtn>\r\n");
		sb.append("\t\t<isShowTitle>true</isShowTitle>\r\n");
		sb.append("\t\t<scaleMode>noBorder</scaleMode>\r\n");
		sb.append("\t\t<transform>top</transform>\r\n");
		sb.append("\t\t<isShowAbout>false</isShowAbout>\r\n");
		sb.append("\t\t<titleFont>微软雅黑</titleFont>\r\n");
		sb.append("\t</config>\r\n");
		sb.append("\t<channel>\r\n");
		if (articles != null&&articles.size()>0) {
			for (Article article : articles) {
				article = basicDao.findLink(article, "files");
				sb.append("\t\t<item>\r\n");
				sb.append("\t\t\t<title>").append(article.getTitle()).append("</title>\r\n");
				sb.append("\t\t\t<link>").append("article/detail?nav=102&model=103&article=").append(article.getId()).append("</link>\r\n");
				sb.append("\t\t\t<image>");
				if (article.getFiles() != null && article.getFiles().size() > 0) {
					sb.append("article/").append(
							article.getFiles().get(0).getFilePath());
				} else {
					sb.append("template/images/newspic.jpg");
				}
				sb.append("</image>\r\n");
				sb.append("\t\t\t<time>").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getCreateDate())).append("</time>\r\n");
				sb.append("\t\t</item>\r\n");
			}
		}else{
			sb.append("\t\t<item>\r\n");
			sb.append("\t\t\t<title>").append("暂无图片新闻").append("</title>\r\n");
			sb.append("\t\t\t<link>").append("#").append("</link>\r\n");
			sb.append("\t\t\t<image>").append("template/images/newspic.jpg").append("</image>\r\n");
			sb.append("\t\t\t<time>").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("</time>\r\n");
			sb.append("\t\t</item>\r\n");
		}
		sb.append("\t</channel>\r\n");
		sb.append("</data>\r\n");

		resp.getWriter().print(sb.toString());

	}

	private List<Integer> getIds(List<NavModel> modules) {

		List<Integer> ids = new ArrayList<Integer>();
		for (NavModel module : modules) {
			ids.add(module.getId());
		}

		return ids;
	}
}
