package xml_01;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class contactRead {

	public static void main(String[] args) throws Exception {
		new contactRead().launch();
	}

	@Test
	public void launch() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/files/contactsList.xml"));
		Element rootEle = doc.getRootElement();
		getChildNodes(rootEle);
	}

	private void getChildNodes(Element element) {
		System.out.print("<" + element.getName());
		List<Attribute> list = element.attributes();
		if (list != null) {
			for (Attribute attr : list) {
				System.out.print(" " + attr.getName() + "=\"" + attr.getValue()+"\"");
			}
		}
		System.out.print(">");
		Iterator<Node> it = element.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			if (node instanceof Element) {
				Element ele = (Element) node;
				getChildNodes(ele);
			}
			if (node instanceof Text) {
				Text text = (Text) node;
				System.out.print(text.getText());
			}
		}
		System.out.print("</" + element.getName() + ">");
	}
}