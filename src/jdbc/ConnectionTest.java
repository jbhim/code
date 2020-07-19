package jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author jbhim
 * @date 2020/7/19/019.
 */
public class ConnectionTest {

    @Test
    public void testConnection() throws ClassNotFoundException, SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //jdbc:mysql: 协议
        //localhost:ip 地址
        //jbhim 数据库名称
        String url = "jdbc:mysql://amcjt.com:3306/jbhim?useSSL=false";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "JinTao/1998/0728");

        //获取到数据库连接
        Connection connect = driver.connect(url, properties);

        PreparedStatement preparedStatement = connect.prepareStatement("select UUID()");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String string = resultSet.getString(1);
            System.out.println(string);
        }

    }

    @Test
    public void testConnection1() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        //jdbc:mysql: 协议
        //localhost:ip 地址
        //jbhim 数据库名称
        String url = "jdbc:mysql://amcjt.com:3306/jbhim?useSSL=false";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "JinTao/1998/0728");
        Class.forName("com.mysql.cj.jdbc.Driver");

        /*Driver driver = (Driver) aClass.newInstance();
        DriverManager.registerDriver(driver);*/

        //获取到数据库连接
        Connection connect = DriverManager.getConnection(url, properties);

        PreparedStatement preparedStatement = connect.prepareStatement("select UUID()");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String string = resultSet.getString(1);
            System.out.println(string);
        }

    }
}
