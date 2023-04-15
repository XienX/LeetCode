import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            Integer firstSubscript = map.get(value);
            if (firstSubscript != null) {
                return new int[]{firstSubscript, i};
            }
            // 计算和为目标值所需匹配的整数，存入map
            map.put(target - value, i);
        }
        //  won't run here
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
