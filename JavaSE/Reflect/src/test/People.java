package test;

public class People  implements Human{
	private int id;
	public String name;

	public People(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public People(int id) {
		this.id = id;
		this.name = "Ð¡ºì";
	}

	private People(String name) {
		this.name = name;
		this.id = 15;
	}

	public People() {

	}

	public void eat(int num) {
		System.out.println(name + "has eaten" + num + "tons food.");
	}

	private void sleep() {
		System.out.println(name + " is sleeping.");
	}

	public String toString() {
		return id + "  " + name;
	}
}
