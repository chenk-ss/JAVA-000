import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author chenk
 * @create 2019/9/10 14:18
 */
public class Main {

    public final String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false";
    public final String username = "root";
    public final String password = "";
    public final String driver = "com.mysql.jdbc.Driver";

    DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 对数据库进行批量插入数据操作
     * 执行次数100万
     */
    public void insertBatch() {
        Date sTime = new Date();

        final String user_id = UUID.randomUUID().toString();
        final String seller_id = UUID.randomUUID().toString();
        final String goods_snapshot_id = UUID.randomUUID().toString();
        final String address_id = UUID.randomUUID().toString();
        final int num = 1;
        final double price_total = 1.1;
        final String pay_type = "支付宝";
        final double pay_price = 1.1;
        final String pay_url = "zhifubao_001";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pst;
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
//            String sql = null;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 1000000; i++) {
                if (i % 1000 == 0) {
                    System.out.println(i);
                }
                if (i < 50 || i % 50 != 0) {
                    sb.append( "insert into tb_order(`id`, `user_id`, `seller_id`, `goods_snapshot_id`, `address_id`, `num`, `price_total`, `pay_type`, `pay_price`, `pay_url`,`create_time`,`update_time`) "
                            + "values('" + UUID.randomUUID().toString() + "','" + user_id + "','" + seller_id + "','" + goods_snapshot_id + "','" + address_id + "'," + num + "," + price_total + ",'" + pay_type + "'," + pay_price + ",'" + pay_url + "','" + DF.format(new Date()) + "','" + DF.format(new Date())+ "');");
                    continue;
                } else {
                    System.out.println(sb.toString());
                    Statement stat = conn.createStatement();
                    stat.executeUpdate(sb.toString());
                }
                if (i % 100000 == 0) {
                    conn.commit();
                    System.out.println(i);
                    sb = new StringBuffer();
                }
            }
            System.out.println("execute end---------------");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
        Date eTime = new Date();
        System.out.println("time:" + (eTime.getTime() - sTime.getTime()) + "ms");
        System.out.println("-----------------");
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-----------------");
        Main t = new Main();
        t.insertBatch();
    }


}

