package easy;
/*125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:
输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ValidPalindrome {
//    public boolean isPalindrome(String s) {
//        s = s.toUpperCase();
//        int i = 0, j = s.length()-1;
//        while (i < j) {
//            if (s.charAt(i) < '0' || (s.charAt(i) > '9' && s.charAt(i) < 'A') || s.charAt(i) > 'Z')
//                i++;
//            else if (s.charAt(j) < '0' || (s.charAt(j) > '9' && s.charAt(j) < 'A') || s.charAt(j) > 'Z')
//                j--;
//            else if (s.charAt(i++) != s.charAt(j--))
//                return false;
//        }
//        return true;
//    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/valid-palindrome/solution/yan-zheng-hui-wen-chuan-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
