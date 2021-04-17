package other.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 实现一个容器，提供两个方法，add，size * 写两个线程，
 * 线程1添加10个元素到容器中，线程2实现监控元素的个数，
 * 当个数到5个时，线程2给出提示并结束
 * <p>
 * 使用CountDownLatch实现
 *
 * @author luokui
 * @create 2021-04-16 10:14 AM
 */
public class T_CountDownLatch {

    volatile List<Integer> lists = new ArrayList<>();


    public void add(Integer o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T_CountDownLatch c = new T_CountDownLatch();

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {

            System.out.println("t2启动");
            if (c.size() != 5) {
                try {
                    latch1.await();
                    latch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {

            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                c.add(i);
                System.out.println("add " + i);
                if (c.size() == 5) {
                    latch1.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }


        }, "t1").start();

    }

}
