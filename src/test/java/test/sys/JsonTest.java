package test.sys;

import com.hrz.seven.concise.entity.JianShuInfos;
import com.jfinal.kit.JsonKit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul on 2017/6/10.
 */
public class JsonTest {

    @Test
    public void t1(){
        JianShuInfos.infos.add(new JianShuInfos("title","author","url","date"));
        System.out.println(JianShuInfos.infos+" \t "+JianShuInfos.infos.size());
        System.out.println(JsonKit.toJson(JianShuInfos.infos));

        List<JianShuInfos> ls = new ArrayList<JianShuInfos>();
        for (int i = 0; i < 3; i++) {
            ls.add(new JianShuInfos("1","2","3","4"));
        }
        System.out.println(JsonKit.toJson(ls));
    }
}
