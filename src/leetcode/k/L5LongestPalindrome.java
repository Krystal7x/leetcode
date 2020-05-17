package leetcode.k;

/**
 * @auther k
 * @date 2019-06-23 15:41
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */

public class L5LongestPalindrome {
    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() <= 1){ return s;}
        char[] arr = s.toCharArray();
        String result = "";
        for (int i = 0; i < arr.length; i++){
            for (int j = arr.length - 1; j >= i; j--){
                if(j - i >= result.length() && arr[i] == arr[j]){
                    if(judge(arr, i, j)){
                        String tmp = createString(arr, i ,j);
                        if(tmp.length() > result.length()){
                            result = tmp;
                        }
                    }

                }
            }
        }
        return result;

    }

    public boolean judge(char[] arr, int begin, int end) {
        for(int i = begin+1, j = end - 1; i <= j; i++, j--){
            if(arr[i] != arr[j]){
                return false;
            }
        }
        return true;
    }

    public String createString(char[] arr, int begin, int end){
        StringBuffer s = new StringBuffer();
        for(int i = begin; i <= end; i++){
            s.append(arr[i]);
        }
        return s.toString();
    }

}
