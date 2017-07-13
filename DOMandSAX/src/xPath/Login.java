package xPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Login {
	public static void main(String[] args) {
		new Login().launch();
	}

	public void launch() {
		System.out.println("Please input your user name:");
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		String userName = null;
		try {
			userName = bfr.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Please input your password:");
		BufferedReader bfr2 = new BufferedReader(new InputStreamReader(
				System.in));
		String userPassword = null;
		try {
			userPassword = bfr2.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SAXReader reader = new SAXReader();
		Element ele = null;
		try {
			Document doc = reader.read(new File("./src/files/Users.xml"));
			String xPath="//user[@name='" + userName
					+ "' and @password='" + userPassword + "']";
			ele = (Element) doc.selectSingleNode(xPath);
			if (ele != null) {
				System.out.println("Welcome.");
			} else {
				System.out.println("Error");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}