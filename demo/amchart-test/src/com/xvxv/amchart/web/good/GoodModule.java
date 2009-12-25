package com.xvxv.amchart.web.good;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.InjectName;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.UploadAdaptor;

import com.xvxv.amchart.pojo.Good;
import com.xvxv.amchart.pojo.GoodBack;
import com.xvxv.amchart.pojo.GoodPaid;
import com.xvxv.amchart.pojo.GoodViewed;
import com.xvxv.amchart.sevice.GoodSevice;

/**
 * 商品模块
 * @author yinxvxv
 */
@InjectName("goodModule")
@At("/good")
@Fail("json")
public class GoodModule {
	private GoodSevice goodSevice;
	
	/**
	 * 查询所有的商品
	 * @return 商品列表
	 */
	@At
	@Ok("jsp:jsp.good.list")
	public List<Good> all(){
		return goodSevice.allGoods();
	}
	
	/**
	 * 增加商品
	 * @param name 商品名
	 * @param detailed 商品详细
	 * @return 增加的商品
	 */
	@At
	@Ok("jsp:jsp.good.uploadImg")
	public Good add(@Param("name") String name,@Param("detailed") String detailed) {
		Good good = new Good();
		good.setName(name);
		good.setDetailed(detailed);
		return goodSevice.dao().insert(good);
	}

	/**
	 * 上传商品照片
	 * @param id 商品id
	 * @param f 商品图片
	 * @param context application范围
	 * @throws IOException
	 */
	@At
	@AdaptBy(type = UploadAdaptor.class, args = {"D:/tmp/demo/upload", "10"})
	@Ok("redirect:/good/all.nut")
	public void uploadImg(@Param("id") int id, @Param("img") File f, ServletContext context)
			throws IOException {
		goodSevice.uploadImg(id, f, context.getRealPath("/"));
	}
	
	/**
	 * 模拟购买
	 * @param id 商品id
	 */
	@At("/paid/*")
	@Ok
	public void paid(int id){
		GoodPaid goodPaid = new GoodPaid();
		goodPaid.setGoodId(id);
		goodPaid.setPaidDate(new Timestamp(new Date().getTime()));
		goodSevice.dao().insert(goodPaid);
	}

	/**
	 * 模拟查看
	 * @param id 商品id
	 */
	@At("/viewed/*")
	@Ok
	public void viewed(int id){
		GoodViewed goodViewed = new GoodViewed();
		goodViewed.setGoodId(id);
		goodViewed.setViewedDate(new Timestamp(new Date().getTime()));
		goodSevice.dao().insert(goodViewed);
	}
	
	/**
	 * 模拟返回
	 * @param id 商品id
	 */
	@At("/back/*")
	@Ok
	public void back(int id){
		GoodBack goodBack = new GoodBack();
		goodBack.setGoodId(id);
		goodBack.setBackDate(new Timestamp(new Date().getTime()));
		goodSevice.dao().insert(goodBack);
	}
	
	/**
	 * 返回列图data xml
	 * @param command 生成图形数据类型的标识
	 * @return
	 */
	@At("/getColumn/*")
	@Ok("xml")
	public String getColumn(String command){
		return goodSevice.getColumn(command);
	}
	
	/**
	 * 返回饼图data xml
	 * @param id 商品id
	 * @return
	 */
	@At("/getPie/*")
	@Ok("xml")
	public String getPie(int id){
		return goodSevice.getPie(id);
	}
	
}
