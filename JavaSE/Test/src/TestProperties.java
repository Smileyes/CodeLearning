import java.io.*;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		createNewProperties();
		Properties p = new Properties();
		p.load(new FileReader("F:/WorkSpace/Test/src/properties/config.ini"));
		int b = Integer.parseInt(p.getProperty("������"));
		System.out.println(b);
	}

	public static void createNewProperties() throws IOException {
		Properties p = new Properties();
		p.setProperty("������", "1");
		p.setProperty("������", "2");
		p.setProperty("����", "3");
		p.setProperty("���ڷ�", "4");
		p.setProperty("����", "5");
		p.setProperty("�ɻ���", "6");
		p.store(new FileWriter(new File(
				"F:/WorkSpace/Test/src/properties/config.ini")), "403");
	}
}
