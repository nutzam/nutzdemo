package com.xvxv.amchart.sevice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.lang.Files;
import org.nutz.service.IdNameEntityService;

import com.xvxv.amchart.pojo.Good;

/**
 * 商品服务类
 * @author yinxvxv
 *
 */
public class GoodSevice extends IdNameEntityService<Good> {

	public GoodSevice(Dao dao) {
		super(dao);
	}

	/**
	 * 查询所有商品
	 * @return 所有商品
	 */
	public List<Good> allGoods(){
		return this.query(Cnd.orderBy().desc("paidCount"), null);
	}
	
	/**
	 * 上传文件的处理
	 * @param id 商品id
	 * @param tempFile 临时文件
	 * @param root application上下文根路径
	 * @throws IOException 
	 */
	public void uploadImg(int id, File tempFile, String root) throws IOException {
		Good good = this.fetch(id);
		String ext = Files.getSuffixName(tempFile);
		good.setImgUrl("/imgs/" + id + "." + ext);
		File photo = new File(root + good.getImgUrl());
		if (photo.exists())
			Files.deleteFile(photo);
		Files.move(tempFile, photo);
		dao().update(good);
	}
	
	/**
	 * 生成列图数据（使用dom4j）
	 * @param command 生成图形数据类型的标识
	 * @return xml string
	 */
	public String getColumn(String command){
		List<Good> goods = null;
		if("top10".equals(command)){
			goods= this.query(Cnd.orderBy().desc("paidCount"), dao().createPager(1, 10));
		}else if("bottom10".equals(command)){
			goods= this.query(Cnd.orderBy().asc("paidCount"), dao().createPager(1, 10));
		}
		Document document = DocumentHelper.createDocument();
		Element chartEle = document.addElement("chart");
		Element seriesEle = chartEle.addElement("series");
		Element graphsEle = chartEle.addElement("graphs");
		Element paidGraphEle = graphsEle.addElement("graph").addAttribute("title", "购买");
		Element viewedGraphEle = graphsEle.addElement("graph").addAttribute("title", "查看");
		Element backGraphEle = graphsEle.addElement("graph").addAttribute("title", "返回");
		int i = 0;
		for (Good good : goods) {
			seriesEle.addElement("value").addAttribute("xid",""+i).addText(good.getName());
			
			paidGraphEle.addElement("value").addAttribute("xid",""+i).addText(""+good.getPaidCount());
			viewedGraphEle.addElement("value").addAttribute("xid",""+i).addText(""+good.getViewedCount());
			backGraphEle.addElement("value").addAttribute("xid",""+i++).addText(""+good.getBackCount());
		}
		return document.asXML();
	}
	
	/**
	 * 生成饼图数据（使用dom4j）
	 * @param id 商品id
	 * @return xml string
	 */
	public String getPie(int id){
		Good good = this.fetch(id);
		Document document = DocumentHelper.createDocument();
		Element pieEle = document.addElement("pie");
		pieEle.addElement("slice").addAttribute("title", "购买").addText(""+good.getPaidCount());
		pieEle.addElement("slice").addAttribute("title", "查看").addText(""+good.getViewedCount());
		pieEle.addElement("slice").addAttribute("title", "返回").addText(""+good.getBackCount());
		return document.asXML();
	}
}
