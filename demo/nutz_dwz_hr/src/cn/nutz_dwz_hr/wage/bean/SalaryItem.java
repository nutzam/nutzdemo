package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 工资项目 bean<br>
* 表名：HR_SALARY_ITEM<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_SALARY_ITEM")
public class SalaryItem implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 在薪资表中对应的列 **/
	@Column("SALARY_COLUMN")
	private String salaryColumn;
	/** 工资账套 **/
	@Column("ACCOUNT_ID")
	private String accountId;
	/** 工资项目 **/
	@Column("ITEM_NAME")
	private String itemName;
	/** 项目类型 **/
	@Column("ITEM_TYPE")
	private String itemType;
	/** 小数位数 **/
	@Column("DECIMALS")
	private Integer decimals;
	/** 舍位方式 **/
	@Column("ROUND")
	private String round;
	/** 初始值 **/
	@Column("INITIAL_VALUE")
	private Double initialValue;
	/** 显示公式 **/
	@Column("DISPLAY_FORMULAR")
	private String displayFormular;
	/** 数据公式 **/
	@Column("DB_FORMULAR")
	private String dbFormular;
	/** 描述 **/
	@Column("DESCRIPTION")
	private String description;
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
	
	public SalaryItem(){
	}

	public SalaryItem(
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
	 * 设置 在薪资表中对应的列.
	 * 
	 * @param SalaryColumn
	 *            在薪资表中对应的列
	 */
	public void setSalaryColumn(java.lang.String value) {
		this.salaryColumn = value;
	}
	/**
	 * 取得 在薪资表中对应的列.
	 * 
	 * @return SalaryColumn
	 */
	public java.lang.String getSalaryColumn() {
		return this.salaryColumn;
	}
	/**
	 * 设置 工资账套.
	 * 
	 * @param AccountId
	 *            工资账套
	 */
	public void setAccountId(java.lang.String value) {
		this.accountId = value;
	}
	/**
	 * 取得 工资账套.
	 * 
	 * @return AccountId
	 */
	public java.lang.String getAccountId() {
		return this.accountId;
	}
	/**
	 * 设置 工资项目.
	 * 
	 * @param ItemName
	 *            工资项目
	 */
	public void setItemName(java.lang.String value) {
		this.itemName = value;
	}
	/**
	 * 取得 工资项目.
	 * 
	 * @return ItemName
	 */
	public java.lang.String getItemName() {
		return this.itemName;
	}
	/**
	 * 设置 项目类型.
	 * 
	 * @param ItemType
	 *            项目类型
	 */
	public void setItemType(java.lang.String value) {
		this.itemType = value;
	}
	/**
	 * 取得 项目类型.
	 * 
	 * @return ItemType
	 */
	public java.lang.String getItemType() {
		return this.itemType;
	}
	/**
	 * 设置 小数位数.
	 * 
	 * @param Decimals
	 *            小数位数
	 */
	public void setDecimals(java.lang.Integer value) {
		this.decimals = value;
	}
	/**
	 * 取得 小数位数.
	 * 
	 * @return Decimals
	 */
	public java.lang.Integer getDecimals() {
		return this.decimals;
	}
	/**
	 * 设置 舍位方式.
	 * 
	 * @param Round
	 *            舍位方式
	 */
	public void setRound(java.lang.String value) {
		this.round = value;
	}
	/**
	 * 取得 舍位方式.
	 * 
	 * @return Round
	 */
	public java.lang.String getRound() {
		return this.round;
	}
	/**
	 * 设置 初始值.
	 * 
	 * @param InitialValue
	 *            初始值
	 */
	public void setInitialValue(java.lang.Double value) {
		this.initialValue = value;
	}
	/**
	 * 取得 初始值.
	 * 
	 * @return InitialValue
	 */
	public java.lang.Double getInitialValue() {
		return this.initialValue;
	}
	/**
	 * 设置 显示公式.
	 * 
	 * @param DisplayFormular
	 *            显示公式
	 */
	public void setDisplayFormular(java.lang.String value) {
		this.displayFormular = value;
	}
	/**
	 * 取得 显示公式.
	 * 
	 * @return DisplayFormular
	 */
	public java.lang.String getDisplayFormular() {
		return this.displayFormular;
	}
	/**
	 * 设置 数据公式.
	 * 
	 * @param DbFormular
	 *            数据公式
	 */
	public void setDbFormular(java.lang.String value) {
		this.dbFormular = value;
	}
	/**
	 * 取得 数据公式.
	 * 
	 * @return DbFormular
	 */
	public java.lang.String getDbFormular() {
		return this.dbFormular;
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
			.append("SalaryColumn",getSalaryColumn())
			.append("AccountId",getAccountId())
			.append("ItemName",getItemName())
			.append("ItemType",getItemType())
			.append("Decimals",getDecimals())
			.append("Round",getRound())
			.append("InitialValue",getInitialValue())
			.append("DisplayFormular",getDisplayFormular())
			.append("DbFormular",getDbFormular())
			.append("Description",getDescription())
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
		if(obj instanceof SalaryItem == false) return false;
		if(this == obj) return true;
		SalaryItem other = (SalaryItem)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}