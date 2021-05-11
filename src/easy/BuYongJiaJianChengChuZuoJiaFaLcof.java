package easy;
/*剑指 Offer 65. 不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

示例:
输入: a = 1, b = 1
输出: 2

提示：
a, b 均可能是负数或 0
结果不会溢出 32 位整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public int add(int a, int b) {
        int ans = 0;
        int q = 1;
        int flag = 0;
        int aBit;
        int bBit;

        while (!(a == 0 && b == 0)) {
            aBit = a & 1;
            bBit = b & 1;

            if (aBit == 1 && bBit == 1) {
                if (flag == 1)
                    ans |= q;
                else
                    flag = 1;
            }
            else if (aBit == 1 || bBit == 1) {
                if (flag == 0)
                    ans |= q;
            }
            else {
                if (flag == 1) {
                    ans |= q;
                    flag = 0;
                }
            }

            q <<= 1;
            a >>>= 1;
            b >>>= 1;
        }

        if (flag == 1)
            ans |= q;

        return ans;
    }

    /*public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    作者：jyd
    链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
