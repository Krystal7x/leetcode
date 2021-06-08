package leetcode.editor.cn;

//在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。 
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。 
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。 
//
// 说明: 
//
// 
// 如果题目有解，该答案即为唯一答案。 
// 输入数组均为非空数组，且长度相同。 
// 输入数组中的元素均为非负数。 
// 
//
// 示例 1: 
//
// 输入: 
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。 
//
// 示例 2: 
//
// 输入: 
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。 
// Related Topics 贪心算法 
// 👍 528 👎 0


//L134、加油站 ---- 
public class L134_GasStation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1、如果我们总的净消耗小于0，那么显然是不可能走完一圈的。
         * 2、出发点的净消耗必须要大于等于0。否则不可能出发。
         * <p>
         * 3、下一个规则需要一个反证法来证明。
         * 即当我们从i点到j点之前，如果总的净消耗小于0。那么从i+1点到j点之前的任意点到j点之前的净消耗均小于0。
         * 反证法：我们假设k点到j点之前的净消耗大于0。因为要保持i点到j点的净消耗小于0。所以i点到k点之前的净消耗小于0。
         * 这很矛盾，因为我们既然能走过k点，就代表i点到k点之前的净消耗是大于等于0的话，否则就走不下去。
         *
         * @param gas
         * @param cost
         * @return
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0;
            int curr = 0;
            int res = 0;
            for (int i = 0; i < gas.length; i++) {
                total += gas[i] - cost[i];
                curr += gas[i] - cost[i];
                // 如果curr<0，则代表新起点要从i+1开始，中间的这些点开始都不行
                if (curr < 0) {
                    res = i + 1;
                    curr = 0;
                }
            }
            if (total < 0)
                return -1;
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L134_GasStation().new Solution();

    }
}