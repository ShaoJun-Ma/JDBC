package JDBCDemo;
import java.sql.*;

//使用Statement

public class TestDemo01 {
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    public void test01() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取数据库连接的对象
        conn = DriverManager.getConnection("jdbc:mysql:///jdbcTest", "root", "msj");
        //3、定义sql
        String sql = "select * from user";
        //4、获取执行sql的对象
        statement = conn.createStatement();
        //5、执行sql
        rs = statement.executeQuery(sql);
        //6、处理结果集
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            System.out.println(user);

        }
        //7、释放资源
        rs.close();
        statement.close();
        conn.close();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestDemo01 testDemo01 = new TestDemo01();
        testDemo01.test01();
    }
}
