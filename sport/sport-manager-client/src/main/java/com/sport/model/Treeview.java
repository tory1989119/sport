package com.sport.model;

import java.util.List;

public class Treeview {
	private String text;
	private List<Treeview> nodes;
	private String id;
	private TreeviewState state;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Treeview> getNodes() {
		return nodes;
	}
	public void setNodes(List<Treeview> nodes) {
		this.nodes = nodes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TreeviewState getState() {
		return state;
	}
	public void setState(TreeviewState state) {
		this.state = state;
	}
}
