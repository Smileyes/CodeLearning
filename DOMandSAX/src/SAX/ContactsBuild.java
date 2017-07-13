package SAX;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * @用SAX解析创建Contact对象集合
 */
public class ContactsBuild {

	public static void main(String[] args) {
		new ContactsBuild().launch();
	}

	public void launch() {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			MyDefaultHandler2 dh = new MyDefaultHandler2();
			reader.setContentHandler(dh);
			reader.parse(
					"./src/files/contactsList.xml");
			List<Contact> contactsList = dh.getList();
			System.out.println(contactsList);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
