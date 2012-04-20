package yhp.bean;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("t_item")
public class Item {

	/**
	 * 
	 */
	@Column("id")
	@Id(auto=false)
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
}