package com.scxxs.cms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.ArticleFile;
import com.scxxs.cms.model.NavModel;
import com.scxxs.cms.model.OneArticle;
import com.scxxs.cms.model.OneArticleFile;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.model.Templete;
import com.scxxs.cms.utils.CheckFileType;
import com.scxxs.cms.utils.FileUtils;
import com.scxxs.cms.utils.SystemContext;

@IocBean
@InjectName
public class OneArticleAction extends BaseAction {
	/**
	 * 查询所有文章且分页
	 * @param currentPage
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticle")
	public View findAll(@Param("currentPage") int currentPage,HttpServletRequest request){
//		OneArticleDaobasicDao = new OneArticleDao(ioc);
		
		
		List<OneArticle> l = basicDao.searchByPage(OneArticle.class, currentPage, SystemContext.PAGE_SIZE, "id");
		
		int count =basicDao.searchCount(OneArticle.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		PageModel<OneArticle> pm = new PageModel<OneArticle>(l,maxPage);
		
		request.setAttribute("pm", pm);
		
		
		return new JspView("admin.oneArticle");
	}
	/**
	 * 添加文章
	 */
	@At("/admin/onearticle/add")
	@Ok("json")
	public String add(@Param(":: onearticle.") OneArticle onearticle,@Param("onearticlefile") String[] onearticlefiles){
		
		if(onearticle.getCreateDate() ==null){
			
			onearticle.setCreateDate(new Date());
			
		}
		
		
		if(onearticle.getModifyDate()==null){
			
			onearticle.setModifyDate(new Date());
		}
		
		onearticle.setShow(true);
		
		
//		OneArticleDaobasicDao = new OneArticleDao(ioc);
		
		boolean flag = false;
			if(onearticle.getId()== 0){
			
				//onearticle =basicDao.save(onearticle);
				List<OneArticleFile> files =  new ArrayList<OneArticleFile>();
				
				for(String str :onearticlefiles){
					OneArticleFile f =  new OneArticleFile();
					f.setFilePath(str);
					f.setName(str);
					
					if(CheckFileType.isPic(str)){
						f.setType(ArticleFile.PICTURE_FILE);
						f.setFilePath("pic/"+f.getFilePath());
					}else{
						f.setType(ArticleFile.DOWN_FILE);
						f.setFilePath("down/"+f.getFilePath());
					}
					files.add(f);
				}
				onearticle.setFiles(files);
				if(files.size()>0){
					onearticle =basicDao.saveWidth(onearticle, "files");
				}else{
					onearticle =basicDao.save(onearticle);
				}
				
			flag = true;
		}else{
			basicDao.update(onearticle);
			flag = true;
		}
			if(flag){
				
				return "[{success:true},"+Json.toJson(onearticle)+"]";
			}
		
		
		
		return "[{success:false}]";
	}
	/**
	 * 上传
	 * @param allFields
	 * @param resp
	 * @param context
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@At("/admin/onearticle/upload")
	@AdaptBy(type=UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	public void shangchuan(@Param("..") Map<String,Object> allFields,HttpServletResponse resp,ServletContext context) throws IOException{
		
		String dizhi = context.getRealPath("/");
		
		String path = dizhi + "onearticle/";
		StringBuilder sb = new StringBuilder("{file:'");
		
		String p = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		for (Entry<String, Object> entry : allFields.entrySet()) {
			if (entry.getValue() instanceof List<?>) {
			
				List<TempFile> files = (List<TempFile>)(entry.getValue());
				
				for(TempFile tf:files){
					File file =tf.getFile();
					if(CheckFileType.isPic(file.getName())){
						//图片文件存放在 onearticle/pic 目录下
						FileUtils.moveFile(file, path+"pic/"+p+file.getName());
					}else{
						//下载文件存放在onearticle/down目录下
						FileUtils.moveFile(file,  path+"down/"+p+file.getName());
					}
					sb.append(p+file.getName());
					sb.append(",");
				}
				
			} else if (entry.getValue() instanceof TempFile) {
				TempFile tf = (TempFile)entry.getValue();

				File file =tf.getFile();
				
				if(CheckFileType.isPic(file.getName())){
					//图片文件存放在 article/pic 目录下
					FileUtils.moveFile(file, path+"pic/"+p+file.getName());
				}else{
					//下载文件存放在article/down目录下
					FileUtils.moveFile(file,  path+"down/"+p+file.getName());
				}
				
				sb.append(p+file.getName());
				sb.append(",");
			}
		}
		String str = sb.toString();

		int dot = str.lastIndexOf(",");
		if(dot!=-1){
			str = str.substring(0, dot);
		}
		str += "'}";
		resp.setContentType("text/html");
		resp.getWriter().print(str);
		
		
	}
	/**
	 * 查找导航信息
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticle/findnav")
	@Ok("json")
	public String findnav(){
//		NavModelDao nvadao = new NavModelDao(ioc);
		
		StringBuffer buffer = new StringBuffer("[");
		List<NavModel> list = basicDao.search(NavModel.class, "id");
		for(NavModel nvalist :list){
			
			buffer.append("{id:'"+nvalist.getId()+"',navname:'"+nvalist.getNavName()+"'},");
			
		}
		String resutlt =buffer.substring(0, buffer.length()-1)+"]";
		return resutlt;
	}
	/**
	 * 查询显示风格
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticle/findstyle")
	@Ok("json")
	public String findstyle(){
//		TempleteDao tdao = new TempleteDao(ioc);
		
		StringBuffer buffer = new StringBuffer("[");
		
		List<Templete> list = basicDao.search(Templete.class, "id");
		for(Templete lists :list){
			
			buffer.append("{id:'"+lists.getId()+"',templetname:'"+lists.getTempleteName()+"'},");
			
		}
		String result = buffer.substring(0, buffer.length()-1)+"]";
		return result;
		
	}
	/**
	 * 删除一条数据
	 * @param id
	 * @param currentPage
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticle/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage){
//		OneArticleDaobasicDao = new OneArticleDao(ioc);
		
		
		int count =basicDao.searchCount(OneArticle.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		StringBuffer buffer = new StringBuffer("[");
		if(maxPage>1){
			
			List<OneArticle> list =basicDao.searchByPage(OneArticle.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			for(OneArticle lists :list){
				
				buffer.append(Json.toJson(lists));
				break;
			}
			
		}
		buffer.append("]");
		
		if(basicDao.delById(id, OneArticle.class)){
			
			return buffer.toString();
		}
		return null;
	}
	@At("/admin/onearticle/delByIds")
	@Ok("json")
	public String dels(@Param("ids") String ids,
			@Param("currentPage") int currentPage, @Param("size") int size){
//		OneArticleDaobasicDao = new OneArticleDao(ioc);
		
		int count =basicDao.searchCount(OneArticle.class);
		int maxPage =basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		String str ="";
		StringBuffer  buffer =  new StringBuffer("[");
		
		if(maxPage > 1){
			List<OneArticle> list =basicDao.searchByPage(OneArticle.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for(OneArticle ll :list){
				
				if(i==size){
					break;
				}else{
					buffer.append(Json.toJson(ll));
					buffer.append(",");
					i++;
				}
				
			}
			
		}
		
		str = buffer.toString();
		int dot = str.lastIndexOf(",");
		if(dot != -1){
			str = str.substring(0, dot);
			
		}
		basicDao.deleteByIds(OneArticle.class, ids);
		
		return str + "]";
	}
	/**
	 * 修改
	 * @param id
	 * @param ioc
	 * @return
	 */
	@At("/admin/onearticle/update")
	@Ok("json")
	public String update(@Param("id") int id){
		
//		OneArticleDaobasicDao = new OneArticleDao(ioc);
		
		OneArticle onearticle =basicDao.find(id, OneArticle.class);
		
		if(onearticle != null){
			
			return Json.toJson(onearticle);
		}
		
		return "{id:0}";
	}
	
	

}
