import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author chenk
 * @create 2020/11/19 14:22
 */
public class HikariTest {
    public static void main(String[] args) throws Exception {
        Connection conn = HikariCP.getConnection("root", "a123",
                "jdbc:mysql://localhost:3306/jdbctest", "com.mysql.jdbc.Driver");
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
pst.close();
        conn.close();
    }
}
