package com.scxxs.cms.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 网站导航模型
 * 
 * @author Administrator
 * 
 */
@Table("t_navModel")
public class NavModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7992631788015602548L;
	/*
	 * 数据库ID
	 */
	@Id
	private int id;
	/*
	 * 导航名称
	 */
	@Column
	private String navName;
	/*
	 * 父级导航，不存在则为空
	 */
	@One(target=NavModel.class,field="pid")
	private NavModel parent;
	/*
	 * 记录外键关系
	 */
	@Column
	private int pid;
	
	/*
	 * 列表显示风格
	 */
	@One(target=Templete.class,field="tid")
	private Templete template;
	/*
	 * 记录外键关系
	 */
	@Column
	private int tid; 
	
	/*
	 * 排序号码
	 */
	@Column
	private long sortNumber;
	/*
	 * 访问地址
	 */
	@Column
	private String url;
	/*
	 * 所有该导航的子导航
	 */
	@Many(target=NavModel.class,field="pid")
	private List<NavModel> children;
	
	/*
	 *设置是否为首页 
	 */
	@Column
	private boolean indexNav;
	/*
	 * 是否显示导航
	 * true 不显示
	 */
	@Column
	private boolean showNav;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public NavModel getParent() {
		return parent;
	}

	public void setParent(NavModel parent) {
		this.parent = parent;
	}

	public Templete getTemplate() {
		return template;
	}

	public void setTemplate(Templete template) {
		this.template = template;
	}

	public long getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(long sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<NavModel> getChildren() {
		return children;
	}

	public void setChildren(List<NavModel> children) {
		
		if(children!=null&&children.size()>0){
			//把List进行排序处理
			Collections.sort(children, new Comparator<NavModel>() {

				@Override
				public int compare(NavModel o1, NavModel o2) {
					
					if(o1.getSortNumber()==o2.getSortNumber()){
						return 0;
					}
					if(o1.getSortNumber()>o2.getSortNumber()){
						return -1;
					}
					return 1 ;
				}
			
			});
		}
		this.children = children;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public boolean isIndexNav() {
		return indexNav;
	}

	public void setIndexNav(boolean indexNav) {
		this.indexNav = indexNav;
	}

	public boolean isShowNav() {
		return showNav;
	}

	public void setShowNav(boolean showNav) {
		this.showNav = showNav;
	}
	
	

}
