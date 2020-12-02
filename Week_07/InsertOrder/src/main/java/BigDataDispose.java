//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * @Author chenk
// * @create 2020/12/2 21:58
// */
//public class BigDataDispose implements Runnable {
//
//    @Overrides
//    public void run() {
//        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String userName = "root";
//        String password = "1234";
//
//        Connection conn = null;
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, userName, password);// 获取连接
//            conn.setAutoCommit(false);// 关闭自动提交，不然conn.commit()运行到这句会报错
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        // 开始时间
//        Long begin = new Date().getTime();
//        // SQL前缀
//        String prefix = "INSERT INTO finance(id, bill, money_num, amount_in_words,  remark, create_user) VALUES";
//        // 保存SQL后缀
//        StringBuffer suffix = new StringBuffer();
//        try {
//            // 设置事务为非自动提交
//            conn.setAutoCommit(false);
//            // 比起st，pst会更好些
//            PreparedStatement pst = conn.prepareStatement("insert into finance values (?,?,?,?,?,?)");//准备执行语句
//            // 外层循环，总提交事务次数
//            for (int i = 1; i <= 1; i++) {
//                suffix = new StringBuffer();
//                // 第j次提交步长
//                for (int j = 1; j <= 1000000; j++) {
//                    String num = String.valueOf(i * j);
//                    if (num.length() < 7) {
//                        for (int a = num.length(); a < 7; a++) {
//                            num = "0" + num;
//                        }
//                    }
//                    num = "DJ" + num;
//                    // 构建SQL后缀
//                    suffix.append("('" + j + "', '" + num + "', '1000', '1000',  '订单，哈哈', '李四'),");
//                }
//                // 构建完整SQL
//                String sql = prefix + suffix.substring(0, suffix.length() - 1);
//                // 添加执行SQL
//                pst.addBatch(sql);
//                // 执行操作
//                pst.executeBatch();
//                // 提交事务
//                conn.commit();
//
//
//
//                // 清空上一次添加的数据
//                suffix = new StringBuffer();
//            }
//            // 关闭连接
//            pst.close();
//            conn.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // 结束时间
//        Long end = new Date().getTime();
//        // 耗时
//        System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s"+"  插入完成");
//    }
//}
//
//
////public class Test {
////    public static void main(String[] args) throws InterruptedException {
////        BigDataDispose bdd = new BigDataDispose();
////        Thread thread = new Thread(bdd);
////        thread.start();
////        thread.join();
////    }
////}
