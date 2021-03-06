package medium;
/*剑指 Offer 20. 表示数值的字符串
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class StringIsInteger {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim(); //去掉首位空格
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') { //判定为数字，则标记numFlag
                numFlag = true;
            }
            else if (s.charAt(i) == '.' && !dotFlag && !eFlag) { //判定为.  :需要没出现过.并且没出现过e
                dotFlag = true;
            }
            else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) { //判定为e，需要没出现过e，并且出过数字了
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
            }
            else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //判定为+-符号，只能出现在第一位或者紧接e后面
            }
            else {//其他情况，都是非法的
                return false;
            }
        }
        return numFlag;
    }
}
