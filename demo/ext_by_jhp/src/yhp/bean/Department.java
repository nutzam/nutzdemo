package yhp.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@Table("t_department")
public class Department {

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

}