package net.zixue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FirstServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 项目一启动就会执行
        System.out.println("servletContext初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 项目关闭时，执行
        System.out.println("servletContext销毁了");
    }
}
