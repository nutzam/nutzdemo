package com.scxxs.cms.utils;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
/**
 * 文件操作工具类
 * @author Administrator
 *
 */
public class FileUtils {
	
	private static final Logger logger = Logger.getLogger(FileUtils.class);
	/**
	 * 创建一个新的文件
	 * @param fileName  文件名称
	 * @param delete    是否删除旧文件
	 * @return 成功true,成功false
	 */
	public static boolean createFile(String fileName,boolean delete){
		
		File file = new File(fileName);
		
		if(file.exists()){
			
			if(!delete){
				return true;
			}
			
			if(file.delete()){
				try {
					if(file.createNewFile()){
						return true;
					}
				} catch (IOException e) {
					logger.fatal(e);
				}
			}
		}
		
		return false;
	}
	/**
	 * 删除文件
	 * @param path 文件路径
	 * @return 成功返回true,成功返回false
	 */
	public static boolean deleteFile(String path){
		
		File file = new File(path);
		
		if(file.exists()){
			if(!file.delete()){
				return false;
			}
		}
		
		return true;
	}
	/**
	 * 创建文件夹
	 * @param path 路径
	 * @return true 成功，false 失败
	 */
	public static boolean createFloader(String path){
		
		File file = new File(path);
		
		if(file.exists()){
			if(!file.isDirectory()){
				if(!file.mkdirs()){
					
					return false;
					
				}
			}
		}
		
		return true;
	}
	/**
	 * 移动文件
	 * @param source 要移动的文件
	 * @param target 移动到的绝对路径
	 * @return
	 */
	public  static boolean moveFile(File source,String target){
	
		if(source==null||target==null||"".equals(target)){
			return false;
		}
		
		int dot = target.lastIndexOf("/");
		String floder = target.substring(0, dot);
		File fl = new File(floder);
		if(!fl.exists()){
			fl.mkdirs();
		}
		
		File f = new File(target);
		
		if(!f.exists()){
			return source.renameTo(f);
		}
		
		return false;
	}
}
