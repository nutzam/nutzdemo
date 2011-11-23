package com.scxxs.cms.utils;
/**
 * 检测文件类型
 * @author Administrator
 *
 */
public class CheckFileType {
	/**
	 * 检测文件是否为图片
	 * @param filename 检测的文件名
	 * @return true 图片,false其他文件
	 */
	public static boolean isPic(String filename){
		
		String reg = "[\\s\\S]+.(png|gif|bmp|jpg|jpeg)";
		
		return filename.toLowerCase().matches(reg);
	}
	/**
	 * 检测文件是否为FreeMarker的模版文件
	 * @param fileName 
	 * @return
	 */
	public static boolean isFreeMarkerTemplate(String fileName){
		
		String reg = "[\\s\\S]+.(ftl)";
		
		return fileName.toLowerCase().matches(reg);
	}
}
