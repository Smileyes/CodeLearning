import java.util.Date;

/*
 *����һ�����ֽС��ˡ����࣬���������ԣ�
 *private int id;
 *private String name;
 *private Date birthday;
 */
public class Person {
	private int id;
	private String name;
	private Date birthday;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return ("ID:" + id + ",Name: " + name + ",Birthday: " + birthday);
	}
}
