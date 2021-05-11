package easy;
/*剑指 Offer 29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

限制：
0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ShunShiZhenDaYinJuZhenLcof {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int yMin = 0;
        int xMin = 0;
        int yMax = matrix.length - 1;
        int xMax = matrix[0].length - 1;

        int len = matrix.length * matrix[0].length;
        int[] ans = new int[len];

        int i = 0;

        while (i < len) {
            for (int x=xMin;x<=xMax;x++)
                ans[i++] = matrix[yMin][x];
            if (i == len)
                break;

            for (int y=yMin+1;y<=yMax;y++)
                ans[i++] = matrix[y][xMax];
            if (i == len)
                break;

            for (int x=xMax-1;x>=xMin;x--)
                ans[i++] = matrix[yMax][x];

            for (int y=yMax-1;y>yMin;y--)
                ans[i++] = matrix[y][xMin];

            yMin++;
            xMax--;
            xMin++;
            yMax--;
        }

        return ans;
    }
}
