package yhp.module;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.VoidAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.upload.TempFile;

@IocBean
public class UploadModule {

	private static final Log log = Logs.get();

	@At("/upload/normal")
	@AdaptBy(args = { "ioc:upload" })
	public Object upload(TempFile tempFile) {
		Map<String, Object> re = new HashMap<String, Object>();
		if (tempFile != null)
			re.put("ok", true);
		else
			re.put("ok", false);
		return re;
	}

	@At("/upload/html5")
	@AdaptBy(type = VoidAdaptor.class)
	public Object uploadHtml5(HttpServletRequest req) {
		Map<String, Object> re = new HashMap<String, Object>();
		try {
			File file = File.createTempFile("nutzmvc", "upload");
			Files.write(file, req.getInputStream());
			if (log.isDebugEnabled())
				log.debug("Upload success!! File save to "
						+ file.getAbsolutePath());
			re.put("ok", true);
		} catch (IOException e) {
			if (log.isInfoEnabled())
				log.info("Upload fail?!", e);
			re.put("ok", false);
		}
		return re;
	}
}
