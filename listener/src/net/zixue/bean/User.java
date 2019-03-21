package net.zixue.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private int id;
    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("对象被绑定了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("对象被解绑了");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
