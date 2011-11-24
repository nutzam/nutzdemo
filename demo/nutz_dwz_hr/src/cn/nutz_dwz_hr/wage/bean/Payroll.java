package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 薪酬总额 bean<br>
* 表名：HR_PAYROLL<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_PAYROLL")
public class Payroll implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 类型 **/
	@Column("TYPE")
	private String type;
	/** 年份 **/
	@Column("YEAR")
	private String year;
	/** 季度 **/
	@Column("QUARTER")
	private Integer quarter;
	/** 月份 **/
	@Column("MONTH")
	private Integer month;
	/** 总额 **/
	@Column("TOTAL_SUM")
	private Double totalSum;
	/** 组织机构 **/
	@Column("ORGANIZATION")
	private String organization;
	/** 状态 **/
	@Column("STATE")
	private String state;
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
	
	public Payroll(){
	}

	public Payroll(
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
	 * 设置 年份.
	 * 
	 * @param Year
	 *            年份
	 */
	public void setYear(java.lang.String value) {
		this.year = value;
	}
	/**
	 * 取得 年份.
	 * 
	 * @return Year
	 */
	public java.lang.String getYear() {
		return this.year;
	}
	/**
	 * 设置 季度.
	 * 
	 * @param Quarter
	 *            季度
	 */
	public void setQuarter(java.lang.Integer value) {
		this.quarter = value;
	}
	/**
	 * 取得 季度.
	 * 
	 * @return Quarter
	 */
	public java.lang.Integer getQuarter() {
		return this.quarter;
	}
	/**
	 * 设置 月份.
	 * 
	 * @param Month
	 *            月份
	 */
	public void setMonth(java.lang.Integer value) {
		this.month = value;
	}
	/**
	 * 取得 月份.
	 * 
	 * @return Month
	 */
	public java.lang.Integer getMonth() {
		return this.month;
	}
	/**
	 * 设置 总额.
	 * 
	 * @param TotalSum
	 *            总额
	 */
	public void setTotalSum(java.lang.Double value) {
		this.totalSum = value;
	}
	/**
	 * 取得 总额.
	 * 
	 * @return TotalSum
	 */
	public java.lang.Double getTotalSum() {
		return this.totalSum;
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
	 * 设置 状态.
	 * 
	 * @param State
	 *            状态
	 */
	public void setState(java.lang.String value) {
		this.state = value;
	}
	/**
	 * 取得 状态.
	 * 
	 * @return State
	 */
	public java.lang.String getState() {
		return this.state;
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
			.append("Type",getType())
			.append("Year",getYear())
			.append("Quarter",getQuarter())
			.append("Month",getMonth())
			.append("TotalSum",getTotalSum())
			.append("Organization",getOrganization())
			.append("State",getState())
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
		if(obj instanceof Payroll == false) return false;
		if(this == obj) return true;
		Payroll other = (Payroll)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}