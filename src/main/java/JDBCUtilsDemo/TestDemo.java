package JDBCUtilsDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDemo {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void test01() throws SQLException {
        //1、获取连接对象
        conn = JDBCUtils.getConnection();
        //2、定义sql
        String sql = "select * from user where id = ?";
        //3、获取执行sql的对象
        ps = conn.prepareStatement(sql);
        //4、给？赋值
        ps.setInt(1,1);
        //5、执行sql
        rs = ps.executeQuery();
        //6、处理执行结果
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            System.out.println(user);
        }

        //7、释放资源
        rs.close();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        TestDemo testDemo = new TestDemo();
        testDemo.test01();
    }
}
