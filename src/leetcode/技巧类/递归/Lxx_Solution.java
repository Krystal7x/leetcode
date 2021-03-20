package leetcode.技巧类.递归;

/**
 * 描述:
 * 细胞分裂，第三个小时会死
 *
 * @author luokui
 * @create 2020-08-27 17:14
 */
public class Lxx_Solution {

    public int allCells(int n) {
        return aCell(n) + bCell(n) + cCell(n);
    }

    /**
     * 第 n 小时 a 状态的细胞数
     */
    public int aCell(int n) {
        if (n == 1) {
            return 1;
        } else {
            //一小时前，abc三种细胞的数量
            return aCell(n - 1) + bCell(n - 1) + cCell(n - 1);
        }
    }

    /**
     * 第 n 小时 b 状态的细胞数
     */
    public int bCell(int n) {
        if (n == 1) {
            return 0;
        } else {
            //一小时前，a细胞的数量
            return aCell(n - 1);
        }
    }

    /**
     * 第 n 小时 c 状态的细胞数
     */
    public int cCell(int n) {
        if (n == 1 || n == 2) {
            return 0;
        } else {
            //一小时前，b细胞的数量
            return bCell(n - 1);
        }
    }
}
