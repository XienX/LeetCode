package medium;
/*48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。

说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = n-1;
        int iMax = n/2, jMax;
        int i, j, tem;

        for (i=0;i<iMax;i++)
            for (j=i, jMax = m-i;j<jMax;j++) {
                tem = matrix[i][j];
                matrix[i][j] = matrix[m-j][i];
                matrix[m-j][i] = matrix[m-i][m-j];
                matrix[m-i][m-j] = matrix[j][m-i];
                matrix[j][m-i] = tem;
            }

    }
}