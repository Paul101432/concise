package com.hrz.seven.concise.service;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * 数据接口
 *
 * Created by paul on 2017/5/28.
 */
public class DataController extends Controller{


    //保存用户信息
    public void userInfo(){
        String ip = getPara("ip");
        String area = getPara("area");
        Db.save("loginlog", new Record().set("ip",ip).set("area",area));

    }
}
