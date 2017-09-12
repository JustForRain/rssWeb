package com.jfr.rssweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfr.rssweb.dao.RSSAdminDao;
import com.jfr.rssweb.pojo.RSSAdmin;
import com.jfr.rssweb.service.RSSAdminService;

@Service
public class RSSAdminServiceImpl implements RSSAdminService {
	@Autowired
	RSSAdminDao rssAdminDao;
	@Override
	public void add(RSSAdmin rssAdmin) {
		rssAdminDao.add(rssAdmin);

	}

	@Override
	public void delete(Integer id) {
		rssAdminDao.delete(id);
	}

	@Override
	public void update(RSSAdmin rssAdmin) {
		rssAdminDao.update(rssAdmin);
	}

	@Override
	public List<RSSAdmin> findAll() {
		return rssAdminDao.findAll();
	}

	@Override
	public RSSAdmin findByName(String rssName) {
		return rssAdminDao.findByName(rssName);
	}

}
