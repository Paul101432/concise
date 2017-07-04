package com.hrz.seven.concise.core;

import com.jfinal.core.Controller;

/**
 * Created by paul on 2017/5/28.
 */
public class JsonController extends Controller {

    public void renders(Object o){
        renderJson(o);
    }

}
