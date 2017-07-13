package Homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ContactsList {
	private File file = null;
	private XMLWriter writer = null;
	private SAXReader reader = new SAXReader();
	private BufferedReader bfr = null;
	private Document doc = null;

	public static void main(String[] args) {
		new ContactsList().launch();
	}

	public void launch() {
		decorate();
		for (int i = 0; i < 60; i++)
			System.out.print("=");
		System.out.println("\n");
		System.out.println("【1】添加联系人\n" + "【2】修改联系人\n" + "【3】删除联系人\n"
				+ "【4】查找联系人\n" + "【Q】退出\n");
		for (int i = 0; i < 60; i++)
			System.out.print("=");
		System.out.println("\n");
		bfr = new BufferedReader(new InputStreamReader(System.in));
		boolean runProgram = true;
		while (runProgram) {
			try {
				String str = bfr.readLine();
				switch (str) {
				case "1": {
					addContact();
					break;
				}
				case "2": {
					changeContact();
					break;
				}
				case "3": {
					removeContact();
					break;
				}
				case "4": {
					Element ele = findContact();
					show(ele);
					break;
				}
				case "Q":
				case "q": {
					runProgram = false;
					break;
				}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void show(Element ele) {
		if (ele == null) {
			System.out.println("There isn't who you are searching!");
		} else {
			System.out.println("ID=" + ele.attributeValue("id") + "  Name="
					+ ele.elementTextTrim("name") + "  PhoneNumber="
					+ ele.elementTextTrim("phone"));
		}
	}

	// 添加根标签
	public void decorate() {
		file = new File("./src/files/cs.xml");
		if (!file.exists()) {
			doc = DocumentHelper.createDocument();
			OutputFormat format = OutputFormat.createPrettyPrint();
			doc.addElement("ContactsList");
			try {
				writer = new XMLWriter(new FileOutputStream(file), format);
				writer.write(doc);
				writer.flush();
				writer.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void changeContact() {
		System.out.println("search contact......");
		Element ele = findContact();
		if (ele == null) {
			System.out.println("There isn't who you are searching!");
		} else {
			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				writer = new XMLWriter(new FileOutputStream(file), format);
				System.out.println("input the new id");
				String id = bfr.readLine().trim();
				if (id != "" && id != null)
					ele.attribute("id").setValue(id);
				System.out.println("input the new name");
				String name = bfr.readLine().trim();
				ele.element("name").setText(name);
				if (name != "" && name != null)
					System.out.println("input the new number");
				String phone = bfr.readLine().trim();
				if (phone != "" && phone != null)
					ele.element("phone").setText(phone);
				writer.write(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void removeContact() {
		System.out.println("loaing......");
		Element ele = findContact();
		if (ele == null) {
			System.out.println("There isn't who you are secrching.");
		} else {
			ele.detach();
			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				writer = new XMLWriter(new FileOutputStream(file), format);
				writer.write(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Element findContact() {
		Element ele = null;
		System.out.println("Please choose one way:  ");
		System.out.println("1【By id】\n2【By name】");
		try {
			doc = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			String cWay = bfr.readLine();
			String numWay = null;
			if ("1".equals(cWay)) {
				System.out.println("please insert the id");
				numWay = bfr.readLine();
				ele = (Element) doc.selectSingleNode("//contact[@id='" + numWay
						+ "']");
			} else if ("2".equals(cWay)) {
				System.out.println("please insert the name");
				numWay = bfr.readLine();
				String xPath = "//name[text()='" + numWay + "']";
				Node parentNode = doc.selectSingleNode(xPath);
				if (parentNode != null) {
					ele = (Element) parentNode.getParent();
				}
			} else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ele;

	}

	public void addContact() {
		try {
			doc = reader.read(file);
			Element rootEle = (Element) doc.selectSingleNode("//ContactsList");
			System.out.println("Please insert your id");
			String id = bfr.readLine();
			Element conEle = rootEle.addElement("contact");
			conEle.addAttribute("id", id);
			System.out.println("Please insert your name");
			String name = bfr.readLine();
			Element nameEle = conEle.addElement("name");
			nameEle.setText(name);
			System.out.println("Please insert your phoneNumber");
			String number = bfr.readLine();
			Element numEle = conEle.addElement("phone");
			numEle.setText(number);
			OutputFormat format = OutputFormat.createPrettyPrint();
			writer = new XMLWriter(new FileOutputStream(file), format);
			writer.write(doc);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
