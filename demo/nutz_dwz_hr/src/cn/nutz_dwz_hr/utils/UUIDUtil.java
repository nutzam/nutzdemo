/**
 * 
 */
package cn.nutz_dwz_hr.utils;

import java.util.UUID;

/**
 * UUID 工具类 <br>
 * 
 * @author Dawn email: csg0328#gmail.com
 * @date 2011-11-22   上午11:33:13   
 * @version 1.0
 * @since 1.0
 */
public class UUIDUtil {

	public static String get() {
		return UUID.randomUUID().toString().replace("_", "");
	}

}
