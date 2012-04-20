package yhp.bean;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
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
}