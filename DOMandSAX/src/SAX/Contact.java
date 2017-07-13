package SAX;

public class Contact {
	private String id;
	private String name;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Contact(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Contact() {
	}

	public String toString() {
		return "id=" + id + ", name=" + name + ", password=" + password+"\n";
	}

}
