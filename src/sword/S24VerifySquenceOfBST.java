package sword;

/**
 * @auther k
 * @date 2019-07-06 17:40
 * <p>
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 解题思路
 * 二叉搜索树: 左子树<根<=右子树
 * <p>
 * 对于后序遍历来说，序列数组的最后一个元素一定是根节点, 根据这个元素，将前面的数组分为左、右两个部分，
 * 左侧部分都比该元素小，右侧部分都比该元素大，如果右侧部分有比该根节点小的元素，那么就不是后序遍历，如此递归进行。
 */

public class S24VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence) {
            return false;
        }
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int n = sequence[end];
        int index = start;
        for (; index <= end; index++) {
            if (sequence[index] > n) {
                break;
            }
        }
        for (int i = index; i <= end; i++) {
            if (sequence[i] < n) {
                return false;
            }
        }
        boolean left = VerifySquenceOfBST(sequence, start, index - 1);
        boolean right = VerifySquenceOfBST(sequence, index, end);
        return left && right;

    }

}
