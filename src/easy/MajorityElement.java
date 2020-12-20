package easy;
/*169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊n/2⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:
输入: [3,2,3]
输出: 3

示例2:
输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int c = nums.length/2, tem;
//
//        for (int num : nums) {
//            tem = map.getOrDefault(num, 0) + 1;
//            if (tem > c)
//                return num;
//            map.put(num, tem);
//        }
//        return -1;
//    }


    // Boyer-Moore 投票算法，从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
