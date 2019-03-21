package net.zixue.bean;

import java.math.BigDecimal;

public class Product {
    private int p_id;
    private String p_name;
    private BigDecimal p_price;
    private String p_image;
    private int c_id;

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ",p_name='" + p_name + '\'' +
                ",p_price=" + p_price +
                ",p_image='" + p_image + '\'' +
                ",c_id=" + c_id +
                '}';
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public BigDecimal getP_price() {
        return p_price;
    }

    public void setP_price(BigDecimal p_price) {
        this.p_price = p_price;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}
