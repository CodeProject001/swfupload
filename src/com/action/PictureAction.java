package com.action;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;


import com.model.Picture;
import com.opensymphony.xwork2.ActionSupport;

public class PictureAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File file;
	
    private String fileFileName;
    
    private String fileContentType;
    
    
	
	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public String getFileFileName() {
		return fileFileName;
	}



	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



	/**
	 * 用于实现上传功能
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//实现上传
		InputStream is = new FileInputStream(file);
		String root = ServletActionContext.getRequest().getRealPath("/upload");
		System.out.println(this.getFileContentType() );
		File deskFile = new File(root,this.getFileFileName());
		OutputStream os = new FileOutputStream(deskFile);
		byte [] bytefer = new byte[400];
		int length = 0 ; 
		while((length = is.read(bytefer) )>0)
		{
			os.write(bytefer,0,length);
		}
		os.close();
		is.close();
		return SUCCESS;
	}
	 
		
}
