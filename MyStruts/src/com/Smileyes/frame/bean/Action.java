package com.Smileyes.frame.bean;

import java.util.Map;

public class Action {
	private String name;
	private String className;
	private String method;
	private Map<String, Result> results;

	public String getName() {
		return name;
	}

	public Map<String, Result> getResults() {
		return results;
	}

	public void setResults(Map<String, Result> results) {
		this.results = results;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
