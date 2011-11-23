package com.scxxs.cms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
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

import com.scxxs.cms.model.Download;
import com.scxxs.cms.model.NavModel;
import com.scxxs.cms.model.PageModel;
import com.scxxs.cms.utils.SystemContext;

@IocBean
@InjectName
public class DownloadAction extends BaseAction{
	/**
	 * 查询所有资源
	 * @return
	 */
	@At("/admin/download")
	public View findAll(@Param("currentPage") int currentPage,HttpServletRequest request){
		
		
		List<Download> l = basicDao.searchByPage(Download.class, currentPage, SystemContext.PAGE_SIZE,"id");
		
		int count = basicDao.searchCount(Download.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		PageModel<Download> pm = new PageModel<Download>(l,maxPage);
		request.setAttribute("pm", pm);
		
		
		return new JspView("admin.download");
	}
	/**
	 * 查找模块
	 * @param ioc
	 * @return
	 */
	@At("/admin/download/findmodel")
	@Ok("json")
	public String findmodel(){
		NavModel nm = basicDao.findByCondition(NavModel.class, "navName", "资源下载");
		
		Cnd condition =Cnd.where("pid","=",nm.getId());
		List<NavModel> list = basicDao.search(NavModel.class, condition);
		
		StringBuffer buffer = new StringBuffer("[");
		for(NavModel lists :list){
			
			buffer.append("{id:'"+lists.getId()+"',name:'"+lists.getNavName()+"'},");
		}
		String result = buffer.substring(0,buffer.length()-1)+"]";
		
		return result;
	}
	/**
	 * 上传资源
	 * @param tf
	 * @param ioc
	 * @param context
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@At("/admin/download/upload")
	@AdaptBy(type=UploadAdaptor.class,args={"./tmp"})
	public String upload(@Param("downurl") TempFile tf,
			ServletContext context,HttpServletResponse response) throws IOException{
		File file = tf.getFile();
		
		String filename = file.getName(); //获取文件名
		
		String relpath = context.getRealPath("/");
		
		String dir="download";
		

		String uppath = dir+"/"+filename;
		
		boolean flag = true;
		
		File dirs = new File(relpath+dir);
		
		if(!dirs.exists()){
			flag = dirs.mkdirs();
		}
		
		File newFile = new File(relpath+uppath);
		
		String data="[{ret:0}]";
		
		if(newFile.exists()){
			data =  "[{ret:1}]";
		}else{
			if(flag&&file.renameTo(newFile)){
				data = "[{ret:2},{file:'"+uppath+"'}]";
			}
			
		}
		response.setContentType("text/html");
		response.getWriter().print(data);
		return null;
	}
	@At("/admin/download/uploadimage")
	@AdaptBy(type=UploadAdaptor.class,args={"./tmp"})
	public String uploadiamge(@Param("downimage") TempFile tf,
			ServletContext context,HttpServletResponse response) throws IOException{
		File file = tf.getFile();
		
		String filename = file.getName(); //获取文件名
		
		String relpath = context.getRealPath("/");
		
		String dir="downloadImages";
		

		String uppath = dir+"/"+filename;
		
		boolean flag = true;
		
		File dirs = new File(relpath+dir);
		
		if(!dirs.exists()){
			flag = dirs.mkdirs();
		}
		
		File newFile = new File(relpath+uppath);
		
		String data="[{ret:0}]";
		
		if(newFile.exists()){
			data =  "[{ret:1}]";
		}else{
			if(flag&&file.renameTo(newFile)){
				data = "[{ret:2},{file:'"+uppath+"'}]";
			}
			
		}
		response.setContentType("text/html");
		response.getWriter().print(data);
		return null;
	}
	/**
	 * 添加
	 * @param down
	 * @param ioc
	 * @return
	 */
	@At("/admin/download/add")
	@Ok("json")
	public String add(@Param("::download.") Download down){
//		DownloadDao dao = new DownloadDao(ioc);
		
		if(down.getTime() ==null){
			
			down.setTime(new Date());
			
		}
		
		boolean flag = false;
		
		if(down.getId() == 0){
			basicDao.save(down);
			flag = true;
			
		}else{
			flag = basicDao.update(down);
		}
		if(flag){
			return "[{success:true},"+Json.toJson(down)+"]";
		}
		
		return "[{success:false}]";
	}
	/**
	 * 删除一条数据
	 * @param id
	 * @param currentPage
	 * @param ioc
	 * @param context
	 * @return
	 */
	@At("/admin/download/del")
	@Ok("json")
	public String del(@Param("id") int id,@Param("currentPage") int currentPage,ServletContext context){
		
//		DownloadDao dao =  new DownloadDao(ioc);
		
		int count = basicDao.searchCount(Download.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		String path = context.getRealPath("/");
		Download f = basicDao.find(id, Download.class);
		
		StringBuffer buffer = new StringBuffer("[");
		
		if(maxPage>1){
			List<Download> list = basicDao.searchByPage(Download.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			for(Download lists :list){
				
				buffer.append(Json.toJson(lists));
				break;
			}
		}
		buffer.append("]");
		
		if(basicDao.delById(id, Download.class)){
			File file = new File(path+"/"+f.getUrl());
			if(file.exists()){
				
				file.delete();
			}
			return buffer.toString();
		}
		return null;
	
	}
	/**
	 * 删除多条数据
	 * @param ids
	 * @param ioc
	 * @param currentPage
	 * @param size
	 * @param context
	 * @return
	 */
	@At("/admin/download/delByIds")
	@Ok("json")
	public String dels(@Param("ids") String ids,
			@Param("currentPage") int currentPage, @Param("size") int size,ServletContext context){
//		DownloadDao dao =  new DownloadDao(ioc);
		
		int count = basicDao.searchCount(Download.class);
		int maxPage = basicDao.maxPageSize(count, SystemContext.PAGE_SIZE);
		
		
		
		String str ="";
		StringBuffer  buffer =  new StringBuffer("[");
		
		if(maxPage > 1){
			List<Download> list = basicDao.searchByPage(Download.class, (currentPage+1), SystemContext.PAGE_SIZE, "id");
			int i = 0;
			for(Download ll :list){
				
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
		
		String [] ii =ids.split(",");
		
		String path = context.getRealPath("/");
		for(int i=0;i<ii.length;i++){
			
			Download f = basicDao.find(Integer.parseInt(ii[i]), Download.class);
			
			File file = new File(path+"/"+f.getUrl());
			if(file.exists()){
				file.delete();
				
			}
			
		}
		basicDao.deleteByIds(Download.class, ids);
	
		
		return str + "]";
	}
	/**
	 * 资源下载
	 * @param request
	 * @param context
	 * @param response
	 * @param url
	 * @return
	 * @throws IOException
	 */
	@At("/download/down")
	public String down(HttpServletRequest request,ServletContext context,HttpServletResponse response,
			@Param("id") int id)  throws IOException{
//		DownloadDao dao = new DownloadDao(ioc);
		Download l = basicDao.find(id, Download.class);
		
		response.setContentType("text/html;charset=UTF-8");
		
		String path = context.getRealPath("/"+l.getUrl()); //得到资源所对应的物理地址
		
		File file = new File(path);	
		if(file.exists()){	
			
			//根据该路径创建文件对象
			InputStream in = new FileInputStream(file);		//创建文件字节输入流
			OutputStream os = response.getOutputStream();	//创建输出流对象
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(file.getName().getBytes("GBK"),"ISO-8859-1"));	//设置应答头信息
			response.addHeader("Content-Length", file.length() + "");
			response.setCharacterEncoding("GBK");		
			response.setContentType("application/octet-stream");
			int data = 0;
			while ((data = in.read()) != -1) {				//循环读取文件
				os.write(data);								//向指定目录中写文件
			}
			os.close();										//关闭流
			in.close();
		}else{
			PrintWriter out = response.getWriter();
			out.print("没有该资源!或该资源已被管理员删除！");
		}
		return null;
	}

}
