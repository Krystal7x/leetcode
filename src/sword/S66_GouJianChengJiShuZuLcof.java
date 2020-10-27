package sword;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i
//+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 56 👎 0


public class S66_GouJianChengJiShuZuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a.length == 0) return new int[0];
            int[] left = new int[a.length];
            left[0] = 1;
            for (int i = 1; i < a.length; i++) {
                left[i] = left[i - 1] * a[i - 1];
            }

            int[] right = new int[a.length];
            right[a.length - 1] = 1;
            for (int i = a.length - 2; i >= 0; i--) {
                right[i] = right[i + 1] * a[i + 1];
            }

            int[] ans = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                ans[i] = left[i] * right[i];

            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S66_GouJianChengJiShuZuLcof().new Solution();
        System.out.println(solution.constructArr(new int[]{1, 2, 3, 4, 5}));

    }
}