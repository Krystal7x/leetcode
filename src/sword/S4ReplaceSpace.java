package sword;

/**
 * @auther k
 * @date 2019-06-29 15:08
 *
 *题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解题思路
 * 很简单，从后往前遍历就对了。
 */

public class S4ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }
}
