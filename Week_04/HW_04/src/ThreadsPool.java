import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenk
 * @create 2020/11/11 21:08
 */
public class ThreadsPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(new Thread() {
            @Override
            public void run() {
                Homework03 hw = new Homework03();
                System.out.println(getName() + "线程计算的结果为：" + hw.sum());
            }
        });
        pool.shutdown();
    }
}
