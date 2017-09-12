package com.jfr.rssweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.jfr.rssweb.dao.DownUrlDao;
import com.jfr.rssweb.mapper.DownUrlMapper;
import com.jfr.rssweb.pojo.DownUrl;
@Repository
public class DownUrlDaoImpl extends SqlSessionDaoSupport implements DownUrlDao {
	
	@Resource
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public void add(DownUrl downUrl) {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		downUrlMapper.add(downUrl);
	}

	@Override
	public void delete(Integer id) {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		downUrlMapper.delete(id);
	}

	@Override
	public void update(DownUrl downUrl) {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		downUrlMapper.update(downUrl);
	}

	@Override
	public List<DownUrl> findAll() {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		return downUrlMapper.findAll();
	}

	@Override
	public DownUrl findByOb(DownUrl insertDownUrl) {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		return downUrlMapper.findByOb(insertDownUrl);
	}

	@Override
	public List<DownUrl> findByRssId(Integer rssid) {
		DownUrlMapper downUrlMapper=getSqlSession().getMapper(DownUrlMapper.class);
		return downUrlMapper.findByRssId(rssid);
	}

}
