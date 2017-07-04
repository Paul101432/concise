package com.hrz.seven.concise.core;

/**
 * Created by paul on 2017/6/1.
 */
public interface CrawlerConsts {

    // 多页爬取  一个一条记录
    String JIAN_SHU_TARGET = "http://www.jianshu.com/p/\\w+";
    String JIAN_SHU_HELP = "http://www.jianshu.com";
    String JIAN_SHU_TITLE = "//h1/text()";
    String JIAN_SHU_AUTHOR = "//[@class=\"name\"]/a/text()";


    // 单页爬取  一页多记录  使用属性是数组
    String WEI_BO_TARGET = "";
    String WEI_BO_HELP = "";
    String WEI_BO_TITLE = "";
    String WEI_BO_AUTHOR = "";

}
