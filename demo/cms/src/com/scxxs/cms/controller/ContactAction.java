package com.scxxs.cms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.view.JspView;

import com.scxxs.cms.model.Contact;
import com.scxxs.cms.utils.CheckFileType;
import com.scxxs.cms.utils.FileUtils;

@IocBean
@InjectName
public class ContactAction extends BaseAction {

	@At("/admin/contact/find")
	public View find(HttpServletRequest req) {
		req.setAttribute("contact", basicDao.find(1, Contact.class));
		return new JspView("admin.contact");
	}

	@At("/admin/contact/contact")
	@Ok("json")
	public String contact(@Param("::con.") Contact con,
			ServletContext context) {
		// ContactDao dao=new ContactDao(ioc);
		Contact c = basicDao.find(1, Contact.class);
		File file = new File(context.getRealPath("/") + "contact/"
				+ c.getImgurl());
		if (file.exists()) {
			file.delete();
		}
		boolean flag = false;
		if (con.getId() == 0) {
			basicDao.save(con);
			flag = true;
		} else {
			flag = basicDao.update(con);
		}
		return "{success:" + flag + "}";
	}

	/**
	 * 上传附件
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@At("/admin/contact/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	public void upload(@Param("..") Map<String, Object> allFields,
			HttpServletResponse resp, ServletContext context)
			throws IOException {

		String prefix = context.getRealPath("/");
		String path = prefix + "contact/";

		StringBuilder sb = new StringBuilder("{file:'");

		String p = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		for (Entry<String, Object> entry : allFields.entrySet()) {
			if (entry.getValue() instanceof List<?>) {

				List<TempFile> files = (List<TempFile>) (entry.getValue());

				for (TempFile tf : files) {
					File file = tf.getFile();
					if (CheckFileType.isPic(file.getName())) {
						// 图片文件存放在 article/pic 目录下
						FileUtils.moveFile(file,
								path + "pic/" + p + file.getName());
					}
					sb.append(p + file.getName());
					sb.append(",");
				}

			} else if (entry.getValue() instanceof TempFile) {
				TempFile tf = (TempFile) entry.getValue();

				File file = tf.getFile();

				if (CheckFileType.isPic(file.getName())) {
					// 图片文件存放在 article/pic 目录下
					FileUtils
							.moveFile(file, path + "pic/" + p + file.getName());
				}

				sb.append(p + file.getName());
				sb.append(",");
			}
		}

		String str = sb.toString();

		int dot = str.lastIndexOf(",");
		if (dot != -1) {
			str = str.substring(0, dot);
		}
		str += "'}";

		resp.setContentType("text/html");
		resp.getWriter().print(str);

	}

}
