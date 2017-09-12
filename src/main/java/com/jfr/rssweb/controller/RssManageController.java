package com.jfr.rssweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfr.rssweb.pojo.DownUrl;
import com.jfr.rssweb.pojo.RSSAdmin;
import com.jfr.rssweb.service.DownUrlService;
import com.jfr.rssweb.service.RSSAdminService;

@Controller
@RequestMapping("rssadmin")
public class RssManageController {
	@Autowired
	RSSAdminService rssAdminService;
	@Autowired
	DownUrlService downUrlService;
	@RequestMapping("add")
	public void add(RSSAdmin rssAdmin){
		rssAdminService.add(rssAdmin);
	}
	@RequestMapping("delete")
	public void delete(Integer id){
		rssAdminService.delete(id);
	}
	@RequestMapping("update")
	public void update(RSSAdmin rssAdmin){
		rssAdminService.update(rssAdmin);
	}
	@ResponseBody
	@RequestMapping("findAll")
	public Map<String,Object> findAll(){
		Map<String,Object> map=new HashMap<String, Object>();
		List<RSSAdmin> list=rssAdminService.findAll();
		map.put("list",list);
		return map;
	}
	@ResponseBody
	@RequestMapping("findByRssId")
	public Map<String,Object> findByRssId(Integer rssid){
		Map<String,Object> map=new HashMap<String, Object>();
		List<DownUrl> list=downUrlService.findByRssId(rssid);
		map.put("list",list);
		return map;
	}
	@ResponseBody
	@RequestMapping("findByRssName")
	public Map<String,Object> findByRssName(String rssName){
		Map<String,Object> map=new HashMap<String, Object>();
		RSSAdmin rss=rssAdminService.findByName(rssName);
		List<DownUrl> list=downUrlService.findByRssId(rss.getId());
		map.put("list",list);
		return map;
	}
	@ResponseBody
	@RequestMapping("recent")
	public Map<String,Object> recent(){
		Map<String,Object> map=new HashMap<String, Object>();
		List<DownUrl> list=downUrlService.findByRecent();
		map.put("list",list);
		return map;
	}
}
