package hard;
/*85. 最大矩形
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：6

示例 2：
输入：matrix = []
输出：0

示例 3：
输入：matrix = [["0"]]
输出：0

示例 4：
输入：matrix = [["1"]]
输出：1

示例 5：
输入：matrix = [["0","0"]]
输出：0

提示：
rows == matrix.length
cols == matrix[0].length
0 <= row, cols <= 200
matrix[i][j] 为 '0' 或 '1'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] depths = new int[row][col];
        int ans = 0;

        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                if (matrix[i][j] == '1')
                    if (i>0 && depths[i-1][j]!=0)
                        depths[i][j] = depths[i-1][j] - 1;
                    else {
                        int depth = 1;
                        while (i + depth < row && matrix[i+depth][j] == '1')
                            depth++;
                        depths[i][j] = depth;
                    }

        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                if (depths[i][j] > 0) {
                    int max = depths[i][j];
                    int depthMin = depths[i][j];
                    int right = 1;

                    while (j+right<col && depths[i][j+right]>0) {
                        depthMin = Math.min(depthMin, depths[i][j+right]);
                        max = Math.max(max, depthMin*(++right));
                    }

                    ans = Math.max(ans, max);
                }

        return ans;
    }
}
