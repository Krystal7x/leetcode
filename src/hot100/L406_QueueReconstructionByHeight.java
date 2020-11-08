package hot100;

//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 530 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//L406、根据身高重建队列 ----
public class L406_QueueReconstructionByHeight {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //身高先降序，k再升序
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            List<int[]> output = new LinkedList<>();
            //因为矮的人不会影响高的人的k变化，所以按p[i]作为位置直接在对应位置插入，前面的人一定比他高
            for (int[] p : people) {
                output.add(p[1], p);
            }
            int n = people.length;
            return output.toArray(new int[n][2]);

        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L406_QueueReconstructionByHeight().new Solution();

    }
}