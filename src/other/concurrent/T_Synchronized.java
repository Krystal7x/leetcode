package other.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 实现一个容器，提供两个方法，add，size * 写两个线程，
 * 线程1添加10个元素到容器中，线程2实现监控元素的个数，
 * 当个数到5个时，线程2给出提示并结束
 *
 * @author luokui
 * @create 2021-04-16 10:08 AM
 */
public class T_Synchronized {

    static class Synchronized1 {

        volatile List<Integer> lists = new ArrayList<>();

        public void add(Integer i) {
            lists.add(i);
        }

        public int size() {
            return lists.size();
        }

        public static void main(String[] args) {
            Synchronized1 c = new Synchronized1();
            final Object lock = new Object();
            new Thread(() -> {

                synchronized (lock) {
                    System.out.println("t2启动");
                    if (c.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2结束");
                    //通知t1继续执行
                    lock.notify();
                }
            }, "t2").start();

            //停一段时间

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(() -> {
                System.out.println("t1启动");
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        c.add(i);
                        System.out.println("add " + i);
                        if (c.size() == 5) {
                            //释放锁，让t2得以执行
                            lock.notify();
                            try {
                                //等待t2执行
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, "t1").start();
        }
    }

    /**
     * 多线程交替打印数字
     */
    static class Synchronized2 {
        private static final int MAX_PRINT_NUM = 100;
        private static volatile int count = 0;

        public static void main(String[] args) {
            final Object lock = new Object();
            new Thread(() -> {
                while (count <= MAX_PRINT_NUM) {
                    synchronized (lock) {
                        if (count % 2 == 0) {
                            System.out.println("Thread-1 " + count);
                            count++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (Exception e) {

                            }

                        }
                    }

                }
            }, "Thread-1").start();


            new Thread(() -> {
                while (count <= MAX_PRINT_NUM) {
                    synchronized (lock) {
                        if (count % 2 != 0) {
                            System.out.println("Thread-2 " + count);
                            count++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (Exception e) {

                            }

                        }
                    }

                }
            }, "Thread-2").start();

        }

    }

}
