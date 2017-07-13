package SAX;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.XMLReaderFactory;

public class xmlSAX {

	public static void main(String[] args) {
		new xmlSAX().launch();
	}

	public void launch() {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			DefaultHandler2 handler = new MyDefaultHandler();
			reader.setContentHandler(handler);
			reader.parse("./src/files/userS.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
