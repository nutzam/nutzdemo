package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 工资账套表 bean<br>
* 表名：HR_ACCOUNT<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_ACCOUNT")
public class Account implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 名称 **/
	@Column("NAME")
	private String name;
	/** 账套状态 **/
	@Column("STATUS")
	private String status;
	/** 描述 **/
	@Column("DESCRIPTION")
	private String description;
	/** 组织机构 **/
	@Column("ORGANIZATION")
	private String organization;
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
	
	public Account(){
	}

	public Account(
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
	 * 设置 名称.
	 * 
	 * @param Name
	 *            名称
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}
	/**
	 * 取得 名称.
	 * 
	 * @return Name
	 */
	public java.lang.String getName() {
		return this.name;
	}
	/**
	 * 设置 账套状态.
	 * 
	 * @param Status
	 *            账套状态
	 */
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	/**
	 * 取得 账套状态.
	 * 
	 * @return Status
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 设置 描述.
	 * 
	 * @param Description
	 *            描述
	 */
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	/**
	 * 取得 描述.
	 * 
	 * @return Description
	 */
	public java.lang.String getDescription() {
		return this.description;
	}
	/**
	 * 设置 组织机构.
	 * 
	 * @param Organization
	 *            组织机构
	 */
	public void setOrganization(java.lang.String value) {
		this.organization = value;
	}
	/**
	 * 取得 组织机构.
	 * 
	 * @return Organization
	 */
	public java.lang.String getOrganization() {
		return this.organization;
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
			.append("Name",getName())
			.append("Status",getStatus())
			.append("Description",getDescription())
			.append("Organization",getOrganization())
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
		if(obj instanceof Account == false) return false;
		if(this == obj) return true;
		Account other = (Account)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}