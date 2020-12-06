package medium;
/*659. 分割数组为连续子序列
给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
如果可以完成上述分割，则返回 true ；否则，返回 false 。

示例 1：
输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3
3, 4, 5

示例 2：
输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3, 4, 5
3, 4, 5

示例 3：
输入: [1,2,3,4,4,5]
输出: False

提示：
输入的数组长度范围为 [1, 10000]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, num = 0, len = nums.length, tem;

        if (len < 3)
            return false;

        while (i < len) {
            num = nums[i++];
            tem = 1;
            while (i < len && num == nums[i]) {
                i++;
                tem++;
            }

            map.put(num, tem);
        }
        int sVal = nums[0], eVal = num, l, lastMapVal;
        boolean flag;
        while (sVal <= eVal) {
            i = sVal;
            l = 0;
            lastMapVal = 0;
            flag = true;

            while (i<=eVal && map.containsKey(i) && map.get(i) > lastMapVal) {
                lastMapVal = map.get(i) - 1;
                map.put(i, lastMapVal);
                if (flag && lastMapVal > 0) {
                    sVal = i;
                    flag = false;
                }
                i++;
                l++;
            }
            if (l < 3)
                return false;
            if (flag)
                break;
        }

        return true;
    }

//    public boolean isPossible(int[] nums) {
//        Map<Integer, Integer> countMap = new HashMap<>();
//        Map<Integer, Integer> endMap = new HashMap<>();
//        for (int x : nums) {
//            int count = countMap.getOrDefault(x, 0) + 1;
//            countMap.put(x, count);
//        }
//        for (int x : nums) {
//            int count = countMap.getOrDefault(x, 0);
//            if (count > 0) {
//                int prevEndCount = endMap.getOrDefault(x - 1, 0);
//                if (prevEndCount > 0) {
//                    countMap.put(x, count - 1);
//                    endMap.put(x - 1, prevEndCount - 1);
//                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
//                } else {
//                    int count1 = countMap.getOrDefault(x + 1, 0);
//                    int count2 = countMap.getOrDefault(x + 2, 0);
//                    if (count1 > 0 && count2 > 0) {
//                        countMap.put(x, count - 1);
//                        countMap.put(x + 1, count1 - 1);
//                        countMap.put(x + 2, count2 - 1);
//                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
