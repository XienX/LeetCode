package medium;
/*137. 只出现一次的数字 II
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3

示例2:
输入: [0,1,0,1,0,1,99]
输出: 99

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;

public class SingleNumberTwo {
//    public int singleNumber(int[] nums) {
//        int[] flags = new int[33];
//        long ans = 0;
//
//        for (long num : nums) {
//            int n = 0;
//            if (num < 0) {
//                if (flags[32] == 2)
//                    flags[32] = 0;
//                else
//                    flags[32]++;
//                num = -num;
//            }
//
//            while (num > 0) {
//                if (num % 2 == 1)
//                    if (flags[n] == 2)
//                        flags[n] = 0;
//                    else
//                        flags[n]++;
//
//                n++;
//                num = num / 2;
//            }
//        }
//
//        for (int i=0;i<32;i++)
//            ans += flags[i]*Math.pow(2, i);
//
//        return flags[32] == 0 ? (int) ans : (int) -ans;
//    }

//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> hashmap = new HashMap<>();
//        for (int num : nums)
//            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
//
//        for (int k : hashmap.keySet())
//            if (hashmap.get(k) == 1) return k;
//        return -1;
//    }

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

   /*作者：LeetCode
    链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
