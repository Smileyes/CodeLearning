import java.util.Comparator;

public class Genericity<Integer> implements Dao<Integer> {

	public static void main(String[] args) {
		new Genericity();
	}

	public <T> void server(T[] arry) {

	}

	private class MyCompare<String> implements Comparator<String> {

		public int compareTo(String o) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}
}
