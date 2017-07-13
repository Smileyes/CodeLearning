package test;

public class GetClass {
	public static void main(String[] args) {
		Class c1 = null;
		try {
			c1 = Class.forName("test.People");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class c2 = People.class;
		Class c3 = new People().getClass();
		System.out.println("c1 = c2 ?" + (c1 == c2));
		System.out.println("c2 = c3 ?" + (c2 == c3));
	}
}
