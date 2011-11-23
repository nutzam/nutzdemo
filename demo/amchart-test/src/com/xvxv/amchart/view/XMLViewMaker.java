package com.xvxv.amchart.view;

import org.nutz.ioc.Ioc;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;

/**
 * xml视图工厂,使响应为xml数据
 * 在注解中用到‘xml’时就会使用xml视图进行响应
 * @author yinxvxv
 */
public class XMLViewMaker implements ViewMaker{
	@Override
    public View make(Ioc ioc, String type, String value){
            if("xml".equalsIgnoreCase(type)){
                    return new XMLView();
            }
            return null;
    }
}