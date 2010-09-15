package org.nutz.website.pan.action;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.website.pan.service.FileInfoService;

@At("/f")
@AdaptBy(type=UploadAdaptor.class)
@IocBean
@InjectName
public class FileAction {
	
	@Inject
	private FileInfoService fileInfoService;

	private static final Log LOG = Logs.getLog(FileAction.class);
	
	@At
	public String upload(@Param("file") File tempFile) {
		LOG.info(fileInfoService);
		LOG.info("Get a file --> "+tempFile + " size=" +tempFile.length());
		return "upload 1 file = " + tempFile.getAbsolutePath() + " size=" +tempFile.length();
	}
	
	@SuppressWarnings("unchecked")
	@At
	public String upload_mu(@Param("..") Map<String,Object> allFields) {
		LOG.info(allFields.size());
		int size = 0;
		for (Entry<String, Object> entry : allFields.entrySet()) {
			if (entry.getValue() instanceof List<?>) {
				size = ((List<TempFile>)(entry.getValue())).size();
			} else if ( entry.getValue() instanceof TempFile) {
				size++;
			}
		}
		return "Get "+size +" files";
	}
	
	@At
	public String upload_flash(@Param("filedata") File tempFile) {
		LOG.info("Get a file --> "+tempFile + " size=" +tempFile.length());
		return "upload 1 file = " + tempFile.getAbsolutePath() + " size=" +tempFile.length();
	}
	
	@At
	public String upload_html5(@Param("filedata") File tempFile) {
		LOG.info("Get a file --> "+tempFile + " size=" +tempFile.length());
		return "upload 1 file = " + tempFile.getAbsolutePath() + " size=" +tempFile.length();
	}
	
	public void setFileInfoService(FileInfoService fileInfoService) {
		this.fileInfoService = fileInfoService;
	}
}
