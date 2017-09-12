package com.jfr.rssweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfr.rssweb.dao.DownUrlDao;
import com.jfr.rssweb.pojo.DownUrl;
import com.jfr.rssweb.service.DownUrlService;

@Service
public class DownUrlServiceImpl implements DownUrlService {
	@Autowired
	DownUrlDao downUrlDao;
	@Override
	public void add(DownUrl downUrl) {
		downUrlDao.add(downUrl);
	}

	@Override
	public void delete(Integer id) {
		downUrlDao.delete(id);
	}

	@Override
	public void update(DownUrl downUrl) {
		downUrlDao.update(downUrl);
	}

	@Override
	public List<DownUrl> findAll() {
		return downUrlDao.findAll();
	}

	@Override
	public DownUrl findByOb(DownUrl insertDownUrl) {
		return downUrlDao.findByOb(insertDownUrl);
	}

	@Override
	public List<DownUrl> findByRssId(Integer rssid) {
		return downUrlDao.findByRssId(rssid);
	}

	@Override
	public List<DownUrl> findByRecent() {
		return downUrlDao.findByRecent();
	}

}
