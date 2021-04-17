package other.file;

import java.io.*;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 9:07 PM
 */
public class IO {
    public static void writeFile(byte s[], String file) throws Exception {    // 异常抛出，不处理
        // 第1步、使用File类找到一个文件
        File f = new File("/Users/luokui/code/" + file);    // 声明File对象
        // 第2步、通过子类实例化父类对象，注意下面是通过向上转型，实例化父类对象。
        OutputStream out = null;    // 准备好一个输出的对象
        out = new FileOutputStream(f);    // 通过对象多态性，进行实例化
        // 第3步、进行写操作
        //String str = "Hello World!!!" ;        // 准备一个字符串
        //byte b[] = str.getBytes() ;            // 只能输出byte数组，所以将字符串变为byte数组
        out.write(s);                        // 将内容输出，保存文件
        // 第4步、关闭输出流
        out.close();                        // 关闭输出流
    }


    public static byte[] readFile(String file) throws Exception {    // 异常抛出，不处理
        // 第1步、使用File类找到一个文件
        File f = new File("/Users/luokui/code/" + file);    // 声明File对象
        // 第2步、通过子类实例化父类对象
        InputStream input = null;     // 准备好一个输入的对象
        input = new FileInputStream(f);    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        byte b[] = new byte[(int) f.length()];        // 数组大小由文件决定
        int len = input.read(b);        // 读取内容
        // 第4步、关闭输出流
        input.close();                        // 关闭输出流
        System.out.println("内容为：" + new String(b));    // 把byte数组变为字符串输出
        return b;
    }


}
