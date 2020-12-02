import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenk
 * @create 2019/9/10 14:18
 */
public class Main {

    public final String url = "jdbc:mysql://127.0.0.1:3306/shop";
    public final String username = "root";
    public final String password = "a123";
    public final String driver = "com.mysql.jdbc.Driver";


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

        ExecutorService pool = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 10000; i++) {
            pool.execute(new Thread() {
                @Override
                public void run() {        
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;
                    PreparedStatement pst;
                    try {
                        conn = DriverManager.getConnection(url, username, password);
//                        conn.setAutoCommit(false);
                        String sql = "insert into tb_order(`id`,\n" +
                                "\t`user_id`,\n" +
                                "\t`seller_id`,\n" +
                                "\t`goods_snapshot_id`,\n" +
                                "\t`address_id`,\n" +
                                "\t`num`,\n" +
                                "\t`price_total`,\n" +
                                "\t`pay_type`,\n" +
                                "\t`pay_price`,\n" +
                                "\t`pay_url`,\n" +
                                "\t`create_time`,\n" +
                                "\t`update_time`) "
                                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
                        pst = conn.prepareStatement(sql);
                        pst.setObject(1, UUID.randomUUID().toString());
                        pst.setObject(2, user_id);
                        pst.setObject(3, seller_id);
                        pst.setObject(4, goods_snapshot_id);
                        pst.setObject(5, address_id);
                        pst.setObject(6, num);
                        pst.setObject(7, price_total);
                        pst.setObject(8, pay_type);
                        pst.setObject(9, pay_price);
                        pst.setObject(10, pay_url);
                        pst.setObject(11, new Date());
                        pst.setObject(12, new Date());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        close(conn, stmt, rs);
                    }
                }
            });

        }
        pool.shutdown();
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

