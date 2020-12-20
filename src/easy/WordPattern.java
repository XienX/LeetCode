package easy;
/*290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false

示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false

示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false

说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
//    public boolean wordPattern(String pattern, String s) {
//        String[] ss = s.split(" ");
//        int len = pattern.length();
//        if (len != ss.length)
//            return false;
//
//        Map<Character, String> map = new HashMap<>();
//
//        for (int i=0;i<len;i++) {
//            if (map.containsKey(pattern.charAt(i))) {
//                if (!map.get(pattern.charAt(i)).equals(ss[i]))
//                    return false;
//            }
//            else {
//                if(map.containsValue(ss[i]))
//                    return false;
//                else
//                    map.put(pattern.charAt(i), ss[i]);
//            }
//        }
//
//        return true;
//    }

    public boolean wordPattern(String pattern, String str) { //双哈希表复杂度更低
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/word-pattern/solution/dan-ci-gui-lu-by-leetcode-solution-6vqv/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
