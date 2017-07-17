package com.Smileyes.d_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownAction extends ActionSupport {
	/*
	 * 文件列表
	 */
	private static final String path = ResourceBundle.getBundle("uploadDir").getString("dirPath");
	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
		System.out.println(path);
		System.out.println(fileName);
	}

	public String getDownFileName() throws Exception {
		fileName = URLEncoder.encode(fileName, "utf-8");
		return fileName;
	}

	public InputStream getAttrInputStream() throws Exception {
		InputStream fis = new FileInputStream(new File(path, fileName));
		System.out.println(fis);
		return fis;
	}

	public String list() throws Exception {
		File file = new File(path);
		String[] files = file.list();
		ActionContext ac = ActionContext.getContext();
		ac.getContextMap().put("fileList", files);
		return SUCCESS;
	}

	public String down() throws Exception {
		return SUCCESS;
	}

}
