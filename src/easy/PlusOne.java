package easy;
/*66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class PlusOne {
    int[] digits;
    public int[] plusOne(int[] digits) {
        this.digits = digits;
        one(digits.length-1);
        return this.digits;
    }

    public void one (int i) {
        if (i < 0) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        else if(digits[i] != 9) {
            digits[i]++;
        }
        else {
            digits[i] = 0;
            one(i-1);
        }
    }
}
