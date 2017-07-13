import java.io.*;

public class CopyImage {
	public static void main(String[] args) throws IOException {
		File inFile = new File("F:/Smileyes.jpg");
		File outFile = new File("C:/Users/tesla/Desktop/abc.jpg");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				inFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(outFile));
		int b = 0;
		while ((b = bis.read()) != -1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}
}