package com.scxxs.cms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
/**
 * 日期转换工具类
 * @author Administrator
 *
 */
public class DateConvertUtil {
	private static final Logger logger = Logger.getLogger(DateConvertUtil.class);
	/**
	 * 把日期转换成字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String convertDate(Date date,String pattern){
		if(date!=null){
			DateFormat format;
			if(pattern==null||pattern.equals("")){
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}else{
				format = new SimpleDateFormat(pattern);
			}
			
			return format.format(date);
			
		}
		return null;
	}
	/**
	 * 把字符串转换成日期类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date convertDate(String date,String pattern){
		if(date!=null){
			DateFormat format;
			if(pattern==null||pattern.equals("")){
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}else{
				format = new SimpleDateFormat(pattern);
			}
			
			try {
				return format.parse(date);
			} catch (ParseException e) {
				logger.fatal(e);
			}
			
		}
		return null;
	}
	
	
}
