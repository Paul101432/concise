package com.hrz.seven.concise.core;

import com.hrz.seven.concise.entity.JianShuInfos;
import com.hrz.seven.concise.kit.DateKit;
import com.jfinal.plugin.ehcache.CacheKit;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.List;
import java.util.Set;

import static com.hrz.seven.concise.core.CrawlerConsts.*;

/**
 * 爬虫服务模块demo
 * <p>
 * <p>
 * 爬取 简书首页http://www.jianshu.com/
 * <p>
 * <p>
 * Created by paul on 2017/2/4.
 */

@TargetUrl(JIAN_SHU_TARGET)
@HelpUrl(JIAN_SHU_HELP)
public class CrawlerService implements AfterExtractor {

    private static int num = 0 ;

    private static Spider spider = OOSpider.create(Site.me(), new ConsolePageModelPipeline(), CrawlerService.class)
            .addUrl(JIAN_SHU_HELP);

    @ExtractBy(JIAN_SHU_TITLE)
    private String title;

    @ExtractBy(JIAN_SHU_AUTHOR)
    private String author;

    private String url ;

    /**
     * 启动爬虫
     */
    public static void init() {
        spider.run();
    }

    @Override
    public void afterProcess(Page page) {

        if (num > SysConsts.CRAWLER_NUM) {
            spider.stop();
            // 爬虫停止后 初始化原参数 保证下次使用
            num = 0;
        }else if(num>=SysConsts.CRAWLER_NUM){
            num++;
        }else{
            JianShuInfos info = new JianShuInfos(title,author,page.getRequest().getUrl(), DateKit.now());
            JianShuInfos.infos.add(info);
            num++;
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CrawlerService{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
