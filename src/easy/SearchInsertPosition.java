package easy;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1
*/

public class SearchInsertPosition {
    /*public int searchInsert(int[] nums, int target) {
        int s = 0, m = 0;
        int e = nums.length-1;

        while (e > s) {
            m = (e+s)/2;
            if (target == nums[m])
                return m;
            else if (target < nums[m])
                e = m - 1;
            else
                s = m + 1;
        }

        e = Math.max(e, 0);
        return target>nums[e]?e+1:e;
    }*/

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
