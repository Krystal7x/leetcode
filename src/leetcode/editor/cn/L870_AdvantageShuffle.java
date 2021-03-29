package leetcode.editor.cn;

//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心算法 数组 
// 👍 112 👎 0


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

//L870、优势洗牌 ----
public class L870_AdvantageShuffle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {
            int value;
            int index;

            public Node(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        public int[] advantageCount(int[] A, int[] B) {
            Arrays.sort(A);
            LinkedList<Node> listB = new LinkedList<>();

            for (int i = 0; i < B.length; i++) {
                listB.add(new Node(B[i], i));
            }
            Collections.sort(listB, new Comparator<Node>() {
                public int compare(Node n1, Node n2) {
                    return n1.value - n2.value;
                }
            });

            // 遍历A即可，将B数组作为输出容器，因为B的信息已经都存在LinkedList里了，这里B数组已经没用了
            for (int i = 0; i < A.length; i++) {
                if (A[i] > listB.getFirst().value) {
                    B[listB.removeFirst().index] = A[i]; // 对应思想中的（1）
                } else {
                    B[listB.removeLast().index] = A[i]; // // 对应思想中的（2）
                }
            }
            return B;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L870_AdvantageShuffle().new Solution();

    }
}