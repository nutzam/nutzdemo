package yhp.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@Table("t_item")
public class Item {

	/**
	 * 
	 */
	@Column("id")
	@Id(auto = false)
	private Integer id;
	/**
	 * 
	 */
	@Column("name")
	private String name;
	/**
	 * 
	 */
	@Column("price")
	private Integer price;
	/**
	 * 
	 */
	@Column("version")
	private String version;
	/**
	 * 
	 */
	@Column("department")
	private String department;
	/**
	 * 
	 */
	@Column("place")
	private String place;
	/**
	 * 
	 */
	@Column("user")
	private String user;
	/**
	 * 
	 */
	@Column("principal")
	private String principal;
	/**
	 * 
	 */
	@Column("usetime")
	private java.util.Date usetime;
	/**
	 * 
	 */
	@Column("destroydate")
	private java.util.Date destroydate;
	/**
	 * 
	 */
	@Column("comment")
	private String comment;
	/**
	 * 
	 */
	@Column("destroyed")
	private boolean destroyed;

	@Column("destroyreason")
	private String destroyreason;

	@Column("conditions")
	private String conditions;
	@Column("unit")
	private String unit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public java.util.Date getUsetime() {
		return usetime;
	}

	public void setUsetime(java.util.Date usetime) {
		this.usetime = usetime;
	}

	public java.util.Date getDestroydate() {
		return destroydate;
	}

	public void setDestroydate(java.util.Date destroydate) {
		this.destroydate = destroydate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public String getDestroyreason() {
		return destroyreason;
	}

	public void setDestroyreason(String destroyreason) {
		this.destroyreason = destroyreason;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}