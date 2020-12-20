package medium;
/*738. 单调递增的数字
给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）

示例 1:
输入: N = 10
输出: 9

示例 2:
输入: N = 1234
输出: 1234

示例 3:
输入: N = 332
输出: 299

说明: N是在[0, 10^9]范围内的一个整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotone-increasing-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int len = String.valueOf(N).length();
        int[] nums = new int[len];
        int ans = 0, i, j;

        for (i=0;i<len;i++) {
            nums[i] = N%10;
            N /= 10;
        }

        for (i=1;i<len;i++)
            if (nums[i] > nums[i-1]) {
                for (j=i-1;j>=0;j--)
                    if (nums[j] != 9)
                        nums[j] = 9;
                    else
                        break;

                nums[i]--;
            }

        for (i=len-1;i>0;i--) {
            ans += nums[i];
            ans *= 10;
        }
        ans += nums[0];

        return ans;
    }
}
