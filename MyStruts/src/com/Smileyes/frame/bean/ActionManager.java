package com.Smileyes.frame.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ActionManager {
	private static Map<String, Action> allActions;// MyStruts中所有的Action对象
	static {
		allActions = new HashMap<String, Action>();
		init();
	}

	// 获得uri对应的Action
	public Action getAction(String uri) {
		if (uri == null || "".equals(uri.trim())) {
			throw new RuntimeException("URI发生错误！！！");
		}
		Action action = allActions.get(uri);
		if (action == null) {
			throw new RuntimeException("URI发生错误！！！");
		}
		return action;

	}

	/*
	 * 初始化方法，读取MyStruts.xml文件
	 */
	private static void init() {
		// 获得doc
		Document doc = null;
		SAXReader reader = new SAXReader();
		InputStream fis = ActionManager.class.getResourceAsStream("/myStruts.xml");
		try {
			doc = reader.read(fis);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
		// 获得根标签
		Element root = doc.getRootElement();
		// 获得Aciton标签
		List<Element> acEles = root.elements();
		// 遍历Action标签集合
		for (Element acEle : acEles) {
			Action action = new Action();
			action.setName(acEle.attributeValue("name"));
			action.setClassName(acEle.attributeValue("class"));
			action.setMethod(acEle.attributeValue("method"));
			// 获得Request标签的Iterator接口
			Iterator<Element> it = acEle.elementIterator();
			Map<String, Result> results = new HashMap<String, Result>();
			while (it.hasNext()) {
				Result result = new Result();
				Element reEle = it.next();
				result.setName(reEle.attributeValue("name"));
				result.setType(reEle.attributeValue("type"));
				result.setPage(reEle.getTextTrim());
				results.put(result.getName(), result);
			}
			action.setResults(results);
			allActions.put(action.getName(), action);
		}
	}
}
