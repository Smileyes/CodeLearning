package xml_01;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class xmlBase {
	public static void main(String[] ars) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader
					.read(new File("./src/files/contactsList.xml"));
			System.out.println(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void Demo1() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/files/contactsList.xml"));
		Iterator<Node> it = doc.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			System.out.println(node.getName());
		}
	}

	@Test
	public void Demo2() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/files/contactsList.xml"));
		Element rootEle = doc.getRootElement();
		int i=0;
		getChildNodes(rootEle, i);
	}

	public void getChildNodes(Element ele, int num) throws Exception {
		for(int i=0;i<num;i++){
			System.out.print(" ");
		}
		System.out.println(ele.getName());
		Iterator<Node> i = ele.nodeIterator();
		while (i.hasNext()) {
			Node node = i.next();
			if (node instanceof Element) {
				Element ele2 =(Element)node;
				num+=2;
				getChildNodes(ele2, num);
				num -=2;;
			}
		}
	}
}
