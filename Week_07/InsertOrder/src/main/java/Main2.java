import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author chenk
 * @create 2019/9/10 14:18
 */
public class Main2 {

    public final String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false";
    public final String username = "root";
    public final String password = "";
    public final String driver = "com.mysql.jdbc.Driver";

    DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 对数据库进行批量插入数据操作
     * 执行次数100万
     */
    public void insertBatch() throws SQLException {
        final String user_id = UUID.randomUUID().toString();
        final String seller_id = UUID.randomUUID().toString();
        final String goods_snapshot_id = UUID.randomUUID().toString();
        final String address_id = UUID.randomUUID().toString();
        final int nums = 1;
        final double price_total = 1.1;
        final String pay_type = "支付宝";
        final double pay_price = 1.1;
        final String pay_url = "zhifubao_001";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);// 开始时间
        Long begin = new Date().getTime();
        // SQL前缀
        String prefix = "insert into tb_order(`id`, `user_id`, `seller_id`, `goods_snapshot_id`, `address_id`, `num`, `price_total`, `pay_type`, `pay_price`, `pay_url`,`create_time`,`update_time`) VALUES";
        // 保存SQL后缀
        StringBuffer suffix = new StringBuffer();
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("insert into tb_order values (?,?,?,?,?,?,?,?,?,?,?,?)");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 1; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 1000000; j++) {
                    String num = String.valueOf(i * j);
                    if (num.length() < 7) {
                        for (int a = num.length(); a < 7; a++) {
                            num = "0" + num;
                        }
                    }
                    if(j >= 1000 && j % 1000 == 0){
                        System.out.println(j);
                    }
                    num = "DJ" + num;
                    // 构建SQL后缀
                    suffix.append("('" + UUID.randomUUID().toString() + "','" + user_id + "','" + seller_id + "','" + goods_snapshot_id + "','" + address_id + "'," + nums + "," + price_total + ",'" + pay_type + "'," + pay_price + ",'" + pay_url + "','" + DF.format(new Date()) + "','" + DF.format(new Date())+ "'),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();


                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 关闭连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s" + "  插入完成");
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
    public static void main(String[] args) throws SQLException {
        System.out.println("-----------------");
        Main2 t = new Main2();
        t.insertBatch();
    }


}

