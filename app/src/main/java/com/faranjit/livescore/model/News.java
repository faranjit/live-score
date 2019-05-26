package com.faranjit.livescore.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@Root(name = "rss", strict = false)
public class News {

    @Element(name = "title")
    @Path("channel")
    private String channelTitle;

    @ElementList(name = "item", inline = true)
    @Path("channel")
    private List<NewsItem> newsItemList;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }
}
