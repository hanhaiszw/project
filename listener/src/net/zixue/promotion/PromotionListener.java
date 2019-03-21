package net.zixue.promotion;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.zixue.bean.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@WebListener()
public class PromotionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
                    QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);

                    String sql = "select * from product";
                    List<Product> productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
                    if (productList != null && productList.size() > 0) {
                        for (Product product : productList) {
                            if (product.getC_id() == 1) {
                                // 数码产品
                                BigDecimal p_price = product.getP_price();
                                // 减100
                                BigDecimal temp = new BigDecimal(100);
                                p_price = p_price.subtract(temp);
                                // 将修改好的价格设置回去
                                product.setP_price(p_price);
                                System.out.println(product.getP_name() + "现在打折促销了，只要" + product.getP_price() + "元，就可以拿回家啦！");

                            }else{
                                // 数码产品
                                BigDecimal p_price = product.getP_price();
                                // 减100
                                BigDecimal temp = new BigDecimal(10);
                                p_price = p_price.subtract(temp);
                                // 将修改好的价格设置回去
                                product.setP_price(p_price);
                                System.out.println(product.getP_name() + "现在打折促销了，只要" + product.getP_price() + "元，就可以拿回家啦！");
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, new Date(), 1000 * 60*30);  // 每30分钟执行一次
        // new Date()指的是第一次执行的日期，比如可以设置为双11
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
