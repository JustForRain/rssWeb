package com.jfr.rssweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.jfr.rssweb.dao.RSSAdminDao;
import com.jfr.rssweb.mapper.RSSAdminMapper;
import com.jfr.rssweb.pojo.RSSAdmin;
@Repository
public class RSSAdminDaoImpl extends SqlSessionDaoSupport implements RSSAdminDao {
	@Resource
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public void add(RSSAdmin rssAdmin) {
		RSSAdminMapper mapper=getSqlSession().getMapper(RSSAdminMapper.class);
		mapper.add(rssAdmin);
	}

	@Override
	public void delete(Integer id) {
		RSSAdminMapper mapper=getSqlSession().getMapper(RSSAdminMapper.class);
		mapper.delete(id);
	}

	@Override
	public void update(RSSAdmin rssAdmin) {
		RSSAdminMapper mapper=getSqlSession().getMapper(RSSAdminMapper.class);
		mapper.update(rssAdmin);
	}

	@Override
	public List<RSSAdmin> findAll() {
		RSSAdminMapper mapper=getSqlSession().getMapper(RSSAdminMapper.class);
		return mapper.findAll();
	}

	@Override
	public RSSAdmin findByName(String rssName) {
		RSSAdminMapper mapper=getSqlSession().getMapper(RSSAdminMapper.class);
		return mapper.findByName(rssName);
	}

}
