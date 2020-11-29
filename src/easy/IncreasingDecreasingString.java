package easy;
/*1370. 上升下降字符串
给你一个字符串s，请你根据下面的算法重新构造字符串：
从s中选出最小的字符，将它接在结果字符串的后面。
从s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它接在结果字符串后面。
重复步骤2，直到你没法从s中选择字符。
从s中选出 最大的字符，将它接在结果字符串的后面。
从s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它接在结果字符串后面。
重复步骤5，直到你没法从s中选择字符。
重复步骤 1 到 6 ，直到s中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。

请你返回将s中字符重新排序后的结果字符串。

示例 1：
输入：s = "aaaabbbbcccc"
输出："abccbaabccba"
解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"

示例 2：
输入：s = "rat"
输出："art"
解释：单词 "rat" 在上述算法重排序以后变成 "art"

示例 3：
输入：s = "leetcode"
输出："cdelotee"
示例 4：

输入：s = "ggggggg"
输出："ggggggg"
示例 5：

输入：s = "spo"
输出："ops"

提示：
1 <= s.length <= 500
s只包含小写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-decreasing-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class IncreasingDecreasingString {
//    public String sortString(String s) {
//        char[] chars = s.toCharArray();
//        StringBuilder ans = new StringBuilder();
//        boolean flag = true;
//        int i, len = chars.length;
//        char last;
//
//        Arrays.sort(chars);
//
//        while (flag) {
//            flag = false;
//            last = 'A';
//
//            for (i=0;i<len;i++)
//                if (chars[i] != '*' && chars[i] != last) {
//                    ans.append(chars[i]);
//                    last = chars[i];
//                    chars[i] = '*';
//                    flag = true;
//                }
//
//            if (!flag)
//                break;
//            flag = false;
//            last = 'A';
//
//            for (i=len-1;i>=0;i--)
//                if (chars[i] != '*' && chars[i] != last) {
//                    ans.append(chars[i]);
//                    last = chars[i];
//                    chars[i] = '*';
//                    flag = true;
//                }
//        }
//
//        return ans.toString();
//    }

    public String sortString(String s) { // 桶排序
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++)
            num[s.charAt(i) - 'a']++;

        StringBuilder ret = new StringBuilder();

        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++)
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }

            for (int i = 25; i >= 0; i--) 
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }

        }
        return ret.toString();
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/increasing-decreasing-string/solution/shang-sheng-xia-jiang-zi-fu-chuan-by-leetcode-solu/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
