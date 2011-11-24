package cn.nutz_dwz_hr.wage.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.*;

/**
* 预设工序 bean<br>
* 表名：HR_PREINSTALL_PROCESS<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@Table("HR_PREINSTALL_PROCESS")
public class PreinstallProcess implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//columns START
	/** id **/
	@Name
	@Column("ID")
	private String id;
	/** 工序 **/
	@Column("NAME")
	private String name;
	//columns END
	
	public PreinstallProcess(){
	}

	public PreinstallProcess(
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
	 * 设置 工序.
	 * 
	 * @param Name
	 *            工序
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}
	/**
	 * 取得 工序.
	 * 
	 * @return Name
	 */
	public java.lang.String getName() {
		return this.name;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof PreinstallProcess == false) return false;
		if(this == obj) return true;
		PreinstallProcess other = (PreinstallProcess)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

}