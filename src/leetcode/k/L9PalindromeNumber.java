package leetcode.k;

/**
 * @auther k
 * @date 2019/6/5 下午1:41
 */

/**
 * 判断一个整数是否是回文数
 */
public class L9PalindromeNumber {
    //使用字符串
    public boolean isPalindrome(int x) {
        char[] sx=String.valueOf(x).toCharArray();
        if(sx.length==0 ||sx[0]=='-'){ return false; }
        for(int i=0;i<sx.length/2;i++){
            if(sx[i]!=sx[sx.length-1 -i]){return false; }
        }
        return true;
    }
    //不使用字符串
    public boolean isPalindrome2(int x) {
        int recover = 0;
        if(x < 0|| (x % 10 == 0 && x != 0)){return  false;}
        if(x>recover){
            recover=recover*10+x%10;
            x=x/10;
        }

        return x==recover||recover/10==x;
    }
}
