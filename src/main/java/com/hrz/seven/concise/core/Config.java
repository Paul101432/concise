package com.hrz.seven.concise.core;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.druid.wall.WallFilter;
import com.hrz.seven.concise.service.ApiController;
import com.hrz.seven.concise.service.DataController;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

import java.sql.SQLException;

import static com.hrz.seven.concise.core.SysConsts.*;

/**
 * Created by paul on 2017/4/19.
 */
public class Config extends JFinalConfig{

    private static boolean dev ;

    static  {
        String osName = System.getenv().get("USERNAME");
        PropKit.use(osName + SYS_FIEL_SUFFIX);
        dev = PropKit.getBoolean("devMode", false);
    }


    @Override
    public void configConstant(Constants me) {
        me.setDevMode(dev);
        me.setError404View("404.html");
        me.setError500View("500.html");

    }

    @Override
    public void configRoute(Routes me) {
        me.add("/data",DataController.class);
        me.add("/api",ApiController.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin db = initDruidPlugin(PropKit.get(DEFALUT_DB_URL), PropKit.get(DEFALUT_DB_USERNAME), PropKit.get(DEFALUT_DB_PWD));
        ActiveRecordPlugin removalsRecordPlugin = initActiveRecordPlugin(PropKit.get(DEFALUT_DB_NAME), db);
        Cron4jPlugin cron4jPlugin = new Cron4jPlugin();
        me.add(db).add(removalsRecordPlugin).add(cron4jPlugin);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }


    protected DruidPlugin initDruidPlugin(String url, String username, String password) {
        WallFilter wall = new WallFilter();
        String dbType = null;
        try {
            dbType = JdbcUtils.getDbType(url, JdbcUtils.getDriverClassName(url));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        wall.setDbType(dbType);

        DruidPlugin dp = new DruidPlugin(url, username, password);
        dp.addFilter(new StatFilter());
        dp.addFilter(wall);
        return dp;
    }

    public ActiveRecordPlugin initActiveRecordPlugin(String db, DruidPlugin dp) {
        ActiveRecordPlugin arp = new ActiveRecordPlugin(db, dp);
        arp.setDialect(new MysqlDialect());
        arp.setDevMode(dev);
        arp.setShowSql(dev);
        return arp;
    }
}
