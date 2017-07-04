package com.hrz.seven.concise.service;

import com.hrz.seven.concise.core.JsonController;
import com.hrz.seven.concise.entity.JianShuInfos;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

/**
 * 外部接口
 * Created by paul on 2017/4/22.
 */
public class ApiController extends JsonController{

    public void index(){
        renders(" nothing to see ");
    }

    // 返回简书头条
    public void getDateJianShu(){
        renders(JianShuInfos.infos);
    }


}
