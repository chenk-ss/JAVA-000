import java.util.concurrent.Semaphore;

/**
 * @Author chenk
 * @create 2020/11/11 21:18
 */
public class SemaphoreThreads {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.acquire(1);
                    Homework03 hw = new Homework03();
                    System.out.println(getName() + "线程计算的结果为：" + hw.sum());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }.start();
    }
}
