package com.jfr.rssweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfr.rssweb.pojo.RSSItemBean;
import com.jfr.rssweb.util.RSS;

@Controller
public class RssController {
	@ResponseBody
	@RequestMapping("search")
	public Map<String,Object> search(String rssUrl){
		Map<String,Object> date = new HashMap<String,Object>();
		RSS rss=new RSS();
		List<RSSItemBean> list=rss.getAllRssItemBeanList(rssUrl);
		/*以下为测试数据
		List<RSSItemBean> list=new ArrayList<RSSItemBean>();
		for(int i=0;i<10;i++){
			RSSItemBean test=new RSSItemBean();
			test.setAuthor("作者"+i);
			test.setPubDate(new Date());
			test.setDownLoadUrl("download url "+i);
			list.add(test);
		}
		*/
		if(list!=null){
			date.put("list",list);
		}
		return date;
	}
}
