package com.jfr.rssweb.pojo;

import java.util.Date;

public class DownUrl {
	private Integer id;
	private Integer rssid;
	private String title;
	private Date pubDate;
	private String author;
	private String downLoadUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRssid() {
		return rssid;
	}
	public void setRssid(Integer rssid) {
		this.rssid = rssid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDownLoadUrl() {
		return downLoadUrl;
	}
	public void setDownLoadUrl(String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
	}
	
}
