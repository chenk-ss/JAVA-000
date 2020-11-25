import java.sql.*;

/**
 * @Author chenk
 * @create 2020/11/19 11:11
 */
public class PrepareJDBC {
    public static void main(String[] args) throws Exception {
        insert();
//        select();
//        delete();
//        update();
    }

    public static void select() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");

        // 拼写SQL语句
        String sql = "select * from tb_user where id = ? ";
        // 3.获取执行SQL语句
        //Connection接口
        PreparedStatement pst = conn.prepareStatement(sql);
        //调用pst对象的setXXX方法设置问号占位符的参数
        pst.setObject(1, 1);
        System.out.println(sql);
        // 4.调用执行者对象方法,执行SQL语句获取结果集
        ResultSet rs = pst.executeQuery();
        // 5.处理结果集
        while (rs.next()) {
            System.out.println(rs.getString("id") + "\t" + rs.getString("name"));
        }
        // 6.关闭资源
        rs.close();
        pst.close();
        conn.close();
    }


    public static void delete() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        conn.setAutoCommit(false);
        // 3.获取执行SQL语句
        Statement stat = conn.createStatement();
        // 拼写SQL语句
        String sql = "delete from tb_user where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            // 5.调用pst的方法setXXX设置?占位
            pst.setObject(1, 1);
            // 6.调用pst方法执行SQL语句
            pst.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            // 5. 释放资源
            stat.close();
            conn.close();
        }
    }


    public static void update() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        conn.setAutoCommit(false);
        // 3.拼写修改的SQL语句,参数采用?占位
        String sql = "UPDATE tb_user SET name=? WHERE id=?";
        // 4.调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
        PreparedStatement pst = conn.prepareStatement(sql);
        try {
            // 5.调用pst的方法setXXX设置?占位
            pst.setObject(1, "chenk001");
            pst.setObject(2, 1);
            // 6.调用pst方法执行SQL语句
            pst.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            // 7.关闭资源
            pst.close();
            conn.close();
        }
    }

    public static void insert() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/jdbctest";
        Connection conn = DriverManager.getConnection(url, "root", "a123");
        conn.setAutoCommit(false);
        // 3.拼写修改的SQL语句,参数采用?占位
        String sql = "insert into tb_user(id, name) values(?, ?)";
        // 4.调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
        PreparedStatement pst = conn.prepareStatement(sql);
        try {
            // 5.调用pst的方法setXXX设置?占位
            pst.setObject(1, 1);
            pst.setObject(2, "chen001");
            // 6.调用pst方法执行SQL语句
            pst.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            // 7.关闭资源
            pst.close();
            conn.close();
        }
    }

}

