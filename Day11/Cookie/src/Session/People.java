package Session;

public class People {
	int id;
	String name;

	public People(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "id=" + id + ", name=" + name;
	}

}
