package com.jfr.rssweb.dao;

import java.util.List;

import com.jfr.rssweb.pojo.DownUrl;

public interface DownUrlDao {
	void add(DownUrl downUrl);
	void delete(Integer id);
	void update(DownUrl downUrl);
	List<DownUrl> findAll();
	DownUrl findByOb(DownUrl insertDownUrl);
	List<DownUrl> findByRssId(Integer rssid);
}
