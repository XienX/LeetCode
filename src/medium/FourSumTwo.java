package medium;
/*454. 四数相加 II
给定四个包含整数的数组列表A , B , C , D,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的A, B, C, D具有相同的长度N，且 0 ≤ N ≤ 500。所有整数的范围在-2^28到2^28-1之间，最终结果不会超过2^31-1。

例如:
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:
2
解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class FourSumTwo {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int ans = 0;

        for (int a : A)
            for (int b : B) {
                temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

        for (int c : C)
            for (int d : D)
                if (map.containsKey(-c-d))
                    ans += map.get(-c-d);

        return ans;
    }
}
