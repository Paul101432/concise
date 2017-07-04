package com.hrz.seven.concise.kit;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by paul on 2017/5/28.
 */
public class ObjKit {

    public static boolean isEmpty(Object obj){
        boolean empty=false;
        if(obj==null){
            empty=true;
        }else if(obj instanceof String ||obj instanceof StringBuffer ||obj instanceof StringBuilder){
            empty="".equals(String.valueOf(obj));
        }//Collection集合
        else if(obj instanceof Collection){
            Collection conn=(Collection)obj;
            empty=conn.isEmpty();
        }//Map集合
        else if(obj instanceof Map){
            Map map=(Map)obj;
            empty=map.isEmpty();
        }//数组
        else if(obj.getClass().isArray()){
            empty= Array.getLength(obj)<1;
        }else{
           throw new RuntimeException("不支持的类型"+obj+"，判断是否为空！");
        }
        return empty;
    }

    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }



}
