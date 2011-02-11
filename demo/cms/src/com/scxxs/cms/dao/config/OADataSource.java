package com.scxxs.cms.dao.config;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
/**
 * 操作OA的数据
 * @author Administrator
 *
 */
public class OADataSource {

	private static final Ioc ioc = new NutIoc(new JsonLoader("/com/scxxs/cms/dao/config/oa.json"));
	
	
	private OADataSource(){
		
	}
	/**
	 * 获得ioc的实例
	 * @return
	 */
	public static Ioc getIoc(){
		
		return ioc;
	}
	
	
	
}
