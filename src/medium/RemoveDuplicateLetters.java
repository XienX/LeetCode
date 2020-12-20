package medium;
/*316. 去除重复字母
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

示例 1：
输入：s = "bcabc"
输出："abc"

示例 2：
输入：s = "cbacdcbc"
输出："acdb"

提示：
1 <= s.length <= 104
s 由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicate-letters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new LinkedList<>();
        int[] nums = new int[26];
        boolean[] isOffered = new boolean[26];
        int len = s.length(), i;
        char tem;

        for (i=0;i<len;i++)
            nums[s.charAt(i)-'a']++;

        for (i=0;i<len;i++) {
            tem = s.charAt(i);

            if (isOffered[tem-'a']) {
                nums[tem-'a']--;
                continue;
            }

            while (!deque.isEmpty() && deque.peekLast() > tem) {
                if (nums[deque.peekLast() - 'a'] == 0)
                    break;
                isOffered[deque.pollLast() - 'a'] = false;
            }

            deque.offerLast(tem);
            isOffered[tem-'a'] = true;
            nums[tem-'a']--;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty())
            sb.append(deque.pollFirst());

        return sb.toString();
    }
}
