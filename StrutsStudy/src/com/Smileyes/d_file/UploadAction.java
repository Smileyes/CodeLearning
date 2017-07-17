package com.Smileyes.d_file;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 *文件的上传
 */
public class UploadAction extends ActionSupport {
	private File upFile;
	private String upFileContentType;
	private String upFileFileName;
	private static final String path = ResourceBundle.getBundle("uploadDir").getString("dirPath");

	public void setUpFileFileName(String upFileFileName) {
		this.upFileFileName = upFileFileName;
	}

	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}

	public void setUpFileContentType(String upFileContentType) {
		this.upFileContentType = upFileContentType;
	}

	/*
	 * 文件上传
	 */
	public String upload() throws Exception {
		System.out.println(upFileFileName);
		System.out.println(upFile);
		File fileDir = new File(path, upFileFileName);
		FileUtils.copyFile(upFile, fileDir);
		return "success";
	}

}
