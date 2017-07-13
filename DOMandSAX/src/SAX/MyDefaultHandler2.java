package SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

public class MyDefaultHandler2 extends DefaultHandler2 {
	private List<Contact> list = new ArrayList<Contact>();
	private Contact contact = null;
	private String curTag = null;

	public List<Contact> getList() {
		return list;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		int num = attributes.getLength();
		curTag = qName;
		for (int i = 0; i < num; i++) {
			if (attributes.getLocalName(i) == "id") {
				contact = new Contact();
				contact.setId(attributes.getValue(i));
				list.add(contact);
			}
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch, start, length);
		if ("name".equals(curTag)) {
			contact.setName(str);
		}
		if ("password".equals(curTag)) {
			contact.setPassword(str);
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		curTag = null;
	}
}
