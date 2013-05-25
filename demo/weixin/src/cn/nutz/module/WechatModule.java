package cn.nutz.module;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.GET;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;

import cn.nutz.tool.CodeCryption;
/**
 * www.nutz.cn 微信自动服务模块
 * 
 * @author howe(howechiang@gmail.com)
 */
public class WechatModule {

	private static String TOKEN = "nutz";
	/*
	 * 文字消息
	 */
	private static final String RESPONSE_TXT = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Content><![CDATA[%s]]></Content><FuncFlag>0</FuncFlag></xml>";

	// 校验请求是否来自微信服务器
	@At("/wechat/nutz")
	@GET
	@Ok("raw")
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {

		String[] array = {TOKEN, timestamp, nonce};
		Arrays.sort(array);
		String tmp = Arrays.toString(array);

		tmp = tmp.substring(1, tmp.length() - 1);
		tmp = tmp.replaceAll(",", "");
		tmp = tmp.replaceAll("\\s*", "");

		tmp = CodeCryption.encode("SHA1", tmp);

		if (tmp.equals(signature)) 
			return echostr;
		return "";
	}

	@At("/wechat/nutz")
	@POST
	@Ok("raw")
	public void responseMsg() throws IOException, DocumentException {

		SAXReader reader = new SAXReader();
		InputStream in = Mvcs.getReq().getInputStream();
		Document doc = reader.read(in);
		Element root = doc.getRootElement();

		String toUserName = root.elementText("ToUserName");// 开发者微信号
		String fromUserName = root.elementText("FromUserName");// 发送方帐号（一个OpenID）
		String createTime = root.elementText("CreateTime");// 消息创建时间 （整型）
		String msgType = root.elementText("MsgType");// 消息类型
		String content = root.elementText("Content");// 文本消息内容
		String msgId = root.elementText("MsgId");// 消息id，64位整型

		PrintWriter out = Mvcs.getResp().getWriter();
		out.printf(	RESPONSE_TXT,
					fromUserName,
					toUserName,
					System.currentTimeMillis(),
					"text",
					"欢迎使用NUTZ微信助手[呲牙]");
		in.close();
		in = null;
		out.close();
		out = null;

	}
}