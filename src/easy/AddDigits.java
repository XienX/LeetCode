package easy;
/*258. 各位相加
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:
输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

进阶:
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class AddDigits {
    public int addDigits(int num) {
        int ans = 0;

        while (true) {
            while (num != 0) {
                ans += num % 10;
                num = num / 10;
            }

            if(ans < 10)
                break;
            else{
                num = ans;
                ans = 0;
            }

        }

        return ans;
    }


//    public int addDigits(int num) {
//        return (num - 1) % 9 + 1;
//    }
//    作者：liveforexperience
//    链接：https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
