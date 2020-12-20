package easy;
/*172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

说明: 你算法的时间复杂度应为 O(log n)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class FactorialTrailingZeroes {
//    public int trailingZeroes(int n) {
//        int two = 0, five = 0, tem;
//
//        for (;n>1;n--) {
//            tem = n;
//
//            while (tem%2 == 0) {
//                two++;
//                tem = tem >> 1;
//            }
//            while (tem%5 == 0) {
//                five++;
//                tem /= 5;
//            }
//        }
//
//        return Math.min(two, five);
//    }

    public int trailingZeroes(int n) { // 乘法因子里有多少个5
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
