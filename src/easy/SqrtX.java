package easy;
/*69. x 的平方根
实现int sqrt(int x)函数。
计算并返回x的平方根，其中x是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SqrtX {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}