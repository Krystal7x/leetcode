package sword;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 133 👎 0


public class S33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0) return true;
            return verifyPostorder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyPostorder(int[] postorder, int start, int end) {
            if (start > end) return true;
            int root = postorder[end];
            int index = start;
            for (int i = start; i <= end; i++) {
                index = i;
                if (postorder[i] > root) break;
            }
            for (int i = index; i < end; i++) {
                if (postorder[i] < root) return false;
            }

            return verifyPostorder(postorder, start, index - 1) && verifyPostorder(postorder, index, end - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();


    }
}