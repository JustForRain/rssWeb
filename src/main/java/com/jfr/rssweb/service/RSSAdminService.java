package com.jfr.rssweb.service;

import java.util.List;

import com.jfr.rssweb.pojo.RSSAdmin;

public interface RSSAdminService {
	void add(RSSAdmin rssAdmin);
	void delete(Integer id);
	void update(RSSAdmin rssAdmin);
	List<RSSAdmin> findAll();
	RSSAdmin findByName(String rssName);
}
