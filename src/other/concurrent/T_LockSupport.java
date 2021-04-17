package other.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 2:15 PM
 */
public class T_LockSupport {
    volatile List lists = new ArrayList<>();


    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        T_LockSupport c = new T_LockSupport();


        t1 = new Thread(() -> {

            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
                if (c.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t2 结束");
        }, "t2");


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 结束");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();
        t1.start();
    }
}
