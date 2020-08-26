package leetcode.数据结构.数组;

/**
 * 描述:大数相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * @author luokui
 * @create 2020-07-15 11:42
 */
public class L43_Solution {
    public static String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int index = i + j;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + ans[index + 1];
                ans[index + 1] = sum % 10;
                ans[index] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) break;
            index++;
        }
        if (index == ans.length - 1) {
            return "0";
        }
        for (int i = index; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("23214", "0"));
    }
}
