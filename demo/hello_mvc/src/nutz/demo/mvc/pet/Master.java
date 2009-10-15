package nutz.demo.mvc.pet;

import java.sql.Timestamp;
import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("t_master")
public class Master {

	@Column
	@Id
	private int id;

	@Column
	@Name
	private String name;

	@Column("pwd")
	@NotNull
	private String password;

	@Column
	private Timestamp birthday;

	@Many(target = Pet.class, field = "masterId")
	private List<Pet> pets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
