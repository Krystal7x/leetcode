package other.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 11:35 AM
 */
public class T_Cas {


    public static void main(String[] args) {

        AtomicStampedReference<String> asr = new AtomicStampedReference<>("JAVA", 1);
        System.out.println("值：" + asr.getReference() + "| Stamp:" + asr.getStamp());

        //下面需要写成线程操作
        String originName = asr.getReference();
        int originStamp = asr.getStamp();

        boolean result2 = asr.compareAndSet(originName, "2", originStamp, asr.getStamp() + 1);
        System.out.println("值：" + asr.getReference() + "|Stamp:" + asr.getStamp() + "   result:" + result2);

        boolean result3 = asr.compareAndSet(originName, "3", originStamp, asr.getStamp() + 1);
        System.out.println("值：" + asr.getReference() + "|Stamp:" + asr.getStamp() + "   result:" + result3);


    }
}
