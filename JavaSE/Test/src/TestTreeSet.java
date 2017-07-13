import java.util.*;

import org.junit.Test;

public class TestTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Person> set = new TreeSet<Person>();
		for (int i = 1; i < 5; i++) {
			set.add(new Person(i, "Smile"));
		}
		set.add(new Person(1, "Smile"));
		System.out.println(set);
	}

	@Test
	public void say() {
		System.out.println("Test Junit.");
	}

	@Test
	public void launch() {
		System.out.println("Bravo!!!");
	}
}
