import java.io.*;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		createNewProperties();
		Properties p = new Properties();
		p.load(new FileReader("F:/WorkSpace/Test/src/properties/config.ini"));
		int b = Integer.parseInt(p.getProperty("ÁÎÓĞÁ¼"));
		System.out.println(b);
	}

	public static void createNewProperties() throws IOException {
		Properties p = new Properties();
		p.setProperty("ÁÎÓĞÁ¼", "1");
		p.setProperty("ÁõĞ÷Á¼", "2");
		p.setProperty("Áø†´", "3");
		p.setProperty("ÂíÌÚ·É", "4");
		p.setProperty("ÂíÕñ³¬", "5");
		p.setProperty("ÃÉ»Íçû", "6");
		p.store(new FileWriter(new File(
				"F:/WorkSpace/Test/src/properties/config.ini")), "403");
	}
}
