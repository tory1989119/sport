package com.sport.util;

public class FileUploadUtil {
	private String error;
	private String url;
	
	public FileUploadUtil() {
	}
	
	public FileUploadUtil(String error,String url) {
		setError(error);
		setUrl(url);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
