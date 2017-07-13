package xml_01;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class NewContact {

	public static void main(String[] args) {
		List<Contact> contactsList = new ArrayList<Contact>();
		new NewContact().launch(contactsList);
		for (Contact t : contactsList) {
			System.out.println(t);
		}
	}

	public void launch(List list) {
		SAXReader reader = new SAXReader();
		try {
			Element rootEle = reader.read(
					new File("./src/files/contactsList.xml")).getRootElement();
			getChildEle(rootEle, list);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void getChildEle(Element element, List list) {
		List<Element> listC = element.elements("contact");
		for (Element ele : listC) {
			try {
				Contact t = (Contact) Class.forName("xml_01.Contact")
						.getConstructor().newInstance();
				t.setId(Integer.parseInt(ele.attributeValue("id")));
				t.setName(ele.elementTextTrim("name"));
				t.setPassword(ele.element("password").getTextTrim());
				list.add(t);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
