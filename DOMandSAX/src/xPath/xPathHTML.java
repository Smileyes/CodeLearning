package xPath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class xPathHTML {

	public static void main(String[] args) {
		new xPathHTML().launch();
	}

	public void launch() {
		try {
			Document doc = new SAXReader().read("./src/files/personList.html");
			List<Element> list = doc.selectNodes("//tbody/tr");
			List<Element> headList = doc.selectNodes("//th");
			for (Element trEle : list) {
				List<Element> tdList = trEle.selectNodes("td");
				for (int i = 0; i < tdList.size(); i++) {
					System.out.print(headList.get(i).getTextTrim() + ":"
							+ tdList.get(i).getTextTrim() + " ");
				}
				System.out.println();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
