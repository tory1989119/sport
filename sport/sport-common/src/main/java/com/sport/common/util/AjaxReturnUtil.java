package com.sport.common.util;

import java.util.List;

public class AjaxReturnUtil {
	private boolean success;
	private String msg;
	private List data;
	
	public AjaxReturnUtil(boolean success,String msg,List data) {
		setSuccess(success);
		setMsg(msg);
		setData(data);
	}
	
	public AjaxReturnUtil() {
	}
	
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
}
