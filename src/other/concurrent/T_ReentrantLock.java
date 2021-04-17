package other.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 10:49 AM
 */
public class T_ReentrantLock {

    /**
     * 实现一个容器，提供两个方法，add，size * 写两个线程，
     * 线程1添加10个元素到容器中，线程2实现监控元素的个数，
     * 当个数到5个时，线程2给出提示并结束
     */
    static class T_ReentrantLock1 {

        private volatile static List<Integer> list = new LinkedList<>();

        public void add(int num) {
            list.add(num);
        }

        public int size() {
            return list.size();
        }

        public static void main(String[] args) {
            ReentrantLock lock = new ReentrantLock();
            Condition condition = lock.newCondition();
            T_ReentrantLock1 list = new T_ReentrantLock1();
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("thread2  start");
                    if (list.size() != 5) {
                        condition.await();
                    }
                    System.out.println("thread2  end");
                    condition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "thread2").start();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println("thread1  start");
                    for (int i = 0; i < 10; i++) {
                        list.add(i);
                        System.out.println("add " + i);

                        if (list.size() == 5) {
                            condition.signal();
                            condition.await();

                        }
                    }
                    System.out.println("thread1  end");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "thread1").start();

        }
    }


    /**
     * 三个线程交替打印ABC
     */
    static class T_ReentrantLock2 {
        private static Lock lock = new ReentrantLock();
        private static Condition cA = lock.newCondition();
        private static Condition cB = lock.newCondition();
        private static Condition cC = lock.newCondition();
        private static volatile AtomicInteger number = new AtomicInteger(1);

        private static volatile int max = 100;

        public static void main(String[] args) {
            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (number.get() > max) break;
                        while (number.get() % 3 != 1) {
                            cA.await();
                        }
                        System.out.println("A");
                        number.incrementAndGet();
                        cB.signalAll();
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (number.get() > max) break;
                        while (number.get() % 3 != 2) {
                            cB.await();
                        }
                        System.out.println("B");
                        number.incrementAndGet();
                        cC.signalAll();
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (number.get() > max) break;
                        while (number.get() % 3 != 0) {
                            cC.await();
                        }
                        System.out.println("C");
                        number.incrementAndGet();
                        cA.signalAll();
                    } catch (Exception e) {
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }


}
