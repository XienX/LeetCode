package medium;
/*15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i=0;i<len-2;i++) {
            if (nums[i] > 0)
                return ans;

            if (i>0 && nums[i] == nums[i-1])
                continue;

            int target = -nums[i];

            int j = i + 1, k = len - 1;

            while (j < k) {
                if (nums[j] + nums[k] == target){
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j-1])
                        j++;
                    while (j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if (nums[j] + nums[k] < target)
                    j++;
                else
                    k--;
            }
        }

        return ans;
    }
}
