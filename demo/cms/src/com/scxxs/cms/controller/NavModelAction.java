package com.scxxs.cms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.nutz.castor.Castors;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.ExpGroup;
import org.nutz.dao.Expression;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.dao.BasicDao;
import com.scxxs.cms.dao.MessageTypeDao;
import com.scxxs.cms.model.Article;
import com.scxxs.cms.model.Contact;
import com.scxxs.cms.model.Download;
import com.scxxs.cms.model.Group;
import com.scxxs.cms.model.Message;
import com.scxxs.cms.model.MessageType;
import com.scxxs.cms.model.NavModel;
import com.scxxs.cms.model.OneArticle;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.model.Templete;
import com.scxxs.cms.model.WebConfig;
import com.scxxs.cms.model.selector.TemplateType;
import com.scxxs.cms.utils.CheckFileType;
import com.scxxs.cms.utils.SystemContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 导航配置
 * 
 * @author Administrator
 * 
 */
@IocBean
public class NavModelAction extends BaseAction {

	private static final Logger logger = Logger.getLogger(NavModelAction.class);
	
	@Inject
	MessageTypeDao messageTypeDao;
	
//	NavModelDao basicDao;
	
//	TempleteDao basicDao;
//	WebConfigDao basicDao;
//	NavModelDao basicDao;
//	ArticleDao basicDao;
//	WebConfigDao basicDao;
//	OneArticleDao basicDao;

	@At("/admin/navmodel/json")
	@Ok("json")
	public String listAll(Ioc ioc, HttpServletRequest req) {

		Object o = req.getSession().getAttribute("nav");
		
		String nav = null;
		
		if (o != null) {
			nav =  (String) o;
		} else {
			nav = n(ioc);
			req.getSession().setAttribute("nav", nav);
		}
		
		return nav;
	}
	/**
	 * 生成树形的json导航
	 * @param ioc
	 * @return
	 */
	private String n(Ioc ioc){
		
		
		Expression e = Cnd.exp("pid", "=", 0);

		// 查询出所有父导航的数据
		List<NavModel> models = basicDao.search(NavModel.class, Cnd.where(e)
				.desc("sortNumber"));

		StringBuilder sb = new StringBuilder("[{");
		sb
				.append("'id':0,'text':'网站导航','iconCls':'icon-ok','state':'open','children':[");
		for (NavModel model : models) {
			sb.append("{");
			sb.append("'id':").append(model.getId()).append(",");
			sb.append("'text':'").append(model.getNavName()).append("',");
			sb.append("'iconCls':'icon-ok'");
			// 获取关联数据
			model = basicDao.findLink(model, "children");
			List<NavModel> children = model.getChildren();
			if (children != null && children.size() > 0) {
				sb.append(",'state':'open'");
				sb.append(",'children':[")
						.append(toTreeJson(children, basicDao)).append("]");
			}
			sb.append(",'attributes':{");
			sb.append("'tid':").append(model.getTid()).append(",");
			sb.append("'sortNumber':").append(model.getSortNumber())
					.append(",");
			sb.append("'indexNav':").append(model.isIndexNav()).append(",");
			sb.append("'showNav':").append(model.isShowNav()).append(",");
			sb.append("'url':'").append(model.getUrl()).append("'");
			sb.append("}");
			sb.append("},");
		}

		String str = sb.toString();

		sb = null;

		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}
		
		return str + "]}]";
	}
	
	@At("/admin/navmodel")
	@Ok("jsp:admin.nav")
	public void forward() {

	}

	/**
	 * 把List转换成Json数据
	 * 
	 * @param models
	 * @return
	 */
	private String toTreeJson(List<NavModel> models, BasicDao dao) {

		StringBuilder sb = new StringBuilder();
		for (NavModel model : models) {
			sb.append("{");
			sb.append("'id':").append(model.getId()).append(",");
			sb.append("'text':'").append(model.getNavName()).append("',");
			sb.append("'iconCls':'icon-ok'");
			// 获取关联数据
			model = dao.findLink(model, "children");
			List<NavModel> children = model.getChildren();
			if (children != null && children.size() > 0) {
				sb.append(",'state':'open'");
				sb.append(",'children':[").append(toTreeJson(children, dao))
						.append("]");
			}

			sb.append(",'attributes':{");
			sb.append("'tid':").append(model.getTid()).append(",");
			sb.append("'sortNumber':").append(model.getSortNumber())
					.append(",");
			sb.append("'url':'").append(model.getUrl()).append("'");
			sb.append("}");
			sb.append("},");
		}

		String str = sb.toString();

		sb = null;

		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}

		return str;
	}

	/**
	 * 添加导航菜单
	 * 
	 * @param ioc
	 * @return
	 */
	@At("/admin/navmodel/add")
	@Ok("json")
	public String add(@Param("::nav.") NavModel nav, Ioc ioc,HttpServletRequest req) {

//		NavModelDao dao = new NavModelDao(ioc);
		boolean flag = false;
		if (nav.getId() == 0) {
			nav = basicDao.save(nav);
			flag = true;
		} else {
			// 设置父级数据的id
			if (nav.getPid() == 0) {
				nav.setPid(basicDao.find(nav.getId(), NavModel.class).getPid());
			}
			flag = basicDao.update(nav);
		}
		
		req.getSession().removeAttribute("nav");
		req.getSession().setAttribute("nav", n(ioc));
		
		StringBuilder sb = new StringBuilder("{");

		if (flag) {
			sb.append("'id':").append(nav.getId()).append(",");
			sb.append("'text':'").append(nav.getNavName()).append("',");
			sb.append("'iconCls':'icon-ok',");
			sb.append("'checked':true");
			return sb.toString() + "}";
		}

		return sb.toString() + "}";
	}

	/**
	 * 删除一条数据
	 * 
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/navmodel/del")
	@Ok("json")
	public String del(@Param("id") int id, Ioc ioc,HttpServletRequest req) {

//		NavModelDao dao = new NavModelDao(ioc);
		
		if (basicDao.delById(id, NavModel.class)) {
			
			req.getSession().removeAttribute("nav");
			req.getSession().setAttribute("nav", n(ioc));
			
			return "{success:true}";
		}
		
		return "{success:false}";
	}

	/**
	 * 根据条件修改指定字段
	 * 
	 * @param ioc
	 * @param id
	 * @param pid
	 * @return
	 */
	@At("/admin/navmodel/update")
	@Ok("json")
	public String update(Ioc ioc, @Param("id") int id, @Param("pid") int pid) {

//		NavModelDao dao = new NavModelDao(ioc);

		if (basicDao.update(NavModel.class, Chain.make("pid", pid), Cnd.where("id","=", id))) {
			return "{success:true}";
		}
		return "{success:false}";

	}

	/**
	 * 生成头部文件
	 * 
	 * @param ioc
	 * @param template
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@At("/admin/nav/top")
	@Ok("Json")
	@Fail("Json")
	public String buildTop(Ioc ioc, @Param("template") int id,
			@Param("position") String position,
			ServletContext context,
			HttpServletRequest req)
			throws IOException, TemplateException {

		

		String path = context.getRealPath("/");

		Templete t = basicDao.find(id, Templete.class);
		String filepath = path + t.getFilePath();

		File file = new File(filepath);

		if (file.exists()) {
			if (CheckFileType.isFreeMarkerTemplate(filepath)) {
				
				FileOutputStream fos = null;
				
				Configuration cfg = new Configuration();
				// 设置加载模板路径
				cfg.setDirectoryForTemplateLoading(new File(path + "upload/"));

				String name = t.getFilePath();
				int dot = name.lastIndexOf("/");

				if (dot != -1) {
					name = name.substring(dot + 1);
				}

				Template template = cfg.getTemplate(name, "UTF-8");

				Map<String, Object> root = new HashMap<String, Object>();
				root.put("ctx", context.getContextPath());
				root.put("site", basicDao.find(1, WebConfig.class));

				List<NavModel> mainModels = basicDao.search(NavModel.class, Cnd.where("pid", "=", 0));
				
				if ("top".equalsIgnoreCase(position)) {
					root.put("navmodel", mainModels);
					fos = new FileOutputStream(new File(path+ "upload/" + position + ".html"));

				} else if ("right".equalsIgnoreCase(position)) {
					
					//获取新闻数据
					List<Article> newses = getArticle(ioc,103,5,req);
					//获取通知数据
					List<Article> notices = getArticle(ioc,104,5,req);
					
					root.put("newses", newses);
					root.put("notices", notices);
					
					fos = new FileOutputStream(new File(path+ "upload/" + position + ".html"));

				} else if ("left".equalsIgnoreCase(position)) {
					for (NavModel model : mainModels) {
						model = this.fetch(model, basicDao);
						root.put("navs", model);
						root.put("id", model.getId());
						fos = new FileOutputStream(new File(path + "upload/" + model.getId() + ".html"));
						Writer out = new OutputStreamWriter(fos, "UTF-8");
						template.process(root, out);
						out.close();
						fos.close();
					}
				}
				if(fos!=null&&!"left".equalsIgnoreCase(position)){
					Writer out = new OutputStreamWriter(fos, "UTF-8");
					template.process(root, out);
					out.close();
					fos.close();
				}
				logger.debug("处理FreeMarker模板...模版名称为:" + name);
				return "{success:true}";
			} else {
				logger.debug("还没有处理...");
			}

		}

		return "{success:false}";
	}
	
	@SuppressWarnings("unchecked")
	private List<Article> getArticle(Ioc ioc,int pid,int dataSize,HttpServletRequest req){
		
		
		Expression e1 = Cnd.where("show", "=", 1);
		
		List<NavModel> modules = null;
		if (pid == 103) {
			Object o = req.getSession().getAttribute("modules");
			if (o == null) {
				modules = basicDao.search(NavModel.class, Cnd.where("pid", "=", pid));
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

			Expression e = Cnd.exp("navmodel_id", "in",Castors.me().castTo(ids, int[].class));

			datas = basicDao.searchByRelation(Article.class, "t_article_nav","article_id", Cnd.where(e), Cnd.exps(e1), "createDate", 1,dataSize);

		} else {
			datas = basicDao.searchByRelation(Article.class, "t_article_nav","article_id", Cnd.where("navmodel_id", "=", pid), Cnd.exps(e1),"createDate", 1, dataSize);
		}
		
		return datas;
	}
	
	private List<Integer> getIds(List<NavModel> modules) {

		List<Integer> ids = new ArrayList<Integer>();
		for (NavModel module : modules) {
			ids.add(module.getId());
		}

		return ids;
	}
	/**
	 * 生成底部文件
	 * 
	 * @param ioc
	 * @param context
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@At("/admin/nav/bottom")
	@Ok("json")
	@Fail("json")
	public String buildBotton(Ioc ioc, ServletContext context)
			throws IOException, TemplateException {

		String path = context.getRealPath("/");

		Configuration cfg = new Configuration();
		// 设置加载模板路径
		cfg.setDirectoryForTemplateLoading(new File(path + "upload/"));

		Template template = cfg.getTemplate("bottom.ftl", "UTF-8");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("ctx", context.getContextPath());

		WebConfig c = basicDao.find(1, WebConfig.class);

		root.put("site", c);

		FileOutputStream fos = new FileOutputStream(new File(path
				+ "upload/bottom.html"));
		Writer out = new OutputStreamWriter(fos, "UTF-8");
		template.process(root, out);
		out.close();
		fos.close();

		return "{success:true}";
	}

	/**
	 * 访问数据
	 * 
	 * @param navid
	 * @param ioc
	 * @param currentPage
	 * @param req
	 * @param deep
	 * @return
	 */
	@At("/nav")
	@Fail("jsp:error.404")
	public View getArticles(
	// 导航id
			@Param("navid") int navid, Ioc ioc,
			// 当前页
			@Param("currentPage") int currentPage,

			HttpServletRequest req,
			// deep 深度，表示要查询数据的深度
			@Param("deep") int deep,
			// 最顶级的模块id
			@Param("parent") int pid,
			// 文章详细id
			@Param("articleid") int articleid) {

//		NavModelDao dao = new NavModelDao(ioc);

		NavModel model = basicDao.find(navid, NavModel.class);

		// 把导航放到页面上以便动态使用
		if (pid != 0) {
			req.setAttribute("navsec", pid);
		} else {
			req.setAttribute("navsec", navid);
		}
		// 获取模板类型 查询数据
		model = basicDao.findLink(model, "template");

		if (deep != 0) {
			TemplateType type = model.getTemplate().getType();
			req.setAttribute("model", model);
			setDataForView(type, model, req, ioc, currentPage, articleid);

			return new JspView(getTemplateFile(model.getTemplate()
					.getFilePath()));

		} else {

			model = basicDao.findLink(model, "children");

			List<NavModel> children = model.getChildren();

			if (children != null && children.size() > 0) {

				NavModel child = children.get(0);
				child = basicDao.findLink(child, "template");
				child = basicDao.findLink(child, "children");

				if (child.getChildren() == null
						|| child.getChildren().size() == 0) {

					req.setAttribute("model", child);
					setDataForView(child.getTemplate().getType(), child, req,
							ioc, currentPage, articleid);
					return new JspView(getTemplateFile(child.getTemplate()
							.getFilePath()));
				} else {
					children = child.getChildren();
					if (children != null && children.size() > 0) {
						child = children.get(0);
						child = basicDao.findLink(child, "template");

						req.setAttribute("model", child);
						setDataForView(child.getTemplate().getType(), child,
								req, ioc, currentPage, articleid);

						return new JspView(getTemplateFile(child.getTemplate()
								.getFilePath()));
					}
				}

			} else if (model.getTemplate() != null) {

				req.setAttribute("model", model);
				setDataForView(model.getTemplate().getType(), model, req, ioc,
						currentPage, articleid);

				return new JspView(getTemplateFile(model.getTemplate()
						.getFilePath()));

			}
		}

		// 没有子项也没有模板，那么就转到404页面
		return new JspView("error.404");
	}

	/**
	 * 设置文章数据
	 * 
	 * @param type
	 * @param model
	 * @param req
	 */
	private void setDataForView(TemplateType type, NavModel model,
			HttpServletRequest req, Ioc ioc, int currentPage, int articleid) {
		if (type.compareTo(TemplateType.ABOUT) == 0) {
			// 查询一篇文章数据

			Expression e1 = Cnd.where("show", "=", 1);

			ExpGroup group = Cnd.exps(e1).and("navid", "=", model.getId());

			OneArticle article = basicDao.findByCondition(OneArticle.class, Cnd
					.where(group));

			req.setAttribute("article", article);

			logger.debug("处理单页数据....");

		} else if (type.compareTo(TemplateType.CACAT) == 0) {
			// 查询联系我们数据
//			ContactDao basicDao = new ContactDao(ioc);
			Contact cat = basicDao.find(1, Contact.class);

			req.setAttribute("cat", cat);

			logger.debug("处理联系我们....");

		} else if (type.compareTo(TemplateType.DETAIL) == 0) {
			// 查询多篇文章详细数据
//			ArticleDao basicDao = new ArticleDao(ioc);
			Article article = basicDao.find(articleid, Article.class);
			req.setAttribute("article", article);

		} else if (type.compareTo(TemplateType.LIST) == 0) {
			if (currentPage == 0) {
				currentPage = 1;
			}
			// 查询多篇文章数据
//			ArticleDao basicDao = new ArticleDao(ioc);

			ExpGroup group = Cnd.exps("show", "=", 1);

			List<Article> articles = basicDao.searchByRelation(Article.class,
					"t_article_nav", "article_id", Cnd.where("navmodel_id",
							"=", model.getId()), group, "createDate",
					currentPage, SystemContext.PAGE_SIZE);

			List<Article> temp = new ArrayList<Article>();
			if (articles != null) {
				for (Article a : articles) {
					a = basicDao.findLink(a, "files");
					temp.add(a);
				}
			}
			articles = null;

			int count = basicDao.searchCount(Article.class, "t_article_nav",
					"article_id", Cnd.where("navmodel_id", "=", model.getId()),
					group, "createDate");

			int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);

			req.setAttribute("articles", temp);
			req.setAttribute("maxPage", maxPage);

			logger.debug("处理文章信息...");

		} else if (type.compareTo(TemplateType.MESSAGE) == 0) {
			// 留言
			if (currentPage == 0) {
				currentPage = 1;
			}
//			MessageDao basicDao = new MessageDao(ioc);
			Integer navid = model.getId();
			Cnd condition = Cnd.where("navid", "=", navid);
			req.setAttribute("navid", navid);
			MessageType mest = messageTypeDao.findByCondition(MessageType.class,
					condition);
			Expression e = Cnd.exp("navid", "=", navid);
			int count = basicDao.searchCount(Message.class, Cnd.where(e));
			int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
			List<Message> list = basicDao.searchByPage(Message.class, Cnd.where(e)
					.desc("insertTime"), currentPage, SystemContext.PAGE_SIZE);
			PageModel<Message> pm = new PageModel<Message>(list, maxPage);
			req.setAttribute("mess", pm);
			req.setAttribute("mest", mest);
			logger.debug("处理留言信息....");
		} else if (type.compareTo(TemplateType.DOWNLOAD) == 0) {
			// 资源下载
//			DownloadDao basicDao = new DownloadDao(ioc);
			Cnd condition = Cnd.where("modelid", "=", model.getId());
			List<Download> downloadlist = basicDao.searchByPage(Download.class,
					condition, currentPage, SystemContext.PAGE_SIZE);
			int downcount = basicDao.searchCount(Download.class, condition);
			int downmaxPage = basicDao.maxPageSize(downcount,
					SystemContext.PAGE_SIZE);
			req.setAttribute("downloadlist", downloadlist);
			req.setAttribute("maxPage", downmaxPage);

			logger.debug("处理下载信息....");

		} else if (type.compareTo(TemplateType.GROUP) == 0) {
//			GroupDao dao = new GroupDao(ioc);
			List<Group> groups = basicDao.search(Group.class, "sortNumber");
			req.setAttribute("groups", groups);
			logger.debug("处理小组信息....");
		}
	}

	private String getTemplateFile(String file) {
		int dot = file.lastIndexOf(".");
		file = file.substring(0, dot);

		return file;
	}

	// 获取所有的导航和对应的模板信息
	private NavModel fetch(NavModel model, BasicDao dao) {
		model = dao.findLink(model, "children");
		model = dao.findLink(model, "template");
		List<NavModel> models = model.getChildren();
		if (models != null && models.size() > 0) {
			List<NavModel> temp = new ArrayList<NavModel>();
			for (NavModel m : models) {
				m = fetch(m, dao);
				temp.add(m);
			}
			model.setChildren(temp);
		}
		return model;
	}
}
