package leetcode;

/**
 * @auther k
 * @date 2019/6/5 下午2:10
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class L7ReverseInteger {
    public int reverse(int x) {
        boolean sign=false;
        int result=0;
        if (x < 0){sign=true;x=-x;}
        while(x>0){
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && x%10 > 7)) {return 0;}
            result=result*10+x%10;
            x=x/10;
        }
        if(sign){return -result;}
        return result;
    }
}
