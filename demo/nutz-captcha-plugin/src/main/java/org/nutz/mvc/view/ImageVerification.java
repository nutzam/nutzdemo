package org.nutz.mvc.view;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

/**
 * 
 * 原作者以及无法考究,在网上搜集修改
 * @author idor(sjbwylbs@gmail.com)
 */
public class ImageVerification {
	
	private static int IMAGE_VERIFICATION_LENGTH =5;
	
	private String verifyCode = "";

	public int getRandInt(int b, int e) {
		if (b > e) {
			int temp = e;
			e = b;
			b = temp;
		}
		Random random = new Random();
		return b + random.nextInt(e - b);
	}

	public Color getRandColor(int b, int e) {// 给定范围获得随机颜色
		if (b > 255)
			b = 255;
		if (e > 255)
			e = 255;
		int rc = getRandInt(b, e);
		int gc = getRandInt(b, e);
		int bc = getRandInt(b, e);
		return new Color(rc, gc, bc);
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public BufferedImage creatImage() {

		// 在内存中创建图象
		int width = 10 * IMAGE_VERIFICATION_LENGTH + 20, height = 40;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		// 生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		// String rand = request.getParameter("rand");
		// rand = rand.substring(0,rand.indexOf("."));

		for (int i = 0; i < IMAGE_VERIFICATION_LENGTH; i++) {
			String rand = String.valueOf(getRandInt(0, 10));
			verifyCode += rand;
			// 将认证码显示到图象中
			g.setColor(getRandColor(20, 130));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 10 * i + 6 + getRandInt(0, 5),
					25 + getRandInt(0, 5));
		}
		// 图象生效
		g.dispose();
		return image;
	}
}
