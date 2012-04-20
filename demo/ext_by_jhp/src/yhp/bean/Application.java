package yhp.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@Table("t_application")
public class Application {

	/**
	 * 
	 */
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("name")
	private String name;
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
	@Column("count")
	private Integer count;
	/**
	 * 
	 */
	@Column("price")
	private Integer price;
	/**
	 * 
	 */
	@Column("total")
	private Integer total;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}