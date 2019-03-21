import net.zixue.crud.query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class test {
    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void testSql() throws SQLException, ClassNotFoundException {
        query.query();
    }

}
