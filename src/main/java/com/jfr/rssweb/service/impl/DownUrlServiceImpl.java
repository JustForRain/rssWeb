package com.jfr.rssweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfr.rssweb.dao.DownUrlDao;
import com.jfr.rssweb.pojo.DownUrl;
import com.jfr.rssweb.service.DownUrlService;
import com.jfr.rssweb.util.SendMail;

@Service
public class DownUrlServiceImpl implements DownUrlService {
	@Autowired
	DownUrlDao downUrlDao;
	@Autowired
	SendMail sendMail;
	@Override
	public void add(DownUrl downUrl) {
		//添加下载地址
		downUrlDao.add(downUrl);
		//发送邮件提醒 以后改进为AOP 
		String addr="邮箱地址";
		String password="邮箱密码";
		String smtp="smtp.qq.com";
		String port="465";
		sendMail.init(addr, password, smtp, port, true);
		String title="您订阅的"+downUrl.getTitle()+"已更新";
		String context="<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><title>hello world</title></head><body><p>"+title+"</p><p><a href='"+downUrl.getDownLoadUrl()+"' target='_blank'>请点击此处下载</a> </p></body></html>";
		sendMail.sendMail(addr, addr, title, context);
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
