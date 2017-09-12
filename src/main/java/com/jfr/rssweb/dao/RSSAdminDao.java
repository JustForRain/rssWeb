package com.jfr.rssweb.dao;

import java.util.List;

import com.jfr.rssweb.pojo.RSSAdmin;

public interface RSSAdminDao {

	void add(RSSAdmin rssAdmin);
	void delete(Integer id);
	void update(RSSAdmin rssAdmin);
	List<RSSAdmin> findAll();
	RSSAdmin findByName(String rssName);
}
