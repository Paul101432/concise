package com.hrz.seven.concise.core;

import com.hrz.seven.concise.core.CrawlerService;
import com.hrz.seven.concise.core.SysConsts;
import com.hrz.seven.concise.entity.JianShuInfos;
import com.hrz.seven.concise.kit.DateKit;
import com.jfinal.plugin.cron4j.ITask;
import com.jfinal.plugin.ehcache.CacheKit;

import java.util.List;

/**
 * Created by paul on 2017/6/10.
 */
public class CrawlerTask implements ITask {

    @Override
    public void run() {
        // 定时爬取数据并保存在缓存
        System.out.println(JianShuInfos.infos+" del");
        JianShuInfos.infos.clear();
        CrawlerService.init();
        System.out.println(JianShuInfos.infos+" init");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }
}
