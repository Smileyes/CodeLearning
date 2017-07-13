package SAX;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

public class MyDefaultHandler extends DefaultHandler2 {

	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
	}

	public void endDocument() throws SAXException {
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print(" <" + qName);
		int num = attributes.getLength();
		for (int i = 0; i < num; i++) {
			System.out.print(" " + attributes.getLocalName(i) + "=\""
					+ attributes.getValue(i) + "\"");
		}
		System.out.print(">");
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.print("</" + qName + ">");
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch, start, length);
		System.out.print(str);
	}

}
