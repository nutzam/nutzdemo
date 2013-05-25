package cn.nutz.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/** 
 * 加解密工具
 * @author howe
 *
 */
public class CodeCryption {

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 加密字符串
	 * 
	 * @param algorithm
	 *            BASE64 MD5 SHA1
	 * @param str
	 */
	public static String encode(String algorithm, String str) {
		if (str == null)
			return null;
		try {
			if (algorithm.toUpperCase().equals("BASE64"))
				return encodeBase64(str);
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Takes the raw bytes from the digest and formats them correct.
	 * 
	 * @param bytes
	 *            the raw bytes from the digest.
	 * @return the formatted bytes.
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);

		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}

		return buf.toString();
	}

	/**
	 * BASE64编码
	 * 
	 * @param str
	 * @return
	 */
	private static String encodeBase64(String str) {
		if (str == null)
			return null;
		try {
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(str
							.getBytes("UTF-8"))).replaceAll("\r", "")
					.replaceAll("\n", "");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * BASE64解码
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeBase64(String str) {
		if (str == null)
			return null;
		try {
			return new String(
					org.apache.commons.codec.binary.Base64.decodeBase64(str
							.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密字符串
	 * 
	 * @param algorithm
	 *            BASE64
	 * @param str
	 * @return
	 */
	private static String decode(String algorithm, String str) {

		if (str == null)
			return null;
		if (algorithm.toUpperCase().equals("BASE64"))
			return decodeBase64(str);
		else
			return null;
	}

	public static void main(String[] args) {

		System.out.println("MD5  :" + CodeCryption.encode("MD5", "123456"));
		System.out.println("SHA1 :" + CodeCryption.encode("SHA1", "123456"));
		System.out.println("BASE64 :"
				+ CodeCryption.encode("BASE64", "123456"));
		System.out.println("BASE64 :" + decode("BASE64", "MTIzNDU2"));
	}

}
