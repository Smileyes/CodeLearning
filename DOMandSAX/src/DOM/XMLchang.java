package DOM;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class XMLchang {

	public static void main(String[] args) {
		new XMLchang().launch();
	}

	@Test
	public void launch() {
		Document doc = DocumentHelper.createDocument();
		Element studnetsEle = doc.addElement("Students");
		Element studentEle = studnetsEle.addElement("Student");
		addNew(studentEle, "1", "张三", "男", "计算机1班", "广州天河");
		Element studentEle2 = studnetsEle.addElement("Student");
		addNew(studentEle2, "2", "小白", "女", "计算机2班", "福建福州");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream("./homework.xml"),
					format);
			writer.write(doc);
			writer.close();
			change(doc);
			remove(doc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNew(Element studentEle, String id, String name,
			String gender, String grade, String address) {
		studentEle.addAttribute("id", id);
		Element nameEle = studentEle.addElement("name");
		nameEle.setText(name);
		Element genderEle = studentEle.addElement("gender");
		genderEle.setText(gender);
		Element gradeEle = studentEle.addElement("grade");
		gradeEle.setText(grade);
		Element addressEle = studentEle.addElement("address");
		addressEle.setText(address);
	}

	public void change(Document doc) {
		Element ele = ((Element) doc.getRootElement().elements("Student")
				.get(1)).element("name");
		ele.setText("王丽");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream("./homework.xml"));
			writer.write(doc);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void remove(Document doc) {
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(
					"./homework.xml"));
			Element ele = (Element) doc.getRootElement().elements("Student")
					.get(1);
			ele.detach();
			writer.write(doc);
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
