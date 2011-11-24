package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 薪资表接口设置 bean<br>
* 表名：HR_WAGE_INTERFACE<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_WAGE_INTERFACE")
public class WageInterface implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 工资账套 **/
	@Column("ACCOUNT")
	private String account;
	/** 工资项目 **/
	@Column("SALARYITEM")
	private String salaryitem;
	/** 类型 **/
	@Column("TYPE")
	private String type;
	/** 创建人 **/
	@Column("CREATE_USER")
	private String createUser;
	/** 创建时间 **/
	@Column("CREATE_DATE")
	private String createDate;
	/** 修改人 **/
	@Column("MODIFY_USER")
	private String modifyUser;
	/** 修改时间 **/
	@Column("MODIFY_DATE")
	private String modifyDate;
	//columns END
	
	public WageInterface(){
	}

	public WageInterface(
		java.lang.String id
	){
		this.id = id;
	}

	/**
	 * 设置 id.
	 * 
	 * @param Id
	 *            id
	 */
	public void setId(java.lang.String value) {
		this.id = value;
	}
	/**
	 * 取得 id.
	 * 
	 * @return Id
	 */
	public java.lang.String getId() {
		return this.id;
	}
	/**
	 * 设置 工资账套.
	 * 
	 * @param Account
	 *            工资账套
	 */
	public void setAccount(java.lang.String value) {
		this.account = value;
	}
	/**
	 * 取得 工资账套.
	 * 
	 * @return Account
	 */
	public java.lang.String getAccount() {
		return this.account;
	}
	/**
	 * 设置 工资项目.
	 * 
	 * @param Salaryitem
	 *            工资项目
	 */
	public void setSalaryitem(java.lang.String value) {
		this.salaryitem = value;
	}
	/**
	 * 取得 工资项目.
	 * 
	 * @return Salaryitem
	 */
	public java.lang.String getSalaryitem() {
		return this.salaryitem;
	}
	/**
	 * 设置 类型.
	 * 
	 * @param Type
	 *            类型
	 */
	public void setType(java.lang.String value) {
		this.type = value;
	}
	/**
	 * 取得 类型.
	 * 
	 * @return Type
	 */
	public java.lang.String getType() {
		return this.type;
	}
	/**
	 * 设置 创建人.
	 * 
	 * @param CreateUser
	 *            创建人
	 */
	public void setCreateUser(java.lang.String value) {
		this.createUser = value;
	}
	/**
	 * 取得 创建人.
	 * 
	 * @return CreateUser
	 */
	public java.lang.String getCreateUser() {
		return this.createUser;
	}
	/**
	 * 设置 创建时间.
	 * 
	 * @param CreateDate
	 *            创建时间
	 */
	public void setCreateDate(java.lang.String value) {
		this.createDate = value;
	}
	/**
	 * 取得 创建时间.
	 * 
	 * @return CreateDate
	 */
	public java.lang.String getCreateDate() {
		return this.createDate;
	}
	/**
	 * 设置 修改人.
	 * 
	 * @param ModifyUser
	 *            修改人
	 */
	public void setModifyUser(java.lang.String value) {
		this.modifyUser = value;
	}
	/**
	 * 取得 修改人.
	 * 
	 * @return ModifyUser
	 */
	public java.lang.String getModifyUser() {
		return this.modifyUser;
	}
	/**
	 * 设置 修改时间.
	 * 
	 * @param ModifyDate
	 *            修改时间
	 */
	public void setModifyDate(java.lang.String value) {
		this.modifyDate = value;
	}
	/**
	 * 取得 修改时间.
	 * 
	 * @return ModifyDate
	 */
	public java.lang.String getModifyDate() {
		return this.modifyDate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Account",getAccount())
			.append("Salaryitem",getSalaryitem())
			.append("Type",getType())
			.append("CreateUser",getCreateUser())
			.append("CreateDate",getCreateDate())
			.append("ModifyUser",getModifyUser())
			.append("ModifyDate",getModifyDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof WageInterface == false) return false;
		if(this == obj) return true;
		WageInterface other = (WageInterface)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}