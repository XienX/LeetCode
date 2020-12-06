package medium;
/*767. 重构字符串
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
若可行，输出任意可行的结果。若不可行，返回空字符串。

示例1:
输入: S = "aab"
输出: "aba"

示例 2:
输入: S = "aaab"
输出: ""

注意:
S 只包含小写字母并且长度在[1, 500]区间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorganize-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String S) {
        StringBuilder ans = new StringBuilder();
        int[] words = new int[26];
        int i, j, k, len = S.length(), maxLen = 0, maxWord = 0, temp;

        for (i=0;i<len;i++) {
            temp = S.charAt(i) - 'a';
            words[temp]++;
            if (words[temp]>maxLen) {
                maxLen = words[temp];
                maxWord = temp;
            }
        }

        if (maxLen > (len+1)/2)
            return "";

        char word = (char) (maxWord + 'a');
        for (i=0;i<maxLen;i++)
            ans.append(word);
        words[maxWord] = 0;

        for (i=0,k=ans.length()-1;i<26;i++) {
            word = (char) (i + 'a');
            for (j=words[i];j>0;j--) {
                ans.insert(k--, word);
                if (k<0) k=ans.length()-1;
            }
        }

        return ans.toString();
    }
}
