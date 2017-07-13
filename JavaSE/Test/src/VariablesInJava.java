public class VariablesInJava {

	int instanceField = 5;

	static String staticField = "apple";

	public static void method() {

		final String localVariable = "Initial Value";

		System.out.println(localVariable);
	}

	public static void main(String args[]) {

		VariablesInJava obj = new VariablesInJava();

		System.out.println(obj.instanceField);
		System.out.println(obj.staticField);
		System.out.println(VariablesInJava.staticField);
		System.out.println(new VariablesInJava().instanceField);
		method();

	}
}