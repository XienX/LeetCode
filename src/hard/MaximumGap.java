package hard;
/*164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
如果数组元素个数小于 2，则返回 0。

示例1:
输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。

示例2:
输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。

说明:
你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-gap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class MaximumGap {
//    public int maximumGap(int[] nums) { // 基数排序
//        int n = nums.length;
//
//        if (n <= 1)
//            return 0;
//
//        long exp = 1;
//        int i, digit;
//        int[] buf = new int[n];
//        int maxVal = Arrays.stream(nums).max().getAsInt();
//
//        while (maxVal >= exp) {
//            int[] cnt = new int[10];
//            for (i = 0; i < n; i++) {
//                digit = (nums[i] / (int) exp) % 10;
//                cnt[digit]++;
//            }
//
//            for (i = 1; i < 10; i++)
//                cnt[i] += cnt[i - 1];
//
//            for (i = n - 1; i >= 0; i--) {
//                digit = (nums[i] / (int) exp) % 10;
//                buf[cnt[digit] - 1] = nums[i];
//                cnt[digit]--;
//            }
//
//            System.arraycopy(buf, 0, nums, 0, n);
//            exp *= 10;
//        }
//
//        int ans = 0;
//        for (i = 1; i < n; i++)
//            ans = Math.max(ans, nums[i] - nums[i - 1]);
//
//        return ans;
//    }

    public int maximumGap(int[] nums) { // 桶排序
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }
        for (int num : nums) {
            int idx = (num - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = num;
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], num);
                bucket[idx][1] = Math.max(bucket[idx][1], num);
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/maximum-gap/solution/zui-da-jian-ju-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
