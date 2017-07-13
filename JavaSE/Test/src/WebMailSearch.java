import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebMailSearch {
	public static void main(String[] args) {
		int num = 0;
		File f1 = null;
		File f2 = null;
		BufferedReader bfr = null;
		BufferedWriter bfw = null;
		try {
			f1 = new File(WebMailSearch.class.getClassLoader()
					.getResource("WebHtml/abc.html").toURI());
			f2 = new File("F:/WorkSpace/Test/src/WebHtml/Mail.txt");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			bfr = new BufferedReader(new FileReader(f1));
			bfw = new BufferedWriter(new FileWriter(f2, true));
			String s = null;
			String str = null;
			Pattern p = Pattern.compile("([\\w]+)(@)([\\w]+)(\\.)([\\w]+)");
			Matcher m = null;
			while ((s = bfr.readLine()) != null) {
				m = p.matcher(s);
				while (m.find()) {
					num++;
					str = m.group();
					System.out.print(str + "\n");
					bfw.write(str);
					bfw.newLine();
				}

			}
			bfw.flush();
			bfr.close();
			bfw.close();
			System.out.println(num);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}