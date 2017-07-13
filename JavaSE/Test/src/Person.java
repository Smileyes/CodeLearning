import java.util.Comparator;

public class Person implements Comparable<Person> {
	int id;
	String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int compareTo(Person o) {
		return id - o.id;
	}

	public String toString() {
		return id + "+" + name;
	}

}
