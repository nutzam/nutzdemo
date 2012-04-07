package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 计时工资 bean<br>
* 表名：HR_HOURLY_WAGES<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_HOURLY_WAGES")
public class HourlyWages implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 日期 **/
	@Column("DATE")
	private String date;
	/** 工作时间 **/
	@Column("WORK_HOUR")
	private Integer workHour;
	/** 生产单号 **/
	@Column("PRODUCTION_ORDER")
	private String productionOrder;
	/** 员工 **/
	@Column("EMPLOYEE")
	private String employee;
	/** 工种 **/
	@Column("TYPE_OF_WORK")
	private String typeOfWork;
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
	/** 备注 **/
	@Column("REMARKS")
	private String remarks;
	//columns END
	
	public HourlyWages(){
	}

	public HourlyWages(
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
	 * 设置 日期.
	 * 
	 * @param Date
	 *            日期
	 */
	public void setDate(java.lang.String value) {
		this.date = value;
	}
	/**
	 * 取得 日期.
	 * 
	 * @return Date
	 */
	public java.lang.String getDate() {
		return this.date;
	}
	/**
	 * 设置 工作时间.
	 * 
	 * @param WorkHour
	 *            工作时间
	 */
	public void setWorkHour(java.lang.Integer value) {
		this.workHour = value;
	}
	/**
	 * 取得 工作时间.
	 * 
	 * @return WorkHour
	 */
	public java.lang.Integer getWorkHour() {
		return this.workHour;
	}
	/**
	 * 设置 生产单号.
	 * 
	 * @param ProductionOrder
	 *            生产单号
	 */
	public void setProductionOrder(java.lang.String value) {
		this.productionOrder = value;
	}
	/**
	 * 取得 生产单号.
	 * 
	 * @return ProductionOrder
	 */
	public java.lang.String getProductionOrder() {
		return this.productionOrder;
	}
	/**
	 * 设置 员工.
	 * 
	 * @param Employee
	 *            员工
	 */
	public void setEmployee(java.lang.String value) {
		this.employee = value;
	}
	/**
	 * 取得 员工.
	 * 
	 * @return Employee
	 */
	public java.lang.String getEmployee() {
		return this.employee;
	}
	/**
	 * 设置 工种.
	 * 
	 * @param TypeOfWork
	 *            工种
	 */
	public void setTypeOfWork(java.lang.String value) {
		this.typeOfWork = value;
	}
	/**
	 * 取得 工种.
	 * 
	 * @return TypeOfWork
	 */
	public java.lang.String getTypeOfWork() {
		return this.typeOfWork;
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
	/**
	 * 设置 备注.
	 * 
	 * @param Remarks
	 *            备注
	 */
	public void setRemarks(java.lang.String value) {
		this.remarks = value;
	}
	/**
	 * 取得 备注.
	 * 
	 * @return Remarks
	 */
	public java.lang.String getRemarks() {
		return this.remarks;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Date",getDate())
			.append("WorkHour",getWorkHour())
			.append("ProductionOrder",getProductionOrder())
			.append("Employee",getEmployee())
			.append("TypeOfWork",getTypeOfWork())
			.append("CreateUser",getCreateUser())
			.append("CreateDate",getCreateDate())
			.append("ModifyUser",getModifyUser())
			.append("ModifyDate",getModifyDate())
			.append("Remarks",getRemarks())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof HourlyWages == false) return false;
		if(this == obj) return true;
		HourlyWages other = (HourlyWages)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}