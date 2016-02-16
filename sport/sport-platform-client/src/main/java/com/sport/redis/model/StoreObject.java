package com.sport.redis.model;

import java.io.Serializable;

public class StoreObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Object object;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
