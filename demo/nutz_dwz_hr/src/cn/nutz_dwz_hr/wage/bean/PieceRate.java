package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 计件工资 bean<br>
* 表名：HR_PIECE_RATE<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_PIECE_RATE")
public class PieceRate implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 产品 **/
	@Column("PRODUCT")
	private String product;
	/** 工序 **/
	@Column("PROCESS")
	private String process;
	/** 工票日期 **/
	@Column("WT_DATE")
	private String wtDate;
	/** 人员编号 **/
	@Column("EMPLOYEE")
	private String employee;
	/** 合格数量 **/
	@Column("QUALIFIED_NUMBER")
	private Integer qualifiedNumber;
	/** 金额 **/
	@Column("MONEY")
	private Double money;
	/** 废品数量 **/
	@Column("QUANTITY_SCRAPPED")
	private Integer quantityScrapped;
	/** 废品扣款 **/
	@Column("WASTE_DEDUCTIONS")
	private Double wasteDeductions;
	/** 计件金额 **/
	@Column("AMOUNT")
	private Double amount;
	/** 流水号 **/
	@Column("SERIAL_NUMBER")
	private Integer serialNumber;
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
	
	public PieceRate(){
	}

	public PieceRate(
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
	 * 设置 产品.
	 * 
	 * @param Product
	 *            产品
	 */
	public void setProduct(java.lang.String value) {
		this.product = value;
	}
	/**
	 * 取得 产品.
	 * 
	 * @return Product
	 */
	public java.lang.String getProduct() {
		return this.product;
	}
	/**
	 * 设置 工序.
	 * 
	 * @param Process
	 *            工序
	 */
	public void setProcess(java.lang.String value) {
		this.process = value;
	}
	/**
	 * 取得 工序.
	 * 
	 * @return Process
	 */
	public java.lang.String getProcess() {
		return this.process;
	}
	/**
	 * 设置 工票日期.
	 * 
	 * @param WtDate
	 *            工票日期
	 */
	public void setWtDate(java.lang.String value) {
		this.wtDate = value;
	}
	/**
	 * 取得 工票日期.
	 * 
	 * @return WtDate
	 */
	public java.lang.String getWtDate() {
		return this.wtDate;
	}
	/**
	 * 设置 人员编号.
	 * 
	 * @param Employee
	 *            人员编号
	 */
	public void setEmployee(java.lang.String value) {
		this.employee = value;
	}
	/**
	 * 取得 人员编号.
	 * 
	 * @return Employee
	 */
	public java.lang.String getEmployee() {
		return this.employee;
	}
	/**
	 * 设置 合格数量.
	 * 
	 * @param QualifiedNumber
	 *            合格数量
	 */
	public void setQualifiedNumber(java.lang.Integer value) {
		this.qualifiedNumber = value;
	}
	/**
	 * 取得 合格数量.
	 * 
	 * @return QualifiedNumber
	 */
	public java.lang.Integer getQualifiedNumber() {
		return this.qualifiedNumber;
	}
	/**
	 * 设置 金额.
	 * 
	 * @param Money
	 *            金额
	 */
	public void setMoney(java.lang.Double value) {
		this.money = value;
	}
	/**
	 * 取得 金额.
	 * 
	 * @return Money
	 */
	public java.lang.Double getMoney() {
		return this.money;
	}
	/**
	 * 设置 废品数量.
	 * 
	 * @param QuantityScrapped
	 *            废品数量
	 */
	public void setQuantityScrapped(java.lang.Integer value) {
		this.quantityScrapped = value;
	}
	/**
	 * 取得 废品数量.
	 * 
	 * @return QuantityScrapped
	 */
	public java.lang.Integer getQuantityScrapped() {
		return this.quantityScrapped;
	}
	/**
	 * 设置 废品扣款.
	 * 
	 * @param WasteDeductions
	 *            废品扣款
	 */
	public void setWasteDeductions(java.lang.Double value) {
		this.wasteDeductions = value;
	}
	/**
	 * 取得 废品扣款.
	 * 
	 * @return WasteDeductions
	 */
	public java.lang.Double getWasteDeductions() {
		return this.wasteDeductions;
	}
	/**
	 * 设置 计件金额.
	 * 
	 * @param Amount
	 *            计件金额
	 */
	public void setAmount(java.lang.Double value) {
		this.amount = value;
	}
	/**
	 * 取得 计件金额.
	 * 
	 * @return Amount
	 */
	public java.lang.Double getAmount() {
		return this.amount;
	}
	/**
	 * 设置 流水号.
	 * 
	 * @param SerialNumber
	 *            流水号
	 */
	public void setSerialNumber(java.lang.Integer value) {
		this.serialNumber = value;
	}
	/**
	 * 取得 流水号.
	 * 
	 * @return SerialNumber
	 */
	public java.lang.Integer getSerialNumber() {
		return this.serialNumber;
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
			.append("Product",getProduct())
			.append("Process",getProcess())
			.append("WtDate",getWtDate())
			.append("Employee",getEmployee())
			.append("QualifiedNumber",getQualifiedNumber())
			.append("Money",getMoney())
			.append("QuantityScrapped",getQuantityScrapped())
			.append("WasteDeductions",getWasteDeductions())
			.append("Amount",getAmount())
			.append("SerialNumber",getSerialNumber())
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
		if(obj instanceof PieceRate == false) return false;
		if(this == obj) return true;
		PieceRate other = (PieceRate)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}