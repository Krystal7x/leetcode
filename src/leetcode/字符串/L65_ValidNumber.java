package leetcode.字符串;

//验证给定的字符串是否可以解释为十进制数字。 
//
// 例如: 
//
// "0" => true 
//" 0.1 " => true 
//"abc" => false 
//"1 a" => false 
//"2e10" => true 
//" -90e3 " => true 
//" 1e" => false 
//"e3" => false 
//" 6e-1" => true 
//" 99e2.5 " => false 
//"53.5e93" => true 
//" --6 " => false 
//"-+3" => false 
//"95a54e53" => false 
//
// 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表： 
//
// 
// 数字 0-9 
// 指数 - "e" 
// 正/负号 - "+"/"-" 
// 小数点 - "." 
// 
//
// 当然，在输入中，这些字符的上下文也很重要。 
//
// 更新于 2015-02-10: 
//C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。 
// Related Topics 数学 字符串 
// 👍 157 👎 0


public class L65_ValidNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            s = s.trim();
            char[] chars = s.toCharArray();
            int index = 0;
            //num、e、dot表示当前字符之前是否出现相应  数字、' e  '、‘ . ’的情况
            boolean e = false;
            boolean dot = false;
            boolean num = false;
            if (chars[index] == '+' || chars[index] == '-') {
                index++;
            }
            for (; index < chars.length; index++) {
                //'e','.'+-','12' 出现的时，分类讨论
                if (chars[index] == 'e') {
                    if (num && !e) {
                        e = true;
                        num = false;
                    } else {
                        return false;
                    }
                } else if (chars[index] == '.') {
                    if (!e && !dot) {
                        dot = true;
                    } else {
                        return false;
                    }
                } else if (chars[index] == '+' || chars[index] == '-') {
                    if (chars[index - 1] == 'e') {
                        num = false;
                    } else {
                        return false;
                    }
                } else if (chars[index] >= '0' && chars[index] <= '9') {
                    num = true;
                } else {
                    return false;
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L65_ValidNumber().new Solution();
        System.out.println(solution.isNumber("95a54e53"));

    }
}