package medium;
/*861. 翻转矩阵后的得分
有一个二维矩阵A 其中每个元素的值为0或1。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。

示例：
输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

提示：
1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j]是0 或1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ScoreAfterFlippingMatrix {
//    public int matrixScore(int[][] A) {
//        int ans = 0;
//        int x = A.length, y = A[0].length;
//
//        for (int[] a : A)
//            if (a[0] == 0)
//                for (int j=0;j<y;j++)
//                    a[j] = a[j] == 1 ? 0 : 1;
//
//        for (int i=0;i<y;i++) {
//            int zeroCount = 0;
//
//            for (int[] a : A)
//                if (a[i] == 0)
//                    zeroCount++;
//
//            if (zeroCount > x/2)
//                for (int j=0;j<x;j++)
//                    A[j][i] = A[j][i] == 1 ? 0 : 1;
//        }
//
//        for (int[] a : A)
//            for (int j=0;j<y;j++)
//                ans += a[j] * Math.pow(2, y-j-1);
//
//        return ans;
//    }

    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int[] ints : A) {
                if (ints[0] == 1) {
                    nOnes += ints[j];
                } else {
                    nOnes += (1 - ints[j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
