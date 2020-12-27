package medium;
/*5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String ans = null;
        int i, j;

        for (i=0;i<len;i++) {
            for (j=1;i-j>=0 && i+j<len && s.charAt(i-j)==s.charAt(i+j);j++) {}

            if (j+j-1 > maxLen) {
                maxLen = j+j-1;
                ans = s.substring(i - j + 1, i + j);
            }
        }

        for (i=0;i<len-1;i++) {
            for (j=0;i-j>=0 && i+j+1<len && s.charAt(i-j)==s.charAt(i+j+1);j++) {}

            if (j+j > maxLen) {
                maxLen = j+j;
                ans = s.substring(i - j + 1, i + j + 1);
            }
        }

        return ans;
    }
}
