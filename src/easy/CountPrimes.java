package easy;
/*204. 计数质数
统计所有小于非负整数n的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0

提示：
0 <= n <= 5 * 106

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-primes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class CountPrimes {
    public int countPrimes(int n) { // 厄拉多塞筛法
        if (n <= 2)
            return 0;

        boolean[] nums = new boolean[n];
        int ans = 0;
        int i, j;

        for (i=2;i < n;i++)
            if (!nums[i]) {
                ans++;
                if ((long) i * i < n) // 从2x开始是冗余的，应该直接从x*x开始标记，因为2x,3x,,… 这些数在x之前就被其他数的倍数标记过了
                    for (j=i*i;j < n;j+=i)
                        nums[j] = true;
            }

        return ans;
    }
}
