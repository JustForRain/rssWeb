package com.jfr.rssweb.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jfr.rssweb.pojo.DownUrl;
import com.jfr.rssweb.pojo.RSSAdmin;
import com.jfr.rssweb.pojo.RSSItemBean;
import com.jfr.rssweb.service.DownUrlService;
import com.jfr.rssweb.service.RSSAdminService;

public class RssSchedule {
	@Autowired
	RSSAdminService adminService;
	@Autowired
	DownUrlService downUrlService;
	@Autowired
	RSS rss;

	public void getRssXml(){
		List<RSSAdmin> rssList=adminService.findAll();
		if(!rssList.isEmpty()){
			for(int i=0;i<rssList.size();i++){
				RSSAdmin rssAdmin=rssList.get(i);
				String url=rssAdmin.getUrl();
				List<RSSItemBean> rssItem=rss.getAllRssItemBeanList(url);
				for(int j=0;j<rssItem.size();j++){
					DownUrl insertDownUrl=new DownUrl();
					insertDownUrl.setRssid(rssList.get(i).getId());
					insertDownUrl.setTitle(rssItem.get(j).getTitle());
					insertDownUrl.setPubDate(rssItem.get(j).getPubDate());
					insertDownUrl.setAuthor(rssItem.get(j).getAuthor());
					insertDownUrl.setDownLoadUrl(rssItem.get(j).getDownLoadUrl());
					//先查询若存在则break，若不存在则insert
					if(downUrlService.findByOb(insertDownUrl)!=null)continue;
					//将记录存入数据库
					downUrlService.add(insertDownUrl);
				}
			}
			
		}
	}
}
