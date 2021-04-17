package other.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 11:29 AM
 */
public class T_ReadWriteLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void read() {
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("读数据，进入 | 线程：" + Thread.currentThread().getName());
            Thread.sleep(30);
            System.out.println("“读数据，退出 | 线程：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void write() {
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("写数据，进入 | 线程：" + Thread.currentThread().getName());
            Thread.sleep(30);
            System.out.println("写数据，退出 | 线程：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }


    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        T_ReadWriteLock myReadWriteLock = new T_ReadWriteLock();
        for (int i = 0; i < 2; i++) {
            fixedThreadPool.execute(() -> {
                myReadWriteLock.read();
            });
        }
        for (int i = 0; i < 2; i++) {
            fixedThreadPool.execute(() -> {
                myReadWriteLock.write();
            });
        }

//        Future<Integer> future = fixedThreadPool.submit(() -> {
//            return 1;
//        });
//        try {
//            Integer ans = future.get();
//        } catch (Exception e) {
//
//        }

        fixedThreadPool.shutdown();
    }
}
