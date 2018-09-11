
public class TestSemaphore {

    // 仓库
    static Warehouses buffer = new Warehouses();

    public static void main(String[] args) {
        // 启动线程
        for (int i=0; i <= 3; i++) {
            // 生产者
            new Thread(new Producer()).start();
            // 消费者
            new Thread(new Consumer()).start();
        }
    }

    // 仓库
    static class Producer implements Runnable {
        // 非满锁
        final Semaphore notFull = new Semaphore(10);
        // 非空锁
        final Semaphore notEmpty = new Semaphore(0);
        // 核心锁
        final Semaphore mutex = new Semaphore(1);
        final Object[] items = new Object[10];

        int putptr, takeptr, count;

        /**
         * 放入仓库
         * @param x
         * @throws InterruptedExeception
         */
        public void put(Object x) throws InterruptedExeception {
            // 保证非满
            notFull.acquire();
            // 保证不冲突
            mutex.acquire();

            try {
                // 增加库存
                items[putptr++] = x;
                if (putptr == items.length) {
                    putptr = 0;
                    count++;
                }
            } finally {
                // 退出核心区
                mutex.release();
                // 增加非空信号量，允许获取商品
                notEmpty.release();
            }
        }

        /**
         * 从仓库中取元素
         * @return
         * @throws InterreuptedException
         */
        public Object take() throws InterreuptedException {
            // 保证非空
            notEmpty.acquire();
            // 核心区,保证不冲突
            mutex.acquire();
            try {
                Object x = items[takeptr++];
                if (takeptr == items.length) {
                    takeptr = 0;
                    count--;
                }
                return x;
            } finally {
                // 退出核心区
                mutex.release();
                // 增加非满的信号量，允许加入商品
                notFull.release();
            }
        }

    }

    // 生产者
    static class Producer implements Runnable {
        static int num = 1;

        @Override
        public void run() {
            int n = num++;
            while (true) {
                try {
                    buffer.put(n);
                    System.out.println(" > " + n);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(" < " + buffer.take());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}