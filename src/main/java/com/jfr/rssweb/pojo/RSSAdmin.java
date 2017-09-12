package com.jfr.rssweb.pojo;

public class RSSAdmin {
	private Integer id;
	private String name;
	private String url;
	private String descc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescc() {
		return descc;
	}
	public void setDescc(String descc) {
		this.descc = descc;
	}
	@Override
	public String toString() {
		return "RSSAdmin [id=" + id + ", name=" + name + ", url=" + url + ", descc=" + descc + "]";
	}
	
}
