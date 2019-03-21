package net.zixue;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class FirstServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("属性被添加");
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("属性被删除");
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("属性被修改");
        // 打印出来的还是修改之后的值
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }
}
