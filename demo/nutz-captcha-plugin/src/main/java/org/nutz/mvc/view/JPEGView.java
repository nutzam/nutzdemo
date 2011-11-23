package org.nutz.mvc.view;

import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.View;

/**
 * @author idor(sjbwylbs@gmail.com)
 */
public class JPEGView implements View {
	public static String CAPTCHA = "CAPTCHA_NAME";
	private static final Log log = Logs.getLog(JPEGView.class);

	private String contentType;

	public JPEGView(String contentType) {
		if (contentType == null) {
			this.contentType = "image/jpeg";
		} else {
			this.contentType = contentType;
		}
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp, Object obj)
			throws Throwable {
		resp.setContentType(this.contentType);
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		HttpSession session = req.getSession();

		OutputStream out = resp.getOutputStream();
		// 输出图象到页面
		ImageVerification iv = new ImageVerification();

		if (ImageIO.write(iv.creatImage(), "JPEG", out)) {
			log.debugf("写入输出流成功:%s.", iv.getVerifyCode());
		} else {
			log.debugf("写入输出流失败:%s.", iv.getVerifyCode());
		}
		
		session.setAttribute(CAPTCHA, iv.getVerifyCode());

		// 以下关闭输入流！
		out.flush();
		out.close();

	}
}
