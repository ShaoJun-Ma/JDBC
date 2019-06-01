package JDBCDemo;

import java.sql.*;

//使用PreparedStatement：防止sql注入

public class TestDemo02 {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void test02() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取数据库连接的对象
        conn = DriverManager.getConnection("jdbc:mysql:///jdbcTest", "root", "msj");
        //3、定义sql
        String sql = "select * from user where id = ?";
        //4、获取执行sql的对象
        pst = conn.prepareStatement(sql);
        //给？赋值
        pst.setInt(1,2);
        //5、执行sql
        rs = pst.executeQuery();
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
        pst.close();
        conn.close();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestDemo02 testDemo02 = new TestDemo02();
        testDemo02.test02();
    }
}
