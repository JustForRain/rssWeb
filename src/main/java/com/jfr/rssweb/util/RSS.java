package com.jfr.rssweb.util;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.jfr.rssweb.pojo.RSSItemBean;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
//http://zmfkplj.iteye.com/blog/461398
public class RSS {
    public  List<RSSItemBean> getAllRssItemBeanList(String rssUrl){  
        try{  
            URL feedUrl = new URL(rssUrl);  
            SyndFeedInput input = new SyndFeedInput();  
            SyndFeed feed = input.build(new XmlReader(feedUrl));            
            List<SyndEntry> entries = feed.getEntries();                
            RSSItemBean item = null;  
            List<RSSItemBean> rssItemBeans = new ArrayList<RSSItemBean>();                
            for(SyndEntry entry : entries){  
                item = new RSSItemBean();
                //标题
                item.setTitle(entry.getTitle().trim());
                //类型
                item.setType(feed.getTitleEx().getValue().trim());
                //URL
                item.setUri(entry.getUri());
                //发布日期
                item.setPubDate(entry.getPublishedDate());
                //作者
                item.setAuthor(entry.getAuthor());
                //下载链接
                List<SyndEnclosure> enclosures=entry.getEnclosures();
                if(enclosures.size()>0){
                	item.setDownLoadUrl(enclosures.get(0).getUrl());
                }else{
                	item.setDownLoadUrl("null");
                }
                rssItemBeans.add(item);                
            }  
            return rssItemBeans;                
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
          
    }  
}