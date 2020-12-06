package easy;
/*
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字1和0。

示例:
输入: a = "1010", b = "1011"
输出: "10101"

提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        char next = '0';
        int lena = a.length();
        int lenb = b.length();
        int len = Math.max(lena, lenb);
        int i;

        if (lena != lenb) {
            StringBuilder temp = new StringBuilder();
            int t = Math.abs(lena - lenb);
            for (i=0;i<t;i++)
                temp.append('0');
            if(lena>lenb)
                b = temp.append(b).toString();
            else
                a = temp.append(a).toString();
        }

        for (i=len-1;i>=0;i--) {
            if (next=='1' && a.charAt(i)=='1' && b.charAt(i)=='1')
                s.append('1');
            else if (next=='0' && a.charAt(i)=='0' && b.charAt(i)=='0')
                s.append('0');
            else if((next=='0' && a.charAt(i)=='1' && b.charAt(i)=='1') ||
                    (next=='1' && a.charAt(i)=='0' && b.charAt(i)=='1') ||
                    (next=='1' && a.charAt(i)=='1' && b.charAt(i)=='0')) {
                next = '1';
                s.append('0');
            }
            else {
                next = '0';
                s.append('1');
            }
        }

        if(next == '1')
            s.append('1');

        return s.reverse().toString();
    }

    /*
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
