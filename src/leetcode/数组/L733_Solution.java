package leetcode.数组;

/**
 * 描述:733.图像渲染
 *
 * @author luokui
 * @create 2020-07-28 18:14
 */
public class L733_Solution {
    //L733_Solution
    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        boolean[][] imageVisit = new boolean[image.length][image[0].length];
        floodFill(image, imageVisit, sr, sc, originColor, newColor);
        return image;

    }

    void floodFill(int[][] image, boolean[][] imageVisit, int sr, int sc, int originColor, int newColor) {
        if (!inAres(image, sr, sc)) return;
        if (imageVisit[sr][sc]) return;
        if (image[sr][sc] != originColor) return;
        image[sr][sc] = newColor;
        imageVisit[sr][sc] = true;
        floodFill(image, imageVisit, sr - 1, sc, originColor, newColor);
        floodFill(image, imageVisit, sr + 1, sc, originColor, newColor);
        floodFill(image, imageVisit, sr, sc - 1, originColor, newColor);
        floodFill(image, imageVisit, sr, sc + 1, originColor, newColor);
    }

    boolean inAres(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

}
