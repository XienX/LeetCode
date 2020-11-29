package hard;
/*493. 翻转对
给定一个数组nums，如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。

示例 1:
输入: [1,3,2,3,1]
输出: 2

示例 2:
输入: [2,4,3,5,1]
输出: 3

注意:
给定数组的长度不会超过50000。
输入数组中的所有数字都在32位整数的表示范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ReversePairs {
    public int reversePairs(int[] nums) { //归并，solve(A)=solve(A1)+solve(A2)+cross_middle(A1,A2)
        if (nums.length == 0)
            return 0;

        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right)
            return 0;

        int mid = (left + right) / 2;

        int ret = reversePairsRecursive(nums, left, mid) + reversePairsRecursive(nums, mid + 1, right);

        // 首先统计下标对的数量
        int i = left;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j])
                j++;

            ret += j - mid - 1;
            i++;
        }

        // 随后合并两个排序数组
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid)
                sorted[p++] = nums[p2++];
            else if (p2 > right)
                sorted[p++] = nums[p1++];
            else
                if (nums[p1] < nums[p2])
                    sorted[p++] = nums[p1++];
                else
                    sorted[p++] = nums[p2++];
        }

        if (sorted.length >= 0)
            System.arraycopy(sorted, 0, nums, left, sorted.length);

        return ret;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
