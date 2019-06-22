package one;

/**
 * @auther k
 * @date 2019-06-22 13:54
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

public class S38CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        //从2开始计算每一个数字
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            //根据前一个字符串，自算下一个
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        S38CountAndSay s = new S38CountAndSay();
        System.out.println(s.countAndSay(5));
        System.out.println(s.countAndSay(6));
    }
}
