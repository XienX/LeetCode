package easy;
/*387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：
s = "leetcode"
返回 0

s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
//    public int firstUniqChar(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int len = s.length();
//
//        for (int i=0;i<len;i++)
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//
//        for (int i=0;i<len;i++)
//            if (map.get(s.charAt(i)) == 1)
//                return i;
//
//        return -1;
//    }

    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        int len = s.length();

        for (int i=0;i<len;i++)
            chars[s.charAt(i)-'a']++;

        for (int i=0;i<len;i++)
            if (chars[s.charAt(i)-'a'] == 1)
                return i;

        return -1;
    }
}
