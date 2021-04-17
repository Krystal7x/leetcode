package other.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 11:48 AM
 */
public class T_CyclicBarrier {


    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("<<<召唤神龙>>>");
        });
        for (int i = 1; i <= 7; i++) {
            final int index = i;
            new Thread(() -> {
                System.out.println("找到第" + index + "颗龙珠");
                try {
                    barrier.await();
                    System.out.println("归还第" + index + "颗龙珠");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }

}
