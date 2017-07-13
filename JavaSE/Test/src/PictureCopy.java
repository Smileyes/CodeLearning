import java.io.*;

public class PictureCopy {
	public static void main(String[] args) throws IOException {
		File inFile = new File("F:/Smileyes.jpg");
		File outFile = new File("F:/Smile.jpg");
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