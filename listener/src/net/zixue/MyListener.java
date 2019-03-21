package net.zixue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 使用注解的方法   就不用再web.xml中配置listener了
@WebListener()
public class MyListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public MyListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化方法执行");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁方法执行");
    }


}
