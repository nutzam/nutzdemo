package net.wendal.nutz.freemarker.model;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 按照官方的做法： 一定为单例
 * @author Administrator
 *
 */
public class CaptchaServiceSingleton {
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService(
			   new FastHashMapCaptchaStore(), new JCaptchaEngine(), 180,
			   100000 , 75000);
 public static ImageCaptchaService getInstance(){
     return instance;
 }
}
