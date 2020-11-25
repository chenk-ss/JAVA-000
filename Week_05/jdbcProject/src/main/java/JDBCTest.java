import java.sql.*;

/**
 * @Author chenk
 * @create 2020/11/19 11:11
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
//        insert();
        select();
//        delete();
//        update();
    }

    public static void insert() throws Exception {
        // 1. 注册驱动
        // 使用java.sql.DriverManager类的静态方法registerDriver(Driver driver)
        // Driver是一个接口,参数传递:MySQL驱动程序的实现类
        // DriverManager.registerDriver(new Driver());
        // 查看驱动类源码,注册两次驱动,浪费资源
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获得连接
        // uri:数据库地址 jdbc:mysql://连接主机ip:端口号//数据库名字
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        // static Connection getConnection(String url, String user, String password)
        // 返回值是java.sql.Connection接口的实现类,在MySQL驱动程序中
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        System.out.println(conn);// com.mysql.jdbc.JDBC4Connection@10d1f30
        // 3. 获得语句执行平台,通过数据库连接对象,获取到SQL语句的执行者对象
        //conn对象,调用方法 Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
        //返回的是Statement接口的实现类对象,在MySQL驱动程序中
        Statement stat = conn.createStatement();
        System.out.println(stat);//com.mysql.jdbc.StatementImpl@137bc9
        // 4. 执行sql语句
        //通过执行者对象调用方法执行SQL语句,获取结果
        //int executeUpdate(String sql)  执行数据库中的SQL语句,仅限于insert,update,delete
        //返回值int,操作成功数据库的行数
        int row = stat.executeUpdate("INSERT INTO tb_user(id, name) VALUES(1, 'chenk')");
        System.out.println(row);
        // 5. 释放资源
        stat.close();
        conn.close();
    }

    public static void select() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        // 3.获取执行SQL语句
        Statement stat = conn.createStatement();
        // 拼写SQL语句
        String sql = "select * from tb_user";
        // 4.调用执行者对象方法,执行SQL语句获取结果集
        // 返回的是ResultSet接口的实现类对象,实现类在mysql驱动中
        ResultSet rs = stat.executeQuery(sql);
        // System.out.println(rs);//com.mysql.jdbc.JDBC4ResultSet@18cef0a
        // 5.处理结果集
        // ResultSet接口的方法 boolean next() 有结果集true,没有结果集返回false
        while (rs.next()) {
            // 获取每列的数据,使用的是ResultSet接口的方法getXXX
            int sid = rs.getInt("id");// 相当于rs.getInt(1);这个方法有弊端
            String sname = rs.getString("name");

            System.out.println(sid + "\t" + sname);

        }
        // 6.关闭资源
        rs.close();
        stat.close();
        conn.close();
    }

    public static void delete() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        // 3.获取执行SQL语句
        Statement stat = conn.createStatement();
        // 拼写SQL语句
        String sql = "delete from tb_user where id = 1";
        // 4.调用执行者对象方法,执行SQL语句获取结果集
        //返回值int,操作成功数据库的行数
        boolean r = stat.execute(sql);
        System.out.println(r);
        // 5. 释放资源
        stat.close();
        conn.close();
    }


    public static void update() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        // 3.获取执行SQL语句
        Statement stat = conn.createStatement();
        // 拼写SQL语句
        String sql = "update tb_user set name = 'chen001' where id = 1";
        // 4.调用执行者对象方法,执行SQL语句获取结果集
        //返回值int,操作成功数据库的行数
        int row = stat.executeUpdate(sql);
        System.out.println(row);
        // 5. 释放资源
        stat.close();
        conn.close();
    }

}

