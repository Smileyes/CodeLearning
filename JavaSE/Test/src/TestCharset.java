import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TestCharset {

	public static void main(String[] args) {
		String s = "ÖÐ¹ú";
		System.out.println(s);
		try {
			byte[] buf = s.getBytes();
			String s2 = new String(buf, "ISO8859-1");
			System.out.println(s2);
			byte [] buf2 = s2.getBytes("ISO8859-1");
			String s3 = new String(buf2,"GBK");
			System.out.println(s3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
