package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 税收信息设置 bean<br>
* 表名：HR_REVENUE_INFO_SET<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_REVENUE_INFO_SET")
public class RevenueInfoSet implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 级别号 **/
	@Column("RANK")
	private Integer rank;
	/** 起始额 **/
	@Column("STARTING_FOREHEAD")
	private Double startingForehead;
	/** 结束额 **/
	@Column("END_FOREHEAD")
	private Double endForehead;
	/** 税率 **/
	@Column("TAX_RATE")
	private Double taxRate;
	/** 修改时间 **/
	@Column("MODIFY_DATE")
	private String modifyDate;
	/** 创建人 **/
	@Column("CREATE_USER")
	private String createUser;
	/** 创建时间 **/
	@Column("CREATE_DATE")
	private String createDate;
	/** 修改人 **/
	@Column("MODIFY_USER")
	private String modifyUser;
	/** 速算扣除数 **/
	@Column("QCD")
	private Double qcd;
	//columns END
	
	public RevenueInfoSet(){
	}

	public RevenueInfoSet(
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
	 * 设置 级别号.
	 * 
	 * @param Rank
	 *            级别号
	 */
	public void setRank(java.lang.Integer value) {
		this.rank = value;
	}
	/**
	 * 取得 级别号.
	 * 
	 * @return Rank
	 */
	public java.lang.Integer getRank() {
		return this.rank;
	}
	/**
	 * 设置 起始额.
	 * 
	 * @param StartingForehead
	 *            起始额
	 */
	public void setStartingForehead(java.lang.Double value) {
		this.startingForehead = value;
	}
	/**
	 * 取得 起始额.
	 * 
	 * @return StartingForehead
	 */
	public java.lang.Double getStartingForehead() {
		return this.startingForehead;
	}
	/**
	 * 设置 结束额.
	 * 
	 * @param EndForehead
	 *            结束额
	 */
	public void setEndForehead(java.lang.Double value) {
		this.endForehead = value;
	}
	/**
	 * 取得 结束额.
	 * 
	 * @return EndForehead
	 */
	public java.lang.Double getEndForehead() {
		return this.endForehead;
	}
	/**
	 * 设置 税率.
	 * 
	 * @param TaxRate
	 *            税率
	 */
	public void setTaxRate(java.lang.Double value) {
		this.taxRate = value;
	}
	/**
	 * 取得 税率.
	 * 
	 * @return TaxRate
	 */
	public java.lang.Double getTaxRate() {
		return this.taxRate;
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
	 * 设置 速算扣除数.
	 * 
	 * @param Qcd
	 *            速算扣除数
	 */
	public void setQcd(java.lang.Double value) {
		this.qcd = value;
	}
	/**
	 * 取得 速算扣除数.
	 * 
	 * @return Qcd
	 */
	public java.lang.Double getQcd() {
		return this.qcd;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Rank",getRank())
			.append("StartingForehead",getStartingForehead())
			.append("EndForehead",getEndForehead())
			.append("TaxRate",getTaxRate())
			.append("ModifyDate",getModifyDate())
			.append("CreateUser",getCreateUser())
			.append("CreateDate",getCreateDate())
			.append("ModifyUser",getModifyUser())
			.append("Qcd",getQcd())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RevenueInfoSet == false) return false;
		if(this == obj) return true;
		RevenueInfoSet other = (RevenueInfoSet)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}