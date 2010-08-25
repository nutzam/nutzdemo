package nutz.demo.dao.meta;

import org.nutz.dao.entity.annotation.*;

@Table("t_pet")
public class Pet {

	@Id
	private int id;

	@Name
	private String name;

	private int age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return String.format("[%2d]%s is %d years old", id, name, age);
	}
}
