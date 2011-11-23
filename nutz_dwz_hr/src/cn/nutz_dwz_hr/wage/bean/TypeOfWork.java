package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 工种设置 bean<br>
* 表名：HR_TYPE_OF_WORK<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_TYPE_OF_WORK")
public class TypeOfWork implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 工种 **/
	@Column("NAME")
	private String name;
	/** 计时单位 **/
	@Column("TIMING_UNIT")
	private String timingUnit;
	/** 计时单价 **/
	@Column("PRICE")
	private Double price;
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
	
	public TypeOfWork(){
	}

	public TypeOfWork(
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
	 * 设置 工种.
	 * 
	 * @param Name
	 *            工种
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}
	/**
	 * 取得 工种.
	 * 
	 * @return Name
	 */
	public java.lang.String getName() {
		return this.name;
	}
	/**
	 * 设置 计时单位.
	 * 
	 * @param TimingUnit
	 *            计时单位
	 */
	public void setTimingUnit(java.lang.String value) {
		this.timingUnit = value;
	}
	/**
	 * 取得 计时单位.
	 * 
	 * @return TimingUnit
	 */
	public java.lang.String getTimingUnit() {
		return this.timingUnit;
	}
	/**
	 * 设置 计时单价.
	 * 
	 * @param Price
	 *            计时单价
	 */
	public void setPrice(java.lang.Double value) {
		this.price = value;
	}
	/**
	 * 取得 计时单价.
	 * 
	 * @return Price
	 */
	public java.lang.Double getPrice() {
		return this.price;
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
			.append("TimingUnit",getTimingUnit())
			.append("Price",getPrice())
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
		if(obj instanceof TypeOfWork == false) return false;
		if(this == obj) return true;
		TypeOfWork other = (TypeOfWork)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}