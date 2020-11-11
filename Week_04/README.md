学习笔记

1.思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
<br>(1)使用线程池的shutdown
```
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
```
(2)使用CountDownLatch
   ```
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
```
(3)使用join()
```
            Thread th = new Thread() {
                @Override
                public void run() {
                    Homework03 hw = new Homework03();
                    System.out.println(getName() + "线程计算的结果为：" + hw.sum());
                }
            };
            th.run();
            th.join();
        }
```
(4)使用信号量Semaphore
```
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
```
