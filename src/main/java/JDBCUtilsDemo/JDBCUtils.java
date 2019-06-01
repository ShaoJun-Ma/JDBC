package JDBCUtilsDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            //1、获取配置文件
            Properties pro = new Properties();
            pro.load(new FileReader("D:\\code\\java2\\java01\\JDBC\\src\\main\\java\\JDBCUtilsDemo\\db.properties"));

            //2、获取数据源
            driver = pro.getProperty("jdbc.driver");
            url = pro.getProperty("jdbc.url");
            username = pro.getProperty("jdbc.username");
            password = pro.getProperty("jdbc.password");

            //3、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4、获取数据库连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //5、释放资源
    public void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        rs.close();
        ps.close();
        conn.close();
    }

}
