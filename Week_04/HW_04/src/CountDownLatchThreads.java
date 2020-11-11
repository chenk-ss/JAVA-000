import java.util.concurrent.CountDownLatch;

/**
 * @Author chenk
 * @create 2020/11/11 21:18
 */
public class CountDownLatchThreads {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch threadsSingal = new CountDownLatch(1);
        new Thread() {
            @Override
            public void run() {
                Homework03 hw = new Homework03();
                System.out.println(getName() + "线程计算的结果为：" + hw.sum());
            }
        }.run();
        threadsSingal.countDown();
        threadsSingal.await();
    }
}
