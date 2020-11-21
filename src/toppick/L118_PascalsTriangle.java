package toppick;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 375 👎 0


import java.util.LinkedList;
import java.util.List;

//L118、杨辉三角 ----
public class L118_PascalsTriangle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {

            LinkedList<List<Integer>> ans = new LinkedList<>();
            if (numRows == 0) return ans;
            LinkedList<Integer> first = new LinkedList<>();
            first.add(1);
            ans.add(first);
            if (numRows == 1) return ans;
            int index = 2;
            while (index <= numRows) {
                List<Integer> last = ans.peekLast();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = 0; i < index; i++) {
                    if (i - 1 >= 0 && i < last.size()) {
                        list.add(last.get(i - 1) + last.get(i));
                    } else {
                        list.add(1);
                    }
                }
                ans.add(list);
                index++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L118_PascalsTriangle().new Solution();

    }
}